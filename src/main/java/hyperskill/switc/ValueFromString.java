package hyperskill.switc;

import java.util.Scanner;
/*
 * Write a program that read a string from the standard input and outputs the number. A number can be from 1 to 9 (inclusive).
Sample Input 1:

one
Sample Output 1:

1
 */
public class ValueFromString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int out;
        switch (num) {
            case "one":
                out = 1;
                break;
            case "two":
                out = 2;
                break;
            case "three":
                out = 3;
                break;
            case "four":
                out = 4;
                break;
            case "five":
                out = 5;
                break;
            case "six":
                out = 6;
                break;
            case "seven":
                out = 7;
                break;
            case "eight":
                out = 8;
                break;
            case "nine":
                out = 9;
                break;

            default:
                out = 0;
                break;
        }
        System.out.println(out);

    }
}
