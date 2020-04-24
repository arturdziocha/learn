package hyperskill.arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
 * n some design style, a 4x4 matrix pattern is considered looking pretty if it doesn't consist of a 2x2 matrix of the same color. 
 * Your task is to write the program that outputs "YES" if the 4x4 matrix is looking pretty, otherwise output "NO".

Input contains 4 lines, each line contains 4 symbols, different symbols represent different colors: 
W stands for white color, B - black, R - red, G - green, Y - yellow.
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

YES
 */
public class MatrixPreetyLooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");

        String[] arr = new String[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scanner.next();
        }
        scanner.close();
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i].charAt(j) == arr[i + 1].charAt(j) && arr[i].charAt(j) == arr[i].charAt(j + 1)
                        && arr[i].charAt(j) == arr[i + 1].charAt(j + 1)) {

                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
        scanner.close();
    }
}
