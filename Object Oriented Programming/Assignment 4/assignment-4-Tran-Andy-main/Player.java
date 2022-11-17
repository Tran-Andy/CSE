
public class Player extends Creature{
        Weapon Weapon;

    public Player(String name, int hp, int str, int dex, int con, String weapon,String diceType, int bonus) {
        super(name, hp, str, dex, con);
        setWeapon(new Weapon(weapon,diceType,bonus));
    }

    public static Player loadFromCsv(String input) throws CsvReadException {
        try{
            String[] CSV = input.split(",");
            String name = CSV[0];
            int hp = Integer.parseInt(CSV[1]);
            int str = Integer.parseInt(CSV[2]);
            int dex = Integer.parseInt(CSV[3]);
            int con = Integer.parseInt(CSV[4]);
            String weapon = CSV[5];
            String diceType = CSV[6];
            int bonus = Integer.parseInt(CSV[7]);

            Player player = new Player(name,hp,str,dex,con,weapon,diceType,bonus);
            return player;
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException e ){
            throw new CsvReadException(input);
        }

    }
    @Override
    public String toString(){
        return name +" "+ "HP: " + hp + " STR: " +  str + " DEX: " +  dex + " CON: " + con + "," + getWeapon() + "," + getWeapon().DiceType + "," + getWeapon().Bonus;
    }
//    private int rollHit(){
//        if((this.getDEX() -5) < 10){
//            this.setDEX(10);
//        }
//        return getWeapon().rollDamage() + this.getDEX() + getWeapon().Bonus;
//    }

    public Weapon getWeapon(){
        return Weapon;
    }
    public void setWeapon(Weapon weapon){
        this.Weapon = weapon;
    }

//    @Override
//    public void attack(Creature creature){
//        int roll = rollHit();
//        if(roll >= creature.getAC()){
//            creature.takeDamage(getWeapon().rollDamage() + getSTR());
//            System.out.println(getName() + " attacks " + creature.getName() + " with " + getWeapon()+ " (" + roll + "to hit)" + "...HITS!");
//        }
//        else {
//            System.out.println(getName() + " attacks " + creature.getName() + " with " + getWeapon()+ " (" + roll + "to hit)" + "...MISSES!");
//        }
//    }

}
