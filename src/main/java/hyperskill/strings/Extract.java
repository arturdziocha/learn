package hyperskill.strings;

import java.util.Scanner;

/*
 * Write a program that reads a string and two integer numbers. These two numbers are representing a range that includes them both. Print the substring enclosed in this range. Both numbers are always greater than or equal to 0 and less than the string length.

Sample Input 1:

Java
0 2
Sample Output 1:

Jav
 */
public class Extract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.print(word.substring(scanner.nextInt(), scanner.nextInt() + 1));
        scanner.close();
    }
}
