package hyperskill.strings;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

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
 */
public class GeneratingPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int upperSize = scanner.nextInt();
        int lowerSize = scanner.nextInt();
        int digitsSize = scanner.nextInt();
        int size = scanner.nextInt();
        StringBuilder password = new StringBuilder();
        do {
            password.append(generatePassword(upperSize, lowerSize, digitsSize));
        } while (password.length() < size);
        System.out.println(password.substring(0, size));
        scanner.close();
    }

    public static String generatePassword(int upperSize, int lowerSize, int digitsSize) {
        String uppercase = new Random()
                .ints(34, 65, 90)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        int maxUpperSize = Math.min(upperSize, uppercase.length());
        String lowercase = new Random()
                .ints(34, 97, 122)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        int maxLoweSize = Math.min(lowerSize, lowercase.length());
        String digits = new Random()
                .ints(10, 0, 10)
                .distinct()
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
        int maxDigitsSize = Math.min(digitsSize, digits.length());
        return uppercase.substring(0, maxUpperSize) + lowercase.substring(0, maxLoweSize) + digits.substring(0,
                maxDigitsSize);
    }
}
