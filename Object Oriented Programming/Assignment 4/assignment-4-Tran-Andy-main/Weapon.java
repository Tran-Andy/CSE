import Utility.GameUtility;

/**
 * Weapon.java is the class designed for creating a weapon.
 *
 * @author Tran-Andy
 * @version 1.0
 *
 */
public class Weapon {
    /**
     * String Name represents the name of a Weapon and DiceType represents the type of dice that a weapon uses.
     */
    String Name;
    String DiceType;
    int Bonus;


    /**
     * Explicit constructor for Weapon. Accepts what's needed for Weapons (2 <code>String</code>s)(1<code>int</code>).
     * @param WeaponType Assignment for the WeaponType Attribute
     * @param dice Assignment for the DiceType Attribute
     * @param bonus Assignment for the bonus Attribute
     */
    public Weapon(String WeaponType, String dice, int bonus)
    {
        this.DiceType = dice;
        this.Name = WeaponType;
        this.Bonus = bonus;
    }

    /**
     * returns the values of the RollDice method in the GameUtility Class based on the DiceType attribute.
     * @return returns the result of RollDice using the DiceType attribute.
     */
    public int rollDamage() {
        return GameUtility.RollDice(this.DiceType)  + this.Bonus;

    }


    /**
     * Overrides the toString() method in order to return information based on the format [Dagger (1d4+4)].
     * @return returning the string result based on the format Dagger (1d4+4).
     */
    @Override
    public String toString()
    {
        return this.Name;
    }
}
