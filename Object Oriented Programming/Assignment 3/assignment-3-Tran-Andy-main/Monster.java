import Utility.GameUtility;

public class Monster extends Creature{
    int ChallengeRating;
    public Monster(String name, int hp, int ac, int str, int dex, int con) {
        super(name, hp, ac, str, dex, con);
        setChallengeRating(getChallengeRating());
    }

    private int rollHit(){
            if((this.getDEX() -5) < 10){
                this.setDEX(10);
            }
            return GameUtility.RollDice("d20") + this.getDEX();
        }
    public void setChallengeRating(int challengeRating){ ChallengeRating = challengeRating;}

    public int getChallengeRating(){ return ChallengeRating; }

    @Override
    public void attack(Creature creature){
        int roll = rollHit();
        if(roll >= creature.getAC()){
            creature.takeDamage(GameUtility.RollDice("d6") + getSTR());
            System.out.println(getName() + " attacks " + creature.getName() + " (" + roll + "to hit)" + "...HITS!");
        }
        else{
            System.out.println(getName() + " attacks " + creature.getName() + " (" + roll + "to hit)" + "...MISSES!");
        }
    }

}
