package hyperskill.math;

import java.util.Scanner;
/*
 * Write a program that read an array of ints and finds the index of the first maximum in an array.

Input data format

The first line contains the number of elements in the array.

The second line contains the array elements separated by spaces.

An array always has at least one element.

Output data format

Only a single integer value - the index of the first maximum.

Sample Input 1:

5
2 5 3 4 5
Sample Output 1:

1
Sample Input 2:

6
1000 10 1000 10 10 1001
Sample Output 2:

5
 */
public class IndexOfMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
        int maxRow = 0;
        int max = Integer.MIN_VALUE;
        int next;
        for (int i = 0; i < howMany; i++) {
            next = scanner.nextInt();
            if (next > max) {
                maxRow = i;
                max = next;
            }
        }
        scanner.close();
        System.out.println(maxRow);
    }
}
