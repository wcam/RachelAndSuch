package helloworld;

public class HelloWorld 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        Person p = createPerson();
        p.age = 15;
        System.out.println(p.age);
    }
    
    public static Person createPerson()
    {
        Person p = new Person();
        return p;
    }
}