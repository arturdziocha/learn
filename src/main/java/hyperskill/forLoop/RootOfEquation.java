package hyperskill.forLoop;

import java.util.Scanner;

/**
 * The roots of a cubic equation
 * <p>
 * Given the numbers a, b, c, d Output in ascending order all the integers between 0 and 1000 which are the roots of the equation ax^3+bx^2+cx+d=0
 * If the specified interval does not contain the roots of the equation, do not output anything.
 * <p>
 * Remember, that cubic equation always has 3 roots. Keep it in mind in order to optimize the code.
 */

/*
Sample Input 1:

-1
1
-1
1
Sample Output 1:

1
Sample Input 2:

0
1
-6
5
Sample Output 2:

1
5
Sample Input 3:

1
1
1
1
Sample Output 3:
 */
public class RootOfEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        for (int i = 0; i < 1000; i++) {
            if (a * Math.pow(i, 3) + b * Math.pow(i, 2) + c * i + d == 0) {
                System.out.println(i);
            }
        }
    }
}
