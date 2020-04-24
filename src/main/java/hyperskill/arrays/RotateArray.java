package hyperskill.arrays;

import java.util.Scanner;

/*
Given a rectangle array n×m in size. Rotate it by 90 degrees clockwise, by recording the result into the new array m×n in size.

Input data format

Input the two numbers n and m, not exceeding 100, and then an array n×m in size.

Output data format

Output the resulting array. Separate numbers by a single space in the output.

Sample Input 1:

3 4
11 12 13 14
21 22 23 24
31 32 33 34
Sample Output 1:

31 21 11
32 22 12
33 23 13
34 24 14
 */
public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.close();
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] ss = new int[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                ss[i][j] = arr[rows - j - 1][i];
            }
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(ss[i][j] + " ");
            }
            System.out.println();
        }
    }

}
