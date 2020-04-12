package snippets.palindrom;

import java.util.Random;
import java.util.Scanner;

public class PalindromChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String txt = scanner.nextLine();
        if (txt.length() <= 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4 - txt.length(); i++) {
                builder.append(0);
            }
            builder.append(txt);
            txt = builder.toString();
        }
        Random random = new Random();
        System.out.println(isPalindrom(txt) ? 1 : random.nextInt());
        scanner.close();
    }

    public static boolean isPalindrom(String txt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    boolean isPalindrome(String str, boolean isCaseSensitive) {
        if (!isCaseSensitive) {
            str = str.toLowerCase();
        }
        String[] skipped = {" ", "!", "-", "_", "+", "=", "{", "}", "[", "]", ";", ":", "\'", "\"", ",", ".", "?"};
        for (int i = 0; i < skipped.length; i++) {
            str = str.replace(skipped[i], "");
        }
        System.out.println();
        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();
        return str.equals(reverse);
    }
}
