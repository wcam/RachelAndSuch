package wheeloffortune;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Puzzle 
{
   public boolean solved;
   public String category;
   
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
       return Arrays.toString(phrase);
   }
   
   @Override
   public String toString()
   {
       String result = "";
       result = "Phrase: " + getPhrase() + ", Category: " + category;
       return result;
   }
}
