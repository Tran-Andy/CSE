import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
public class Tester {
    public static void main(String[] args)
    {
        ArrayList<Creature> creatureArrayList = new ArrayList<>();
        creatureArrayList.add(new Player("Bilbo",100,15,20,11,5,"The Ring",1));
        creatureArrayList.add(new Player("Aragorn",200,25,30,15,10,"Anduril",3));
        creatureArrayList.add(new Monster("Air Elemental",90,15,7,10,7));
        creatureArrayList.add(new Monster("Bandit",11,12,5,6,6));
        creatureArrayList.add(new Monster("Ghost",45,1,3,6,5));

        creatureArrayList.sort(Comparator.comparing(Creature::getHP));
        testCombat(creatureArrayList);


    }
    public static void testCombat(ArrayList<Creature> list){
        int size = 4;
        int random1;
        int random2;
        Random r = new Random();
        for(int i = 0; i < size;i++) {

           random1 = r.nextInt(size);
           random2 = r.nextInt(size);

            list.get(random1).attack(list.get(random2));

        }

    }

}
