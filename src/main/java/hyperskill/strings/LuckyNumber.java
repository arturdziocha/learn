package hyperskill.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Given the number N with an even number of digits. If the sum of the first half of the digits equals the sum of the second half of the digits, then this number is considered lucky. For a given number, output "YES" if this number is lucky, otherwise output "NO".

Sample Input 1:

12344321
Sample Output 1:

YES
Sample Input 2:

125322
Sample Output 2:

NO
 */
public class LuckyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("add");
        List<Integer> numbers =
                scanner.nextLine().chars().boxed().collect(Collectors.toCollection(ArrayList::new));
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0, j = numbers.size() / 2; i < numbers.size() / 2; i++, j++) {
            sum1 += numbers.get(i);
            sum2 += numbers.get(j);
        }
        System.out.println(sum1 == sum2 ? "YES" : "NO");
    }
}
