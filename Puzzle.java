package wheeloffortune;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Puzzle 
{
   public boolean solved;
   public String category;
   
   public int puzzleNumber;
   public char[] phrase;
   public char[] hiddenPhrase;
   
   public void setPhrases(String tempPhrase)
   {
       this.phrase = tempPhrase.toCharArray();
       this.hiddenPhrase = setHiddenPhrase();
   }
   
   public char[] setHiddenPhrase()
   {
       char[] thePhraseOfThisObject = new char[phrase.length];
       thePhraseOfThisObject = phrase.clone();
       
       thePhraseOfThisObject = setHiddenPhrase(thePhraseOfThisObject);
       
       return thePhraseOfThisObject;
   }
   
   public void setCategory(String category)
   {
       this.category = category;
   }
   
   public void setPuzzleNumber(int pn)
   {
       this.puzzleNumber = pn;
   }
   
   public int getPuzzleNumber()
   {
       return puzzleNumber;
   }
   
   public char[] setHiddenPhrase(char[] tempPhrase)
   {
       for (int i = 0; i < tempPhrase.length; i++)
       {
           if (tempPhrase[i] != ' ')
           {
               tempPhrase[i] = '*';
           }
           else
           {
               tempPhrase[i] = ' ';
           }
       }
       return tempPhrase;
   }
   
   public void setSolved(boolean solved)
   {
       this.solved = solved;
   }
   
   public boolean getSolved()
   {
       return solved;
   }
   
   public String getHiddenPhrase()
   {
       String x = "";
       for (int i = 0; i < hiddenPhrase.length; i++)
       {
           x = x + hiddenPhrase[i];
       }
       return x;
   }
   
   public String getPhrase()
   {
       String myString = new String(phrase);
       return myString;
   }
   
   @Override
   public String toString()
   {
       String result = new String();
       result = "Puzzle #" + getPuzzleNumber() + ", Phrase: " + getPhrase() + ", Category: " + category;
       return result;
   }
   
   public String getCategory()
   {
       return category;
   }
}
