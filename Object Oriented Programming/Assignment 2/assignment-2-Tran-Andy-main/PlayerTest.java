/**
 * PlayerTest.java tests the Player class in Player.java
 *
 * @author Tran-Andy
 * @version 1.0
 */
public class PlayerTest {
    /**
     * The main method for the PlayerTest class which tests the Weapon.java class.
     * @param args argument for main method Test
     */
    public static void main(String[] args)
    {
        Weapon Weapon1 = new Weapon("draco ","4d6+1",10);
        Weapon Weapon2 = new Weapon("dat Gat ","4d6+1", 8);

        Player GangMember = new Player("Andy",20,25,10000,250,20,20,20,Weapon1);
        Player MafiaBoss = new Player("Mr.WorldWide",20,20,10000,250,20,20,20,Weapon2);

        System.out.println(GangMember);
        System.out.println("Attacks!\n    /\n" +
                "O===[====================-\n" +
                "    \\");
        System.out.println(MafiaBoss);
        GangMember.attack(MafiaBoss);

    }
}
