package hyperskill.strings;

import java.util.Scanner;

/*
 * Write a program that reads a string s and an int n, and then moves the first n characters of s to the end of the string. The program must output the changed string. If n is greater than the length of the string, it must output the string unchanged.

Note, the substring method can help you, but you may choose another way to solve the problem.

Input data format

The single input line contains s and n separated by a space.

Sample Input 1:

Hello 3
Sample Output 1:

loHel

Hello 6

 */
public class MoveTheFirstNCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String word = scanner.next();
        int toMove = scanner.nextInt();
        System.out.println(word.length() >= toMove ? word.substring(toMove).concat(word.substring(0, toMove)) : word);
        scanner.close();

    }

}
