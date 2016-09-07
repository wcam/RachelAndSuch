package helloworld;

public class BankAccount 
{
    public int checkingAccountBalance;
    public int savingsAccountBalance;
    public double certificateOfDeposit;
    
    public double getCDAmount()
    {
        return this.certificateOfDeposit;
    }
    
    public static double applyInterest(double amount)
    {
        return amount*1.05;
    }
    
    public BankAccount()
    {
        
    }
    public BankAccount(double amount)
    {
        this.certificateOfDeposit = amount;
    }
}
