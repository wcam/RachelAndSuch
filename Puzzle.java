package wheeloffortune;
import java.util.Scanner;
import java.util.Random;

public class Puzzle 
{
   public static String[] onTheMap = new String[5];
   public static String[] event = new String[5];
   public static String[] movieTitle = new String[5];
   public static String[] beforeAfter = new String[5];
   public static String[] whatAreYouDoing = new String[5];
   
   public String phrase;
   public boolean solved;
   public String category;
   
   public void setPhrase(String phrase)
   {
       this.phrase = phrase;
   }
   
   public void setCategory(String category)
   {
       this.category = category;
   }
}


