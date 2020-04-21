package hyperskill.arrays;

import java.util.Scanner;

/*
 * n some design style, a 4x4 matrix pattern is considered looking pretty if it doesn't consist of a 2x2 matrix of the same color. Your task is to write the program that outputs "YES" if the 4x4 matrix is looking pretty, otherwise output "NO".

Input contains 4 lines, each line contains 4 symbols, different symbols represent different colors: W stands for white color, B - black, R - red, G - green, Y - yellow.
Sample Input 1:

WWWW
BBBB
WWWW
YYYY
Sample Output 1:

YES
Sample Input 2:

BBBB
BWWB
BWWB
BBBB
Sample Output 2:

NO

BYBY
YBYB
BYBY
YBYB
 */
public class MatrixPreetyLooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String line;
        boolean result = true;
        for (int i = 0; i < 4; i++) {
            line = scanner.nextLine();
            for (int j = 0; j < 2; j++) {

            }
        }
        scanner.close();
        System.out.println(result ? "YES" : "NO");
    }
}
