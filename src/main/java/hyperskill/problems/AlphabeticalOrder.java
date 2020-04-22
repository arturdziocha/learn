package hyperskill.problems;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Write a program that reads an array of lowercase strings and checks whether the array is in alphabetical order or not.

There are some rules to compare pair of strings a and b:

1) First chars of strings are compared: a[0] and b[0]. If a[0] comes earlier than b[0] in the alphabet, then a comes before b in term of alphabetical order. If the first chars are the same, then the second chars are compared, and so on.

2) If a position is reached where one string has no more chars to compare while the other does, then the shorter string is deemed to come first in alphabetical order.

3) Finally, identical strings are in alphabetical order.

You can use compareTo method of the String class to compare 2 strings. If this String object alphabetically precedes the argument string, then the result is a negative integer. The result is a positive integer if this String object alphabetically follows the argument string. The result is zero if the strings are identical. This is exactly what you need to compare 2 strings in term of alphabetical order!

For example

System.out.println("abc".compareTo("acd")); // -1 "abc" < "acd"
System.out.println("abc".compareTo("aac")); //  1 "abc" > "aac"
System.out.println("abc".compareTo("abc")); //  0 "abc" = "abc"
 

Input data format

The single input line contains lowercase strings separated by spaces.

Output data format

Only a single value - true or false.

Sample Input 1:

a b c
Sample Output 1:

true
Sample Input 2:

a aa az aza
Sample Output 2:

true
az aa az aza

 */
public class AlphabeticalOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String[] arr = scanner.nextLine().split(" ");
        String[] temp = arr.clone();
        Arrays.sort(arr);
        System.out.println(Arrays.equals(arr, temp));

    }

}
