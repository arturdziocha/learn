package hyperskill.collection.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
The simplest spell checker is the one based on a list of known words. Every word in the text is being searched for in this list and, if such word was not found, it is marked as erroneous.

Write such a spell checker.

The first line of the input contains dd – number of records in the list of known words. Next go dd lines containing one known word per line, next — the number ll of lines of the text, after which — ll lines of the text.

Write a program that outputs those words from the text that are not found in the dictionary (i.e. erroneous). Your spell checker should be case insensitive. The words are entered in an arbitrary order. Words, which are not found in the dictionary, should not be duplicated in the output.

Sample Input 1:

3
a
bb
cCc
2
a bb aab aba ccc
c bb aaa
Sample Output 1:

c
aab
aaa
aba
 */
public class SetSpellChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add lines");
        int dicSize = Integer.parseInt(scanner.nextLine());
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < dicSize; i++) {
            dictionary.add(scanner.nextLine().toLowerCase());
        }
        int lineSize = Integer.parseInt(scanner.nextLine());
        // scanner.nextLine();
        Set<String> words = new HashSet<>();
        for (int i = 0; i < lineSize; i++) {
            words.addAll(Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+")));
        }
        words.removeAll(dictionary);
        words.forEach(System.out::println);
    }
}
