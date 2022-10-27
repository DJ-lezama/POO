public abstract class Character
{
    WeaponBehaviour weapon;

    public void performFight()
    {
        weapon.useWeapon();
    }

    public abstract void fight();

    public void showCharacter()
    {
        fight();
        performFight();
        
    }

    public void setWeapon(WeaponBehaviour w)
    {
        this.weapon = w;
    } 
}
