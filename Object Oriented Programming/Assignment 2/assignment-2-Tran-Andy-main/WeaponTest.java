/**
 * WeaponTest.java tests the Weapon class in Weapon.java
 *
 * @author Tran-Andy
 * @version 1.0
 */
public class WeaponTest {
    /**
     * The main method for the WeaponTest.java class which tests the Weapon.java class.
     * @param args argument for main method Test
     */
    public static void main(String[] args) {

        Weapon draco = new Weapon("draco", "d6", 100);
        System.out.println(draco);
        System.out.println(draco.rollDamage());
        System.out.println(draco.rollDamage());

    }
}
