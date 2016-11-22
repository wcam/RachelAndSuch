import java.util.Scanner;

public class Game 
{
	Player[] players = new Player[99]; //instantiates the players array
	static Player currentPlayer = new Player(); //creates a current player placeholder object
	int currentPlayerNum = 0; //keeps track of which player's turn it is
	static int maxPlayerNum = 0; //the number of players
	int prize = 0; //the result of spinning the wheel
	String puzzleStr; //creates the puzzle string
	static char[] puzzle; //creates the puzzle char array which the string will be converted into
	char[] puzzleHidden; //creates a second puzzle to hold the encrypted values
	Wheel wheel = new Wheel();
        
	public void nextPlayer()
        {							//loads in the next player into the current player object
            System.out.println(players[0].getName());
            players[currentPlayerNum].addRoundBalance(currentPlayer.getRoundBalance() - players[currentPlayerNum].getRoundBalance());
            currentPlayer.setRoundBalance(0);
            System.out.println(maxPlayerNum);
            if(currentPlayerNum == maxPlayerNum-1)
            {
                currentPlayerNum = 0;
            }
            else 
            {
                currentPlayerNum++;
            }
            currentPlayer.setRoundBalance(players[currentPlayerNum].getRoundBalance());
            currentPlayer.setGameBalance(players[currentPlayerNum].getGameBalance());
            currentPlayer.setName(players[currentPlayerNum].getName());
            play();
	}
	
	public void play()
        {
            System.out.printf("It's %s's Turn!\nWould you like to spin[1] or solve?[2]\n", currentPlayer.getName());
            Scanner scanner = new Scanner(System.in); 
            int choice = scanner.nextInt();
            if(choice == 1)
            { //if player chooses to spin
                    spin();
            }
            else if(choice == 2)
            {
                System.out.printf("%s: Enter your guess!:", currentPlayer.getName());
                Scanner scanner1 = new Scanner(System.in);
                String guess = scanner1.nextLine(); //sets user's reply to guess

                if(checkGuess(guess) == true)
                {
                    System.out.printf("Congrats! you've Won the Round!"); //if yes
                    roundEnd();
                }
                else
                {
                    System.out.printf("Sorry that is incorrect!"); //if no
                    nextPlayer();
                }
            }
	}
	
	public void spin()
        {
            int spin = Wheel.spin(); //sets spin to a value obtained from the wheel.spin method

            if(spin == 99)
            { 
                    bankrupt(); //if RNG returned bankrupt, call bankrupt method, which leads to next player after setting round balance to 0
            }
            else if (spin == 98)
            {
                    System.out.printf("\nSorry Lose a turn"); //if RNG returned lose a turn, calls next player
                    nextPlayer();
            }
            else 
            {
                System.out.printf("\nThe prize is: %d", spin); // IF RNG returned a prize , prints the prize
                prize = spin;
                int i = 0;

                while(i == 0)
                { //ensures that the player only enters in one number
                    System.out.printf("\nPick a letter!");
                    Scanner scanner = new Scanner(System.in);
                    String letterStr = scanner.nextLine(); //takes in the letter as a string
                    char[] letters = letterStr.toCharArray(); //converts to char array
                    char letter = letters[0];
                    //if(letter.length > 1){ //tests if user entered more than one letter
                    //	System.out.printf("Please Enter only one Letter");
                    //}

                    i++;
                    int count = checkForMatch(letter); //checks the letter entered against the puzzle
                    currentPlayer.addGameBalance(count * prize); //adds the balance to the current player 
                    play(); //calls play method without incrementing the currentPlayerNum		
                }
            }
	}
	
	public void roundEnd()
        { //end of a round reduces the roundCount, re-entering the while loop
            roundCount--;	
	}
	
	public void bankrupt()
        {
            System.out.printf("Sorry You've hit Bankrupt!!");
            currentPlayer.setRoundBalance(0);	//sets current player round balance to 0
            nextPlayer(); //calls the next player
	}
	
	public static char[] convertToHidden(char[] puzzleHidden)
	{
            int i = 0;
            while(i < puzzleHidden.length)
            {
                if(puzzleHidden[i] == '_')
                { //converts underscores to spaces
                        puzzleHidden[i] = ' ';
                }
                else
                {
                        puzzleHidden[i] = '*'; //converts everything else to *
                }
                i++;
            }

            return puzzle; //returns the hidden puzzle
	}
	
	public boolean checkGuess(String checkStr)
        {
            System.out.println(puzzle);
            int matchCheck = 0;
            char[] check = checkStr.toCharArray();
            for(int i = 0; i < check.length; i++)
            { //cycles through the array and compares it against what was entered
                if(check[i] == puzzle[i])
                {
                        matchCheck++; //each correct match  increase matchCount by 1
                }		
            }
            if(matchCheck == puzzle.length)
            { //if the total number of matches is equal to the length of the array then the guess was correct
                return true;			
            }
            else
            {
                return false;
            }
	}
	
	public int checkForMatch(char c)
	{
		int count = 0;
		if(c == ' '){ //prevents player from entering wrong characters
			System.out.println("Invalid input");
			return count;
		}
		for(int i = 0; i < puzzle.length ;i++){ //cycles through the puzzle array
			if(c == puzzleHidden[i]){ 
				System.out.println("Letter has been used before");
				return 0;
			}
		}
		System.out.println(puzzle.length); //debugging purposes
		for(int i = 0; i < puzzle.length ;i++){ //cycles through the puzzle array
			if(c == puzzle[i]){ 
				count++;
			}
		}
		if(count == 0) 
                
                {
			System.out.println("Sorry there were no Matches found");
		}
		else
                {
                    System.out.printf("\nCongratulations there were %d matches", count);	
		}
		return count;
	}
}
