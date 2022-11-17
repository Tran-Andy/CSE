/**
 * Player.java creates the attributes and methods that a Player would have.
 *
 * @author Tran-Andy
 * @version 1.0
 */
public class Player {
    /**
     * Contains the attributes of the Public Player Class that can create Players.
     */
    String Name;
    int Level;
    int AC;
    int XP;
    int HP;
    int STR;
    int DEX;
    int CON;
    Weapon Weapon;

    /**
     * Instance of Player Class. The Attack Method checks the player AC and determine if it is possible to attack.
     * @param player The specified player with its attributes.
     */
    void attack(Player player) {
        int damage = this.rollHit();
        if(this.rollHit() >= player.AC)
        {
            System.out.println("The " + this.Weapon.Name + "Has Landed a Hit!");
            takeDamage(damage);
        }
        else{
            System.out.println("The " + this.Weapon.Name + "Has Failed To Land A Hit...");

        }

    }

    /**
     * rollHit determines the probability that a Weapon can damage a player. It rolls based on the weapon roll and its bonus.
     * @return The result(probability) of getting hit.
     */
     int rollHit(){
        int probability = this.Weapon.rollDamage() + this.Weapon.Bonus;
        System.out.println("The " + this.Weapon.Name + "has a probability to hit of " + probability);
        return probability;

    }

    /**
     * Inflicts Damage based on the amount of HP attributes are present. Uses an If else in order to correctly check the HP value.
     * @param damage The damage that is going to be inflicted.
     */
     void takeDamage(int damage){
        int HP = this.HP;
        if ((HP > 0))
        {
            System.out.println("Inflicted Damage: " + damage);
            HP = HP - damage ;
            System.out.println("The Enemy has " + HP + "HP Left.");
        }else
        {
            HP = 0;
            System.out.println("HP is 0. Enemy is Dead");
        }

    }

    /**
     * Explicit value constructor for Player. This Accepts the attributes that a player has (7<code>int</code>s)(1<code>String</code>).
     * @param Name Name Assignment for the Name Attribute
     * @param Level Level Assignment for the Level Attribute
     * @param AC AC Assignment for the AC Attribute
     * @param XP XP Assignment for the XP Attribute
     * @param HP HP Assignment for the HP Attribute
     * @param STR STR Assignment for the STR Attribute
     * @param DEX DEX Assignment for the DEX Attribute
     * @param CON CON Assignment for the CON Attribute
     * @param Weapon Weapon Assignment for the Weapon Attribute
     */
    public Player(String Name, int Level, int AC, int XP, int HP, int STR, int DEX, int CON, Weapon Weapon)
    {
        this.Name = Name;
        this.Level = Level;
        this.AC = AC;
        this.XP = XP;
        this.HP = HP;
        this.STR = STR;
        this.DEX = DEX;
        this.CON = CON;
        this.Weapon = Weapon;

    }

    /**
     * toString for PlayerTest which returns the correct format of each attribute.
     * @return returning the toString that gives the information of the attributes.
     */
    @Override
    public String toString(){
        return  "Name: " + this.Name + "\n" +
                "Level: " + this.Level + "\n" +
                "AC: " + this.AC + "\n" +
                "XP: " + this.XP + "\n" +
                "HP: " + this.HP + "\n" +
                "STR: " + this.STR + "\n" +
                "DEX: " + this.DEX + "\n" +
                "CON: " + this.CON + "\n" +
                "Weapon: " + this.Weapon + "\n";

    }
}


