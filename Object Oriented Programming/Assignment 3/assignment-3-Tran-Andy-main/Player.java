public class Player extends Creature{
        Weapon Weapon;

    public Player(String name, int hp, int ac, int str, int dex, int con, String weapon, int bonus) {
        super(name, hp, ac, str, dex, con);
        setWeapon(new Weapon(weapon,"d20",bonus));
    }
    private int rollHit(){
        if((this.getDEX() -5) < 10){
            this.setDEX(10);
        }
        return getWeapon().rollDamage() + this.getDEX() + getWeapon().Bonus;
    }
    public Weapon getWeapon(){
        return Weapon;
    }
    public void setWeapon(Weapon weapon){
        this.Weapon = weapon;
    }

    @Override
    public void attack(Creature creature){
        int roll = rollHit();
        if(roll >= creature.getAC()){
            creature.takeDamage(getWeapon().rollDamage() + getSTR());
            System.out.println(getName() + " attacks " + creature.getName() + " with " + getWeapon()+ " (" + roll + "to hit)" + "...HITS!");
        }
        else {
            System.out.println(getName() + " attacks " + creature.getName() + " with " + getWeapon()+ " (" + roll + "to hit)" + "...MISSES!");
        }
    }

}
