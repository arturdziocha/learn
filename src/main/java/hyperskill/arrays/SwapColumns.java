package hyperskill.arrays;

import java.util.Scanner;

/*
 * Given a two-dimensional array (matrix) and the two numbers: i and j. Swap the columns with indexes i and j within the matrix.

Input contains matrix dimensions n and m, not exceeding 100, then the elements of the matrix, then the indexes i and j.

Sample Input 1:

3 4
11 12 13 14
21 22 23 24
31 32 33 34
0 1
Sample Output 1:

12 11 13 14
22 21 23 24
32 31 33 34
 */
public class SwapColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int firstCol = scanner.nextInt();
        int secondColumn = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == firstCol) {
                    int tmp = matrix[i][firstCol];
                    matrix[i][firstCol] = matrix[i][secondColumn];
                    matrix[i][secondColumn] = tmp;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
