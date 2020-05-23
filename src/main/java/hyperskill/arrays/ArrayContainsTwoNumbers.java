package hyperskill.arrays;

import java.util.Scanner;

/*
 * Write a program that reads an unsorted array of integers and two numbers n and m. The program must check if n and m occur next to each other in the array (in any order).

Input data format

The first line contains the size of an array.
The second line contains elements of the array.
The third line contains two integer numbers n and m.
All numbers in the same line are separated by the space character.

Output data format

Only a single value: true or false.
Sample Input 1:

3
1 3 2
2 3
Sample Output 1:

true
Sample Input 2:

3
1 2 3
3 4
Sample Output 2:

false
 */
public class ArrayContainsTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int[] arr = new int[Integer.parseInt(scanner.nextLine())];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = scanner.nextInt();
        }
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        scanner.close();
        boolean condition = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == first && arr[i + 1] == second) {
                condition = true;

            } else if (arr[i] == second && arr[i + 1] == first) {
                condition = true;
            }
        }

        System.out.println(condition);
    }

}
