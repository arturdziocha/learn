package snippets.factorial;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Factorial {
    static long factorialUsingForLoop(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    static BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorialUsingStreams(0));
        System.out.println(factorialHavingLargeResult(200));
    }
}
