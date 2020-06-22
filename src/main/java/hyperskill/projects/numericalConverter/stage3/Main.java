package hyperskill.projects.numericalConverter.stage3;

import java.util.Scanner;

/*
Now let's implement a simple converter. It will convert the given decimal number to the given radix. You should support three radices with prefixes:

binary (0b),
octal (0),
hexadecimal (0x).
To get a string with answer, use Long.toString(sourceNumber, destinationRadix) expression. Note that the awaited output is a String, because Java implicitly converts 0/0b/0x concatenated numbers to their decimal representation.

This stage is auto-graded. The grader will input two lines (a number and a radix) and then check that your output is the correct number representation in the given radix (don't forget about the prefix).

Example
Example 1:

Input:

8
16
Output:

0x8
Example 2:

Input:

101
2
Output:

0b1100101
Example 3:

Input:

103
8
Output:

0147
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int radix = scanner.nextInt();
        String out = radix == 16 ? "0x" : radix == 8 ? "0" : "0b";
        System.out.println(out + Integer.toString(number, radix));
    }
}
