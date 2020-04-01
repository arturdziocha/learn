package hyperskill.chars;

import java.util.Scanner;

/*
Implement a method for checking the given english letter is a vowel or not. The input may be in any case.

Do not consider the letter 'y' as a vowel.

Examples

1) isVowel('a') should be true

2) isVowel('A') should be true

3) isVowel('b') should be false
 */
public class Vovel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
        scanner.close();
    }

    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
