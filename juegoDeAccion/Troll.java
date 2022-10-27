public class Troll extends Character
{
    public Troll()
    {
        weapon = new AxeBehaviour();
    }

    public void fight()
    {
        System.out.println("I'm the Troll");
    }
}
