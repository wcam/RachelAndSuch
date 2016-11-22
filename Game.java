package wheeloffortune;

import java.util.Scanner;

public class Game 
{
    Player[] players;
    Player currentPlayer;
    int currentPlayerNum;
    int maxPlayerNum;
    int prize = 0;  // does each round of the game have a prize?  not sure what this does
    String puzzleStr;
    char[] puzzle;  // isnt this what puzzleStr is?
    char[] puzzleHidden;
    Wheel wheel;
    int roundCount;

    public Game()
    {
        wheel = new Wheel();

        maxPlayerNum = 99;
        players = new Player[maxPlayerNum];
        currentPlayerNum = 0;

        currentPlayer = new Player();
    }
    
    // Game funGame = new Game();
    // funGame.nextPlayer();  
    // how are things different after this function is called?
    public void nextPlayer()
    {
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

        // should this method be responsible for making this call? it's already handling a lot of responsibility
        play();
    }

    // shouldnt a Player be the object that plays?  rachel.play(); for example?
    // what does it mean for a Game object to play?
    // does this cover more than one round?  it's unclear what is supposed to be accomplished in this method
    // how about askForSolve(); or getLetter(); or something
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
            // All of this can go in its own method so play() doesn't handle the logic for this.
            // if you ever wanted to change the text or something, you don't want to have to worry about the entire method (Single reponsibility principle)
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
        int spin = wheel.spin(); //sets spin to a value obtained from the wheel.spin method

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
          // All this can go in its own method too, it's doing way too much
                System.out.printf("\nThe prize is: %d", spin); // IF RNG returned a prize , prints the prize
                prize = spin;
                int i = 0;
                
                // Took out the comments since I wasn't sure they were telling the truth or not
                // If the variable names and method names describe themselves well, comments wont be as necessary
                while(i == 0)
                { 
                    System.out.printf("\nPick a letter!");
                    Scanner scanner = new Scanner(System.in);
                    String letterStr = scanner.nextLine();
                    char[] letters = letterStr.toCharArray();
                    char letter = letters[0];

                    i++;
                    int count = checkForMatch(letter);
                    currentPlayer.addGameBalance(count * prize); 
                    play();		
                }
        }
    }

    public void roundEnd()
    { //end of a round reduces the roundCount, re-entering the while loop
        // *maybe increment roundsPlayed instead?  sorry just trying to help :)
        roundCount--;	
    }

    // The game can go bankrupt?  How about setBankrupt(Player p), and you could pass currentPlayer to it
    public void bankrupt()
    {
        System.out.printf("Sorry You've hit Bankrupt!!");
        currentPlayer.setRoundBalance(0);	//sets current player round balance to 0
        nextPlayer(); //calls the next player
    }

    public char[] convertToHidden(char[] puzzleHidden)
    {
        // easier to read imo
        final char space = ' ';
        final char underscore = '_';
        final char star = '*';
        
        int i = 0;
        while(i < puzzleHidden.length)
        {
            if(puzzleHidden[i] == underscore)
            {
                puzzleHidden[i] = space;
            }
            else
            {
                puzzleHidden[i] = star;
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

            if(c == ' ')
            { //prevents player from entering wrong characters
                System.out.println("Invalid input");
                return count;
            }

            for(int i = 0; i < puzzle.length ;i++)
            { //cycles through the puzzle array
                if(c == puzzleHidden[i])
                { 
                        System.out.println("Letter has been used before");
                        return 0;
                }
            }

            System.out.println(puzzle.length); //debugging purposes

            for(int i = 0; i < puzzle.length ;i++)
            {
                if(c == puzzle[i])
                { 
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
