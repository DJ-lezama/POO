public class King extends Character  
{
    public King()
    {
        weapon = new KnifeBehaviour();
    }
    public void fight()
    {
        System.out.println("I'm the King");
    }
}
