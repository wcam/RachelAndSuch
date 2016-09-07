package helloworld;

public class HelloWorld 
{
    public static void main(String[] args) 
    {
        Person rachel = new Person(10, "Rachel", "Lamfun");
        BankAccount ba = new BankAccount(15000.0);
        
        rachel.ba = ba;
        rachel.whoIsThisPerson();
        
        int numberOfMonths = checkDoubleYourCD(rachel);
        System.out.println("The number of months it takes to double your money is: " + numberOfMonths);
    }
    
    public static int checkDoubleYourCD(Person p)
    {
        boolean numberOfMonthsFound = false;
        double thisPersonsCD = p.ba.getCDAmount();
        int count = 0;
        double amount = thisPersonsCD;
        
        while (!numberOfMonthsFound)
        {
            amount = p.ba.applyInterest(amount);
            count = count + 1;
            
            if (amount >= thisPersonsCD*2)
            {
                numberOfMonthsFound = true;
            }
        }
        return count;
    }
}