package hyperskill.numbers;

import java.math.BigInteger;
import java.util.Scanner;
/*
 * A user inputs a long number M. You need to find out what is the smallest long n, so that n! >= M.

Use the BigInteger class to solve the problem. Otherwise, your solution won't pass all the tests.

Do not forget to import all the needed classes.

Just in case: wiki on factorials.

Sample Input 1:

3628799
Sample Output 1:

10
Sample Input 2:

39916800
Sample Output 2:

11
 */
public class SmallestFactorialValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = new BigInteger(scanner.next());
        System.out.println(maxNumberTo(n));
    }

    private static long maxNumberTo(BigInteger n) {
        BigInteger facorial = BigInteger.ONE;
        long i = 1;
        for (i = 1;; i++) {
            facorial = facorial.multiply(BigInteger.valueOf(i));
            if (facorial.compareTo(n) >= 0) {
                break;
            }
        }
        return i;
    }
}
