public class Queen extends Character
{
    public Queen()
    {
        weapon = new SwordBehaviour();
    }
    
    public void fight()
    {
        System.out.println("I'm the Queen");
    }
}
