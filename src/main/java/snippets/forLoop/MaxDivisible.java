package snippets.forLoop;

import java.util.Scanner;

/*
 * Given a sequence of natural numbers, not exceeding 30000. Find the maximum
 * element divisible by 4. The program receives the number of elements in the
 * sequence and then the elements themselves as input. In the sequence, there is
 * always an element divisible by 4. The number of elements does not exceed
 * 1000. The program should print a single number: the maximum element of the
 * sequence divisible by 4.
 *
 * Sample Input 1: 12 16 87 58 25 73 86 36 79 40 12 89 32
 */

public class MaxDivisible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add numbers");
        int n = in.nextInt();
        int currentMax = 0;
        int num;

        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            if (num % 4 == 0 && num > currentMax) {
                currentMax = num;
            }
        }
        System.out.println(currentMax);
        in.close();

        // Scanner scanner = new Scanner(System.in);
        // int len = scanner.nextInt();
        // int start = 0;
        // int max = 0;
        // int num;
        // while ( start<len ) {
        // num = scanner.nextInt();
        // start++;
        // if (num%4==0 && num>max) {
        // max=num;
        // }
        // }
        // System.out.println(max);
    }

}
