package hyperskill.math;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Write a program that reads two numbers a a and b b from the keyboard and calculates and outputs to the console the arithmetic average of all numbers from the interval [a; b] [a;b], which are divisible by 3 3.

In the example below, the arithmetic average is calculated for the numbers on the interval [-5; 12] [−5;12]. Total numbers divisible by 3 3 on this interval 6 6: -3, 0, 3, 6, 9, 12 −3,0,3,6,9,12. Their arithmetic average equals to 4.5 4.5

The program input contains intervals, which always contain at least one number, which is divisible by 3 3.

Sample Input 1:

-5
12
Sample Output 1:

4.5
 */
public class ArithmeticAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        IntStream intStream = IntStream.rangeClosed(start, end).filter(i -> i % 3 == 0);
        System.out.println(intStream.average().orElse(0.0));
        scanner.close();
    }
}
