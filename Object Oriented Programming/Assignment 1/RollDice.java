import java.util.Random;

public class RollDice
{
    public static void main(String[] args)
//    {
//        String str = "6d20+5";
//        String[] arrOfStr = str.split("[d+]+");
//
//        for (String a : arrOfStr)
//            System.out.println(a);
//    }
    {
        //[NUM]d[DICE]+[CONSTANT]

        int NUM = 1;
        int CONSTANT;
        int DICE;
        String dExpression = args[0];
        String[] arrOfStr = dExpression.split("[d+]+");
        int[] arrOfStr2= new int [arrOfStr.length];
        Random r = new Random();
        int result = 0;
        if(dExpression.matches("\\d*[d]\\d+[+]{0,1}\\d*"))
        {
            System.out.println("Valid String");

            if(!(arrOfStr[0].isEmpty()))
            {
                arrOfStr2[0] = Integer.parseInt(arrOfStr[0]);

            }
            else
            {
                arrOfStr2[0] = 1;
            }

            if(arrOfStr.length > 2)
            {
                CONSTANT = Integer.parseInt(arrOfStr[2]);
            }
            else
            {
                CONSTANT = 0;
            }

                for(int j = 1; j<=arrOfStr2[0];j++)
                {
                    result += r.nextInt(Integer.parseInt(arrOfStr[1])) ;
                    result++;

                }

                System.out.println(result + CONSTANT);
        }
        else
        {
            System.out.println("Invalid input");
        }

    }
}
