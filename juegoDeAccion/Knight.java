public class Knight extends Character 
{
    public Knight()
    {
        weapon = new BowAndArrowBehaviour();
    }
    
    public void fight()
    {
        System.out.println("I'm the Knight");
    }
}
