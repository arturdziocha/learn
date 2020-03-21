package hyperskill.random;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * You are given three numbers: a ,  b and n.

Your task is to output the sum of the first n random numbers in a range from a to b inclusively. 
The seed of the generator should be set as a + b.

The input contains numbers in a single line in the following order: n, a, b.

Sample Input 1:

100 5 10
Sample Output 1:

734
 */
public class GenerateRandom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add numbers: ");
        int n = scanner.nextInt();
        int low = scanner.nextInt();
        int max = scanner.nextInt();
        Random random = new Random(low + max);
        System.out.println(IntStream.range(0, n).map(s -> random.nextInt(max - low + 1) + low).sum());
        scanner.close();
    }
}
