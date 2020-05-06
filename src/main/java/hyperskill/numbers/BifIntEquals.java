package hyperskill.numbers;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Alice wrote a method for checking if at least two given BigInteger numbers are equal. 
 * But she has made several mistakes and the method works incorrectly.

Try to fix it.
 */
public class BifIntEquals {
    public static boolean atLeastTwoAreEqual(BigInteger num1, BigInteger num2, BigInteger num3) {

        return num1.equals(num2) || num1.equals(num3) || num2.equals(num3); // fix
                                                                            // this
                                                                            // line
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] parts = scanner.nextLine().split("\\s+");

        BigInteger num1 = null;
        BigInteger num2 = null;
        BigInteger num3 = null;

        try {
            num1 = new BigInteger(parts[0]);
            num2 = new BigInteger(parts[1]);
            num3 = new BigInteger(parts[2]);
        } catch (Exception e) {
            System.out.println("Can't parse a big integer value");
            e.printStackTrace();
        }

        System.out.println(atLeastTwoAreEqual(num1, num2, num3) ? "YES" : "NO");
    }
}
