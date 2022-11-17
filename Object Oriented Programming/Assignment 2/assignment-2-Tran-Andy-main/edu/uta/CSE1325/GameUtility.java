package edu.uta.CSE1325;

import java.util.Random;

/**
 * GameUtility.java uses the RollDice Method with the format of [NUMDICE]d[DICETYPE]
 *
 * @author Tran-Andy
 * @version 1.0
 *
 */
public class GameUtility {
    /**
     * RollDice rolls a virtual dice based on the format [NUMDICE]d[DICETYPE]+[CONSTANT]. (1<code>String</code>)
     * @param dExpression The Given format of the Dice.
     * @return returning the result and constant.
     */
    public static int RollDice(String dExpression) {
        int NUM = 1;
        int CONSTANT;
        int DICE;
        String[] arrOfStr = dExpression.split("[d+]+");
        int[] arrOfStr2 = new int[arrOfStr.length];
        Random r = new Random();
        int result = 0;
        if (dExpression.matches("\\d*[d]\\d+[+]{0,1}\\d*")) {
            if (!(arrOfStr[0].isEmpty())) {
                arrOfStr2[0] = Integer.parseInt(arrOfStr[0]);

            } else {
                arrOfStr2[0] = 1;
            }

            if (arrOfStr.length > 2) {
                CONSTANT = Integer.parseInt(arrOfStr[2]);
            } else {
                CONSTANT = 0;
            }

            for (int j = 1; j <= arrOfStr2[0]; j++) {
                result += r.nextInt(Integer.parseInt(arrOfStr[1]));
                result++;

            }

            return result + CONSTANT;
        } else {
            System.out.println("Invalid input");
            return 0;
        }

    }


}
