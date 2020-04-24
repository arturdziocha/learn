package hyperskill.arrays;
/*
 * Given the number n, not greater than 100. Create the matrix of size n×n and fill it by the following rule. Numbers 0 should be stored on the primary diagonal. The two diagonals, adjacent to the primary one, should contain numbers 1. The next two diagonals - numbers 2, etc.

Sample Input 1:

5
Sample Output 1:

0 1 2 3 4
1 0 1 2 3
2 1 0 1 2
3 2 1 0 1
4 3 2 1 0
 */
import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value;
                if (i == j) {
                    value = 0;
                } else if (i < j) {
                    value = j - i;
                } else {
                    value = i - j;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
