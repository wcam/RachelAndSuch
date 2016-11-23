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
    
    public static void setPhrases()
    {
        onTheMap[0] = "This is OnTheMap One";
        onTheMap[1] = "This is OnTheMap Two";
        onTheMap[2] = "This is OnTheMap Three";
        onTheMap[3] = "This is OnTheMap Four";
        onTheMap[4] = "This is OnTheMap Five";
        
        event[0] = "This is event One";
        event[1] = "This is event Two";
        event[2] = "This is event Three";
        event[3] = "This is event Four";
        event[4] = "This is event Five";
        
        movieTitle[0] = "This is OnTheMap One";
        movieTitle[1] = "This is OnTheMap Two";
        movieTitle[2] = "This is OnTheMap Three";
        movieTitle[3] = "This is OnTheMap Four";
        movieTitle[4] = "This is OnTheMap Five";
        
        beforeAfter[0] = "This is beforeAfter One";
        beforeAfter[1] = "This is beforeAfter Two";
        beforeAfter[2] = "This is beforeAfter Three";
        beforeAfter[3] = "This is beforeAfter Four";
        beforeAfter[4] = "This is beforeAfter Five";
        
        whatAreYouDoing[0] = "This is whatAreYouDoing One";
        whatAreYouDoing[1] = "This is whatAreYouDoing Two";
        whatAreYouDoing[2] = "This is whatAreYouDoing Three";
        whatAreYouDoing[3] = "This is whatAreYouDoing Four";
        whatAreYouDoing[4] = "This is whatAreYouDoing Five";
    }
    
    public Puzzle()
    {
        setPhrases();
        int randomCategory = randomNumber(4);
        int randomPhrase = randomNumber(4);
        
        setPhrase(randomCategory, randomPhrase);
    }
    
    public static void setPhrase(int randomCategory, int randomPhrase)
    {
        switch(randomCategory)
        {
            case 0:
                //get
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
    
    public static int randomNumber(int number)
    {
        Random rn = new Random();
        int randomNumber = rn.nextInt(number);
        return randomNumber;
    }
}
