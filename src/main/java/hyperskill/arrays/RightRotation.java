package hyperskill.arrays;

import java.util.ArrayList;
/*
 * A right rotation is an operation that shifts each element of an array to the right. For example, if an array is {1,2,3,4,5} and we right rotate it by 1, the new array will be {5,1,2,3,4}. If we rotate it by 2, the new array will be {4,5,1,2,3}. It goes like this: {1,2,3,4,5} -> {5,1,2,3,4} -> {4,5,1,2,3}.

Write a program, that performs a right rotation on an array by a given number.

Input format:
The first line is an array of numbers.
The second line is the number of rotations.

Output format:
Resulting array

Sample Input 1:

1 2 3 4 5
1
Sample Output 1:

5 1 2 3 4
Sample Input 2:

1 2 3 4 5
2
Sample Output 2:

4 5 1 2 3
Sample Input 3:

1 2 3 4 5
8
Sample Output 3:

3 4 5 1 2
Sample Input 4:

11 21 1 41 51 78 90
10000
Sample Output 4:

41 51 78 90 11 21 1
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RightRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int move = Integer.parseInt(scanner.nextLine());
        scanner.close();
        // for (int i = 0; i < move % array.length; i++) {
        // rotate(array);
        // }
        System.out
                .println(rotateList(array, move % array.length)
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
        // System.out.println(Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining("
        // ")));
    }

    static void rotate(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i - 1];
            array[i - 1] = array[i];
            array[i] = temp;
        }
    }

    static List<Integer> rotateList(int[] array, int rotation) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.rotate(list, rotation);
        return list;
    }
}
