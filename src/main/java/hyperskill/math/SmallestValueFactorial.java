package hyperskill.math;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * A user inputs a long positive number M. You need to find out what is the smallest int number n such that n! > M.

Just in case: https://en.wikipedia.org/wiki/Factorial

Sample Input 1:

6188989133
Sample Output 1:

13
Sample Input 2:

6
Sample Output 2:

4
 */
public class SmallestValueFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        BigInteger value = BigInteger.valueOf(scanner.nextLong());
        scanner.close();
        BigInteger result = BigInteger.ONE;
        int n = 1;
        while (result.compareTo(value) <= 0) {
            n++;
            result = result.multiply(BigInteger.valueOf(n));
        }
        System.out.println(n);
    }
}
