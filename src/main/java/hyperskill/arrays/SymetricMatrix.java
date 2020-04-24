package hyperskill.arrays;

import java.util.Scanner;

/*
Given the number n, not exceeding 10, and a matrix of size n × n.

Check whether this matrix is symmetric in relation to the main diagonal. Output the word “YES”, if it is symmetric and the word “NO” otherwise.
Sample Input 1:

3
0 1 2
1 2 3
2 3 4
Sample Output 1:

YES

2
0 0
1 1

4
0 0 0 0
1 0 0 0
0 0 0 0
 */
public class SymetricMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
