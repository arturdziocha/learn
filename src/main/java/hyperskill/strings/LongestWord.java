package hyperskill.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * In the given string find the first longest word and output it.

Input data

Given a string in a single line. Words in the string are separated by a single space.

Output data

Output the longest word. If there are several such words, you should output the one, which occurs earlier.

Sample Input 1:

one two three four five six artur mokra
Sample Output 1:

three
 */
public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String[] words = scanner.nextLine().split("\\s+");
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        System.out.println(words[0]);
        scanner.close();

    }
}
