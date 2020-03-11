package snippets.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Write a program that reads an array of ints named A and cyclically shift the elements of the array to the right: A[0] goes to the place of A[1], A[1] - to the place of A[2], ..., and the last element goes to the place of A[0]).

Input data format

The first line of the input contains the number of elements in the array. The second line – the elements of the array.

Output data format

The single line contains all shifted elements of the array. Elements must be separated by the space character.

Sample Input 1:

5
1 2 3 4 5
Sample Output 1:

5 1 2 3 4
 */
public class Shifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[(i + 1) % size] = scanner.nextInt();
        }
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    public static String shift(int size, int[] arr) {

        int l = size;
        int[] a = new int[size];
        a[0] = arr[l];
        for (int i = 1; i <= l; i++) {
            a[i] = arr[i - 1];

        }
        StringBuilder builder = new StringBuilder();
        for (int i : a) {
            builder.append(i + " ");
        }

        return builder.toString().trim();
    }
}
