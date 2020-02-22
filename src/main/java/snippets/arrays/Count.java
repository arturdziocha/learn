package snippets.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*Write a program that read an array of ints and an integer number n.

The program must check how many times n occurs in the array.

Input data format

The first line contains the size of the input array.
The second line contains elements of the array separated by spaces.
The third line contains n.

Output data format

The result is only a single non-negative integer number.
Sample Input 1:
*/
//6 1 2 3 4 2 1 2
//Sample Output 1:
//
//2

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add numbers");
        int howMany = scanner.nextInt();
        int[] arr = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            arr[i] = scanner.nextInt();
        }
        int toSearch = scanner.nextInt();
        System.out.println("To search:" + toSearch);
        int count = 0;
        for (int number : arr) {
            if (number == toSearch) {
                count += 1;
            }
        }
        long counted = Arrays.stream(arr).filter(i -> i == toSearch).count();
        int counted1 = Arrays.stream(arr).filter(i -> i == toSearch).reduce(0, Integer::sum);
        System.out.print(count);
        System.out.println(counted);
        System.out.println(counted1);
        scanner.close();
    }
}
