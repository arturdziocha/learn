package hyperskill.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Write a program that reads a string and output "true" only when the letters of this string form a substring of the ordered English alphabet, for example, "abc", "xy", "pqrst".

Otherwise, it should print out "false".

Note: string can consist of a single character. Assume an empty string as an alphabet substring.

Sample Input 1:

abc
Sample Output 1:

true
Sample Input 2:

bce
Sample Output 2:

false
 */
public class PieceOfAlphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("add");
        String word = scanner.nextLine();
        List<Integer> chars = word.chars().mapToObj(c -> (int) c).collect(Collectors.toCollection(ArrayList::new));
        boolean bool = true;
        for (int i = 1; i < chars.size(); i++) {
            if (chars.get(i) - chars.get(i - 1) != 1) {
                bool = false;
                break;
            }
        }
        System.out.println(bool);
        scanner.close();

    }
}
