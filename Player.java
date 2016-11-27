package wheeloffortune;
import java.util.Scanner;

public class Player
{
   public String name;
   public int cashBalance;
   public int roundBalance;
   
   public void spinWheel()
   {
       
   }
   public void solvePuzzle(String guess, Puzzle p)
   {
       if(guess == p.phrase.toString())
       {
            p.solved = true;
       }
   }
   
   public void spinOrSolve(Puzzle p)
   {
       /*
        int matches = 0;
        char guess = 'o';
        char[] puzzlePhrase = p.phrase.toCharArray();

        for (int k = 0; k < p.phrase.length(); k++)
        {
            if (puzzlePhrase[k] == guess)
            {
                puzzleHidden[k] = puzzle[k];
                matches++;
            }
        }
                   
   	int spinSolve;
   	String guess;
   	
   	Scanner scanner = new Scanner(System.in);
   	// print the puzzle as it currently is
   	System.out.println(p.phrase);
       // get response
   	System.out.println("Would you like to spin [1] or solve [2]?");
   	spinSolve = scanner.nextInt();
       // spinWheel() if 1
   	if(spinSolve == 1)
   	{
            spinWheel();
   	}       
   	// solvePuzzle(String guess) if 2
   	else if(spinSolve == 2)
   	{
   	System.out.println("Please enter your guess: ");
   	guess = scanner.next();
   	solvePuzzle(guess, p);
   	}
   	else
   	{
            System.out.println("Invalid selection! Please enter either 1 or 2");
            spinOrSolve(p);
   	}*/
   }
   public void setName(String n)
   {
   	this.name = n;
   }
}
