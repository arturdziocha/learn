package snippets.streams;

import java.util.Scanner;
import java.util.stream.LongStream;

/*
 * Implement a method sumInRange for calculating the sum of numbers in the range from (inclusive), to (exclusive).

Sample Input 1:

1 2
Sample Output 1:

1
Sample Input 2:

5 5
Sample Output 2:

0
Sample Input 3:

10 15
Sample Output 3:

60

10000000 1000000000
 */
public class SumInRange {
    public static long sumInRange(int from, int to) {
        return LongStream.range(from, to).sum();
        // Math
        // return (long) (to - from) * (from + to - 1) / 2;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int from = scanner.nextInt();
        int to = scanner.nextInt();

        System.out.println(sumInRange(from, to));
    }
}
