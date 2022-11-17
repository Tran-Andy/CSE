public abstract class Creature implements Comparable<Creature> {
    String name;
    int hp;
    int ac;
    int str;
    int dex;
    int con;

public Creature(String name, int hp, int ac, int str, int dex, int con) {
    setName(name);
    setHP(hp);
    setAC(ac);
    setSTR(str);
    setDEX(dex);
    setCON(con);
}

    public Creature(String name, int hp, int str, int dex, int con) {
        setName(name);
        setHP(hp);
        setSTR(str);
        setDEX(dex);
        setCON(con);

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setAC(int ac) {
        this.ac = ac;
    }

    public void setSTR(int str) {
        this.str = str;
    }

    public void setDEX(int dex) {
        this.dex = dex;
    }

    public void setCON(int con) {
        this.con = con;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }


    public int getAC() {
        return ac;
    }

    public int getSTR() {
        return str;
    }

    public int getDEX() {
        return dex;
    }

    public int getCON() {
        return con;
    }
//        public void takeDamage(int dmg) {
//            int HP = getHP();
//            if ((HP < 0))
//            {
//                setHP(0);
//                System.out.println("HP is 0." + getName() + " is dead.");
//            }else
//            {
//                System.out.println(getName() + " takes " + dmg + " points of damage");
//                setHP(HP-dmg);
//
//            }
//        }
//    public abstract void attack (Creature creature);
    @Override
    public int compareTo(Creature creature) {
        return this.hp-creature.getHP();
    }

    public boolean equals(Object o) {
        return o != null
                && getClass() == o.getClass()
                && name.equals(((Creature) o).getName());
    }
}



