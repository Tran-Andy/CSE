import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

public class LogFile {

    public static void main(String[] args) throws IOException
    {
        //Simple Scan
        Scanner arg = new Scanner(System.in);
        //Enter Username
        System.out.println("Username: ");
        String Username = arg.nextLine();
        //Enter Message
        System.out.println("Message: ");
        String Message = arg.nextLine();

        //Assigns the String Date to CSV and Splits it in order to correctly output.
            String CSV = LocalDateTime.now().toString();
            String CSV2 = CSV.split("[|T]+")[0];
            String File = Username + "-" + CSV2 + ".log";
            FileWriter fw = new FileWriter(File, true);
            PrintWriter pw = new PrintWriter(fw);
            //Print In Log
            pw.println(Username + "," + Message + "," + CSV);
            pw.close();

            System.out.println("Please Check The Current Directory!");


    }
}
