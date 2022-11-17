import Utility.GameUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args) throws IOException {

        System.out.println("1. Test name validation");
        System.out.println("2. Test player file loading and sorting");
        Scanner sc = new Scanner(System.in);
        int scan = sc.nextInt();
        if (scan == 1) {
            nameValidation();
        } else if (scan == 2) {
            files();
        }

    }

    public static void nameValidation() {
        System.out.print("Enter a name: ");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        GameUtility.validateName(name);

    }

    public static void files() throws IOException {
        File folder = new File("data");
        String file;
        ArrayList<Creature> player = new ArrayList<>();
        for (File files : Objects.requireNonNull(folder.listFiles())) {
            try {
                String fileName = files.getPath();
                file = fileName.substring(fileName.lastIndexOf(".") + 1);
                Scanner sc = new Scanner(new File(fileName));
                while (sc.hasNextLine()) {
                    player.add(Player.loadFromCsv(sc.nextLine()));
                }
                if (!(file.equalsIgnoreCase("csv"))) {
                    throw new FileNotFoundException();
                }
            } catch (CsvReadException e) {
                System.out.println("File Not Found");
                continue;
            }
            player.sort(Comparator.comparing(Creature::getHP));

        }
        for(Creature name:player){
            System.out.println(name);
        }

    }
}


//        //Scanner scan = new Scanner(new File("data")); results in error due to reading a directory
//        File[] list = new File("data").listFiles();
//        for(int i = 0; i < Objects.requireNonNull(list).length; i++){
//            System.out.println(list[i]);//testing to see if the list works
//            list[i].
////            while(hasNext) ?? use scanner to scanner through each file?
//        }



