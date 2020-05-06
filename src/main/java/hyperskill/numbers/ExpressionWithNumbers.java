package hyperskill.numbers;

import java.math.BigInteger;
import java.util.Scanner;

public class ExpressionWithNumbers {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("add");

        final String[] parts = scanner.nextLine().split("\\s+");

        BigInteger num1 = null;
        BigInteger num2 = null;
        BigInteger num3 = null;
        BigInteger num4 = null;

        try {
            num1 = new BigInteger(parts[0]);
            num2 = new BigInteger(parts[1]);
            num3 = new BigInteger(parts[2]);
            num4 = new BigInteger(parts[3]);
        } catch (Exception e) {
            System.out.println("Can't parse a big integer value");
            e.printStackTrace();
        }
        BigInteger total = num1.negate();
        total = total.multiply(num2);
        total = total.add(num3);
        total = total.subtract(num4);
        System.out.println(total);
    }
}
