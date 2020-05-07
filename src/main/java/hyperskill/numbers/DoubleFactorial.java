package hyperskill.numbers;

import java.math.BigInteger;

public class DoubleFactorial {
    public static void main(String[] args) {

    }

    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = n; i >= 1; i -= 2) {
            if (i == 0 || i == 1) {
                return res;
            } else {
                res = res.multiply(BigInteger.valueOf(i));
            }
        }
        return res;
    }
}
