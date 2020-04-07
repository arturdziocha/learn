package hyperskill.strings;

import java.util.Scanner;

public class PalindromChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String line = scanner.nextLine();
        System.out.println(isPalindrom(line) ? "yes" : "no");
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
}
