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
       
       System.out.println("It's your turn " + getName() + "! Spin or solve? " + p.getHiddenPhrase());
       System.out.println("Puzzle #" + p.getPuzzleNumber() + ", " + p.getCategory());
       int choice = Tester.getUserInt("(1) spin (2) solve");
       
       switch(choice)
       {
           case 1:
               int money = spinWheel();
               
               if (money == 9999)
               {
                   System.out.println("You lost your turn! :(");
               }
               else if (money == 0000)
               {
                   System.out.println("You are BANKRUPT! Ouch! :(");
                   System.out.println("¯\\_(ツ)_/¯");
                   setRoundBalance(0);
               }
               else
               {
                   System.out.println("The wheel landed on: " + money);
       
                    String guessInput = Tester.getUserInput("Enter a character: ");
                    char guessLetter = guessInput.charAt(0);

                    System.out.println(getName() + " guessed " + guessLetter);

                     int matches = 0;
                     String puzzlePhrase = p.getHiddenPhrase();
                     char[] thisPuzzle = puzzlePhrase.toCharArray();

                     for (int k = 0; k < thisPuzzle.length; k++)
                     {
                         if (p.phrase[k] == guessLetter)
                         {
                             p.hiddenPhrase[k] = p.phrase[k];
                             matches++;
                             successfulGuess = true;
                         }
                     }
                    setRoundBalance(getRoundBalance() + money * matches);
                    System.out.println("Found " + matches + " matches!");
                    System.out.println(p.getHiddenPhrase());
               }
                break;
           case 2:
               String guess = Tester.getUserInput("Try to solve!: ");
               String theCorrectphrase = p.getPhrase();
               
               if (guess.equals(theCorrectphrase))
               {
                   successfulGuess = true;
                   p.setSolved(true);
                   setCashBalance(getCashBalance() + getRoundBalance());
                   System.out.println("Success! Your total for the day is  $" + getCashBalance());
               }
               else
               {
                   System.out.println("fail.");
                   successfulGuess = false;
               }
               break;
       }
       
        return successfulGuess;
   }
   
   public void setName(String name)
   {
   	this.name = name;
   }
   
   public void setCashBalance(int cash)
   {
       this.cashBalance = cash;
   }
   
   public int getCashBalance()
   {
       return cashBalance;
   }
   
   public int spinWheel()
   {
       int spin = Tester.randomNumber(0, 11);
       int result = 0;
       
       switch(spin)
       {
           case 0:
                result = 550;
                break;
           case 1:
                result =  600;
                break;
           case 2:
                result =  650;
                break;
           case 3:
                result =  700;
                break;
           case 4:
                result =  750;
                break;
           case 5:
                result =  750;
                break;
           case 6:
                result =  800;
                break;
           case 7:
                result =  850;
                break;
           case 8:
                result =  900;
                break;
           case 9:
                result =  500;
                break;
           case 10:
                result =  9999;
                break;
           case 11:
                result =  0000;
                break;
       }
       return result;
   }
   
   public int getRoundBalance()
   {
       return roundBalance;
   }
   
   public void setRoundBalance(int money)
   {
       roundBalance = money;
   }
   
   public String getName()
   {
       return name;
   }
}
