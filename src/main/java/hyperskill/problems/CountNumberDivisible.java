package hyperskill.problems;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Write a program that reads a, b, n and outputs the count of numbers divisible by n in the range from a to b (a < b) inclusively.

Note:  it is possible to write this program more efficiently without any loops.

Sample Input 1:

10 20 10
Sample Output 1:

2
Sample Input 2:

15 25 5
Sample Output 2:

3
 */
public class CountNumberDivisible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(IntStream.rangeClosed(a, b).filter(i -> i % n == 0).count());
    }
}
