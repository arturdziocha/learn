package hyperskill.strings;

import java.util.*;
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
* 
* 0 0 0 100
 */
public class GeneratingPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int upperSize = scanner.nextInt();
        int lowerSize = scanner.nextInt();
        int digitsSize = scanner.nextInt();
        int size = scanner.nextInt();
        String password = genPassword(upperSize, lowerSize, digitsSize, size);
        System.out.println(password.substring(0, size));
        scanner.close();
    }

    public static String genPassword(int upperSize, int lowerSize, int digitsSize,
                                     int allSize) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        do {
            int lastChar = password.length() > 0 ? password.charAt(password.length() - 1) : 0;
            if (upperSize == 0 && lowerSize == 0 && digitsSize == 0 && allSize != 0) {
                List<Integer> no = IntStream
                        .rangeClosed(33, 47)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
                password.append(generateFromInts(random, no, allSize, lastChar));
            }

            if (upperSize > 0) {
                List<Integer> upperCases = IntStream
                        .range(65, 91)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
                password.append(generateFromInts(random, upperCases, upperSize, lastChar));
            }
            if (lowerSize > 0) {
                List<Integer> lowerCases = IntStream
                        .range(97, 123)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
                password.append(generateFromInts(random, lowerCases, lowerSize, lastChar));
            }
            if (digitsSize > 0) {
                List<Integer> digits = IntStream.range(48, 58).boxed().collect(Collectors.toCollection(ArrayList::new));
                password.append(generateFromInts(random, digits, digitsSize, lastChar));
            }
        } while (password.length() < allSize);
        return password.toString();
    }

    public static String generateFromInts(Random random, List<Integer> ints, int size, int lastChar) {
        StringBuilder builder = new StringBuilder();
        int max = ints.stream().max(Comparator.comparing(Integer::valueOf)).get();
        int min = ints.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int lastRandom = 0;
        int nextInt;
        for (int i = 0; i < size; i++) {
            do {
                nextInt = random.nextInt(max - min + 1) + min;
            } while (nextInt == lastRandom || nextInt == lastChar);
            lastRandom = nextInt;
            builder.append((char) nextInt);
        }
        return builder.toString();
    }

}
