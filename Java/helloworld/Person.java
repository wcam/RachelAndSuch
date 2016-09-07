package helloworld;

public class Person
{
    public int age;
    public String first;
    public String last;
    public BankAccount ba;
    
    public Person(int age, String first, String last)
    {
        this.age = age;
        this.first = first;
        this.last = last;
    }
    
    public String getFirst()
    {
        return this.first;
    }
    public String getLast()
    {
        return this.last;
    }
    public int getAge()
    {
        return this.age*2;
    }
    
    public void whoIsThisPerson()
    {
        System.out.println("This person is " + this.getAge() + " years old");
        System.out.println("The first name is " + this.getFirst());
        System.out.println("The last name is " + this.getLast());
    }
}
