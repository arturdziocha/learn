package hyperskill.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * The password is hard to crack if it contains at least A uppercase letters, at least B lowercase letters, at least C digits and includes exactly N symbols. Also, a password cannot contain two or more same characters coming one after another.

For the given numbers A, B, C, N you should output a password that matches these requirements.

It is guaranteed A, B, C, and N are non-negative integers and A + B + C <= N. Keep in mind, that any parameter can be equal to zero. It means that it's ok if the password doesn't contain symbols of such type.

Sample Input 1:

3 2 3 10
Sample Output 1:

ABAab121AB

1 0 0 2
Failed test #5 of 17. Your password has repeated symbol 'T'
*
* 0 0 100 100
*
* 1 0 0 2
*
* 33 33 33 100
 */
public class GeneratingPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int upperSize = scanner.nextInt();
        int lowerSize = scanner.nextInt();
        int digitsSize = scanner.nextInt();
        int size = scanner.nextInt();
        int[] upperCases = IntStream.range(65, 91).toArray();
        int[] lowerCases = IntStream.range(97, 122).toArray();
        int[] digits = IntStream.range(48, 58).toArray();
        System.out.println(upperCases.length);
        Arrays.stream(upperCases).mapToObj(c->(char)c).forEach(System.out::print);
        StringBuilder password = new StringBuilder();
        do {
            int lastChar = (int) password.length() > 0 ? password.charAt(password.length() - 1) : 0;
            password.append(generatePassword(upperSize, lowerSize, digitsSize, lastChar));
        } while (password.length() < size);
        System.out.println();
        System.out.println(password.substring(0, size));
        scanner.close();
    }
    public static String genPass(int upperSize, int lowerSize, int digitsSize, int allSize){
        return "";
    }

    public static String generateFromInts(Random random, int[] ints, int size, int lastChar) {
        StringBuilder builder = new StringBuilder();
        int max = Arrays.stream(ints).boxed().max(Comparator.comparing(Integer::valueOf)).get();
        int min = Arrays.stream(ints).boxed().min(Comparator.comparing(Integer::valueOf)).get();
        int lastRandom = 0;
        int nextInt = 0;
        for (int i = 0; i < size; i++) {
            do {
                nextInt = random.nextInt(max - min + 1) + min;
            } while (nextInt != lastRandom && nextInt != lastChar);
            lastRandom = nextInt;
            builder.append(String.valueOf((char) nextInt));
        }
        return builder.toString();
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
        return uppercase.substring(0, maxUpperSize) + lowercase.substring(0, maxLoweSize) + digits.substring(0,
                maxDigitsSize);
    }
}
