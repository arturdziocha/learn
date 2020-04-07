package hyperskill.strings;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GeneratePasswords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int upperSize = scanner.nextInt();
        int lowerSize = scanner.nextInt();
        int digitsSize = scanner.nextInt();
        int size = scanner.nextInt();
        StringBuilder password = new StringBuilder();
        do {
            int lastChar = (int) password.length() > 0 ? password.charAt(password.length() - 1) : 0;
            password.append(generatePassword(upperSize, lowerSize, digitsSize, lastChar));
        } while (password.length() < size);
        System.out.println(password.substring(0, size));
        scanner.close();
    }

    public static String generatePassword(int upperSize, int lowerSize, int digitsSize, int lastChar) {
        String uppercase = new Random()
                .ints(34, 65, 90)
                .filter(s -> s != lastChar)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        int maxUpperSize = Math.min(upperSize, uppercase.length());
        String lowercase = new Random()
                .ints(34, 97, 122)
                .filter(i -> i != lastChar)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        int maxLoweSize = Math.min(lowerSize, lowercase.length());
        String digits = new Random()
                .ints(digitsSize, 48, 58)
                .filter(i -> i != lastChar)
                .mapToObj(c -> String.valueOf((char) c))
                .distinct()
                .collect(Collectors.joining());
        int maxDigitsSize = Math.min(digitsSize, digits.length());
        return uppercase.substring(0, maxUpperSize) + lowercase.substring(0, maxLoweSize)
                + digits.substring(0, maxDigitsSize);
    }

}
