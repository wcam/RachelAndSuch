package wheeloffortune;
import java.util.Scanner;

public class Player
{
   public String name;
   public int cashBalance;
   public int roundBalance;
   
   public void solvePuzzle(String guess, Puzzle p)
   {
       if(guess == p.phrase.toString())
       {
            p.solved = true;
       }
   }
   
   public boolean spinOrSolve(Puzzle p)
   {
       boolean successfulGuess = false;
       
       int choice = Tester.getUserInt("(1) spin (2) solve");
       
       int money = spinWheel();
       System.out.println("The wheel landed on: " + money);
       
       String guessInput = Tester.getUserInput("Enter a character: ");
       char guessLetter = guessInput.charAt(0);
       
       System.out.println("PUZZLE: " + p.getHiddenPhrase() + " and you guessed " + guessLetter);
       
        int matches = 0;
        String puzzlePhrase = p.getHiddenPhrase();
        char[] thisPuzzle = puzzlePhrase.toCharArray();
        
        for (int k = 0; k < thisPuzzle.length; k++)
        {
            if (p.phrase[k] == guessLetter)
            {
                p.hiddenPhrase[k] = p.phrase[k];
                matches++;
                roundBalance = roundBalance + money;
                successfulGuess = true;
            }
        }
        
        System.out.println("Found " + matches + " matches! Round balance: " + roundBalance);
        System.out.println(p.getHiddenPhrase());
        return successfulGuess;
   }
   
   public void setName(String name)
   {
   	this.name = name;
   }
   
   public int spinWheel()
   {
       return Tester.randomNumber(0, 500);
   }
}
