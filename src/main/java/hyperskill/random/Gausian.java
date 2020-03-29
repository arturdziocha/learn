package hyperskill.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/*
Find the first seed that is greater or equal to K where each of N Gaussian numbers is lesser than or equal M.

The input contains numbers K, N, M in a single line.

You should output the seed.

Hint

You have to check all n iterations of Gaussian generated numbers to be less than M. If that is true, then escape loop and print the seed. If any of the generated numbers is greater than or equal to M, then you have to test out the next seed and go to the loop all over again.
Don't get too upset if you still don't understand this problem. Skip it or google for more information.

Sample Input 1:

0 5 0
Sample Output 1:

38
Sample Input 2:

0 5 -1.5
Sample Output 2:

498666
Sample Input 3:

10000 1 1.9
Sample Output 3:

10000
 */
public class Gausian {
    public static void main(String[] args) throws IOException {
        System.out.println("add");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split("\\s++");
            System.out.println(Arrays.toString(line));
            int k = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            double m = Double.parseDouble(line[2]);
            System.out.println(m);

            for (int i = k; i < Integer.MAX_VALUE; i++) {
                Random random = new Random(i);
                double[] gausianNumbers = new double[n];
                for (int j = 0; j < n; j++) {
                    gausianNumbers[j] = random.nextGaussian();
                }

                if (Arrays.stream(gausianNumbers).boxed().allMatch(b -> b.compareTo(m) <= 0)) {
                    System.out.println(i);
                    break;
                }
            }
        }

        /*
         * final long k = scanner.nextLong(); final long n = scanner.nextLong();
         * final double m = scanner.nextDouble(); long seed = k; Random rand =
         * new Random(seed); while
         * (Stream.generate(rand::nextGaussian).limit(n).anyMatch(i -> i > m)) {
         * rand.setSeed(++seed); } System.out.println(seed);
         */
    }
}
