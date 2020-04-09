package hyperskill.strings;

import java.util.Scanner;

/*
 * Write a program that reads a string, and then outputs the string without its middle character when the length is odd, and without the middle 2 characters when the length is even.

Hint

Remember substring() method. It can help you a lot.

Sample Input 1:

Hello
Sample Output 1:

Helo
Sample Input 2:

abcd
Sample Output 2:

ad
 */
public class CuttTheMiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("add");
        String word = scanner.next();
        int length = word.length();
        int cut = length / 2;
        if (length % 2 == 0) {
            System.out.println(word.substring(0, cut - 1) + word.substring(cut + 1));
        } else {
            System.out.println(word.substring(0, cut) + word.substring(cut + 1));
        }
        System.out
                .print(word.substring(0, word.length() / 2 - 1 + word.length() % 2)
                        + word.substring(word.length() / 2 + 1));
        System.out.println(word.substring(0, (word.length() - 1) / 2) + word.substring(word.length() / 2 + 1));
        scanner.close();

    }
}
