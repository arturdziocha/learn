package hyperskill.strings;

import java.util.Scanner;

/*
 * Write a program that reads a string and then output another string with doubled characters.

Sample Input 1:

The
Sample Output 1:

TThhee
 */
public class DoubleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        char[] arr = scanner.nextLine().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            builder.append(c).append(c);
        }
        System.out.println(builder.toString());
        scanner.close();
    }
}
