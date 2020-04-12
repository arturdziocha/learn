package hyperskill.projects.encryptdecrypt;

import java.util.Scanner;

/*
 * Write a program that reads an English message and an integer number (key) from the standard input and shifts each letter by the specified number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).

The English alphabet is below:

abcdefghijklmnopqrstuvwxyz
The program should not modify non-letter characters.

The key is assumed to mean that if a person knows the value of the key, he or she will be able to decrypt the text, and if he or she does not know, he or she will not be able to decrypt the text. It's like a real key that can open up access to the message text.

Note, key is just a special parameter that controls the behavior of our encryption algorithm. See the picture below for more information.


Input example

welcome to hyperskill
5
Output example

bjqhtrj yt mdujwxpnqq
 */
public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String line = scanner.nextLine();
        int move = scanner.nextInt();
        String ret = line
                .chars()
                .map(s -> Character.isAlphabetic(s) ? ((s - 97 + move) % 26 + 97) : s)
                .mapToObj(c -> String.valueOf((char) c))
                .reduce(String::concat)
                .get();
        System.out.println(ret);
    }
}
