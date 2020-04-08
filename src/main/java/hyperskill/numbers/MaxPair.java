package hyperskill.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Write a program that reads an array of ints and outputs the maximum pairwise product in the given array of non-negative numbers.

Input data format

The first line of the input contains the number of elements in the array.

The second line contains the elements of the array separated by spaces.

The array always has at least two elements.

Sample Input 1:

2
5 3
Sample Output 1:

15
Sample Input 2:

3
10 8 4
Sample Output 2:

80
 */
public class MaxPair {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int arrSize = Integer.parseInt(scanner.nextLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println(arr);
        int max = 0;
        if (arrSize < 3) {
            max = arr.get(0) * arr.get(1);
        } else {
            for (int i = 0; i < arrSize - 1; i++) {
                max = Math.max(max, arr.get(i) * arr.get(i + 1));
            }
        }
        System.out.println(max);
        scanner.close();

    }

}
