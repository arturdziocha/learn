package hyperskill.strings;

import java.util.Scanner;

/*
 * Write a program that takes a sentence as input and returns the index of the first occurrence of the word "the" (can be part of a word), regardless of the capitalization. If there is no occurrence of it must output -1.

For instance, if the sentence is “The apple is red.” the output should be 0, if the sentence is “I ate the red apple.” the output should be 6, and if the sentence is “I love apples.” the output should be -1.

Note, the and The are equal.

Sample Input 1:

The apple is red.
Sample Output 1:

0
Sample Input 2:

I ate the red apple.
Sample Output 2:

6
Sample Input 3:

the
Sample Output 2:

0
 */
public class FindTheFirstOccurrence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String line = scanner.nextLine().toLowerCase();
        int firstOccurence = -1;
        if (line.length() <= 3) {
            firstOccurence = line.equals("the") ? 0 : -1;
        } else {
            for (int i = 0; i < line.length() - 3; i++) {
                if (line.charAt(i) == 't' && line.charAt(i + 1) == 'h' && line.charAt(i + 2) == 'e') {
                    firstOccurence = i;
                    break;
                }
            }
        }
        System.out.println(firstOccurence);
        scanner.close();
    }

}
