package hyperskill.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        char[][] matrix = new char[4][4];
        boolean result = true;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            String line =scanner.nextLine();
            for (int j = 0; j < line.length()-1; j++) {                
                list.add(String.valueOf(line.charAt(j))+String.valueOf(line.charAt(j+1)));
            }
        }
        System.out.println(list);
    }
}
