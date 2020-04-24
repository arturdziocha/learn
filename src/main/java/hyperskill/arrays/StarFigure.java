package hyperskill.arrays;

import java.util.Scanner;

/*
 * Given an odd number n, not exceeding 15. Create a two-dimensional array (matrix) from n×n elements, by filling it with "." symbols (each element of the matrix is a string containing a single symbol). Then fill the middle row of the matrix, the middle column, and the main and the secondary diagonals with the "*" symbols. As a result, all "*"s in the array must form the star figure. Output this matrix; elements of the array should be space separated.

Sample Input 1:

5
Sample Output 1:

* . * . *
. * * * .
* * * * *
. * * * .
* . * . *
 */
public class StarFigure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int toDraw = scanner.nextInt();
        scanner.close();
        draw(toDraw);

    }

    public static void draw(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == (n - 1) / 2 || i == n - j - 1 || j == (n - 1) / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();

        }
    }
}
