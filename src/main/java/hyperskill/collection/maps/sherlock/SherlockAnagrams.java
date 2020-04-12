package hyperskill.collection.maps.sherlock;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 n this problem, you are Sherlock Holmes and you want to quickly detect all anagrams.

Write a program that finds out whether two words are anagrams or not. If one word is an anagram of another, print "yes", else print "no".

Note: anagrams are words that contain the same characters with the same frequencies. 
In other words, anagrams are created by changing the order of letters in the word.

For example:

"ppaaagg" (p - 2; a - 3; g - 2) and "gagaapp" (p - 2; a - 3; g - 2) are anagrams;
"hello" (h - 1; e - 1; l - 2; o - 1) and "helllo" (h - 1; e - 1; l - 3; o - 1) are not anagrams.
Remember: anagrams are case-insensitive.

Sample Input 1:

ppaaagg
gagaapp
Sample Output 1:

yes
 */
public class SherlockAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add strings");
        Map<Character, Long> firstWord = scanner
                .nextLine()
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> secondWord = scanner
                .nextLine()
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(firstWord.equals(secondWord) ? "yes" : "no");
        scanner.close();

    }
}
