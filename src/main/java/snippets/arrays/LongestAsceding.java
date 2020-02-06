package snippets.arrays;

import java.util.Scanner;

/*
 * Write a program that reads an array of ints and outputs the length of the
 * longest sequence in strictly ascending order. Elements of the sequence must
 * go one after another.
 * 
 * 
 * 
 * Input data format
 * 
 * The first line contains the size of an array. The second line contains
 * elements of the array separated by spaces.
 * 
 * 
 * 
 * Example
 * 
 * The input array is 1 2 4 1 2 3 5 7 4 3. In this case, the length of the
 * longest sequence in ascending order is 5. It includes the following elements:
 * 1 2 3 5 7.
 * 
 * Sample Input 1:
 * 
 * 10 1 2 4 1 2 3 5 7 4 3 Sample Output 1:
 * 
 * 5
 */
public class LongestAsceding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please add numbers");
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        // int sum = 1;
        // int longest = 0;
        // for (int i = 0; i < len - 1; i++) {
        // if (arr[i + 1] > arr[i]) {
        // sum += 1;
        // } else {
        // longest = sum > longest ? sum : longest;
        // sum = 1;
        // }
        // }
        // System.out.println((sum > longest) ? sum : longest);

        // int maxLength = 1;
        // int currLength = 1;
        // for (int i = 1; i < size; i++) {
        // currLength = seq[i] > seq[i-1] ? ++currLength : 1;
        // maxLength = Math.max(maxLength, currLength);
        // }
        int longest = 1;
        for (int i = 0; i < len - 1; i++) {
            int sum = 1;
            while (i < len - 1 && arr[i + 1] > arr[i]) {
                sum++;
                i++;
            }
            longest = Math.max(longest, sum);
        }
        System.out.println(longest);
        scanner.close();
    }
}
