package hyperskill.exceptions;

/*
Your task is to write a program that reads a sequence of strings and converts them to integer numbers, multiplying by 10. Some input strings may have an invalid format, for instance: "abc". The sequence’s length may be different. It’s ending is indicated by “0”. Zero serves as a stop character and should not be included in the sequence.

If a string can be converted to an integer number, output the number multiplied by 10. Otherwise, output the string "Invalid user input: X" where X is the input string. To better understand see examples below.

To implement this logic, use the exception handling mechanism.

Input data format:

A sequence of integer numbers and other strings, each in a new line

Output data format:

A sequence of integer numbers and warnings, each in a new line
 */

import java.util.Scanner;

/*
Sample Input 1:

11
12
13
0
Sample Output 1:

110
120
130
Sample Input 2:

11
abc
13
0
Sample Output 2:

110
Invalid user input: abc
130
 */
public class ConvMultiplyin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add numbers: ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            try {
                int num = Integer.parseInt(next);
                if (num != 0) {
                    System.out.println(num * 10);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + next);
            }

        }
    }
}
