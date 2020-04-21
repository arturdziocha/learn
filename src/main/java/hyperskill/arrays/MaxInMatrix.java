package hyperskill.arrays;

import java.util.Scanner;

/*
 * Find the indexes of the initial appearance of the maximum element in a matrix.

Input data format

On the input, the program receives the size of matrix n and m, and then n lines having m integer numbers in each. n and m do not exceed 100.

Output data format

Output two numbers: the row index and the column index, in which the greatest item in the two-dimensional array (matrix) is located. If there are several such elements, output the one, which has the smaller row index; and if row indexes are the same - the one having the smaller column index.

Sample Input 1:

3 4
0 3 2 4
2 3 5 5
5 1 2 3
Sample Output 1:

1 2
Sample Input 2:

2 2
-3 -2
-2 -1
Sample Output 2:

1 1
 */
public class MaxInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int maxRow = 0;
        int maxCol = 0;
        int max = Integer.MIN_VALUE;
        int input;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                input = scanner.nextInt();
                if (input > max) {
                    max = input;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println(String.format("%d %d", maxRow, maxCol));
        scanner.close();
    }
}
