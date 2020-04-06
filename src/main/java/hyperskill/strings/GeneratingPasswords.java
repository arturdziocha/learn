package hyperskill.strings;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * The password is hard to crack if it contains at least A uppercase letters, at least B lowercase letters, at least C digits and includes exactly N symbols. Also, a password cannot contain two or more same characters coming one after another.

For the given numbers A, B, C, N you should output a password that matches these requirements.

It is guaranteed A, B, C, and N are non-negative integers and A + B + C <= N. Keep in mind, that any parameter can be equal to zero. It means that it's ok if the password doesn't contain symbols of such type.

Sample Input 1:

3 2 3 10
Sample Output 1:

ABAab121AB
 */
public class GeneratingPasswords {
    public static void main(String[] args) {
        System.out.println(generatePassword("5 0 0 10"));

    }

    public static String generatePassword(String numbers) {
        int[] nums = Arrays.stream(numbers.split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int sum = Arrays.stream(nums).sum() - nums[3];
        String uppercase = new Random()
                .ints(34, 65, 90)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        String lowercase = new Random()
                .ints(34, 97, 122)
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        String digits = new Random()
                .ints(10, 0, 10)
                .distinct()
                .boxed()
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());
        // TODO update to string equals num[3]
        String uppercaseString = uppercase.substring(0, nums[0]) + lowercase.substring(0, nums[1])
                + digits.substring(0, nums[2]);
        return factorialString(uppercaseString, nums[3]);
    }

    public static String factorialString(String string, int length) {
        String ss = "";
        if (string.length() < length) {
            ss += factorialString(string, length);
        } else {
            ss = string;
        }
        return ss;
    }
}
