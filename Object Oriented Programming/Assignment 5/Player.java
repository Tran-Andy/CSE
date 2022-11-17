public class Player {
    private String name;
    private String AvatarFile;
    private String Weapons;
    private String STR,DEX,CON;

    public String getSTR() {
        return STR;
    }

    public void setSTR(String STR) {
        this.STR = STR;
    }

    public String getDEX() {
        return DEX;
    }

    public void setDEX(String DEX) {
        this.DEX = DEX;
    }

    public String getCON() {
        return CON;
    }

    public void setCON(String CON) {
        this.CON = CON;
    }
    public String getWeapons() {
        return Weapons;
    }

    public void setWeapons(String weapons) {
        Weapons = weapons;
    }

    public String getAvatarFile() {
        return AvatarFile;
    }

    public void setAvatarFile(String avatarPath) {
        AvatarFile = avatarPath;
    }

    public Player(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setName(String Name){
        name = Name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
