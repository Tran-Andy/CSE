import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class SortNumbers
{
    public static void main(String[] args) throws IOException
    {
        String FileName = args[0];
        BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
        File FR = new File(FileName);
        Scanner scan = new Scanner(FR);
        int Size = 100;
        int maxNums = 0;
        int invalidEntries = 0;
        int random = -1;
        int[] Nums = new int[Size];

        while(scan.hasNextLine())
        {
            try {
                random = Integer.parseInt(scan.nextLine());
                maxNums++;
                Nums[maxNums - 1] = random;
            }
            catch(Exception e){
                invalidEntries++;
            }
        }
        Arrays.sort(Nums);
        for(int i = Size-maxNums;i<Size;i++)
        {
            writer.write(String.valueOf(Nums[i]));
            writer.newLine();
        }
        System.out.print("\nInvalid Entries: ");
        System.out.println(invalidEntries);
        String fileContent = "Invalid Entries: " + invalidEntries;
        writer.write(fileContent);
        System.out.print("\nPlease Check The Out.txt File!");
        writer.close();
    }

}
