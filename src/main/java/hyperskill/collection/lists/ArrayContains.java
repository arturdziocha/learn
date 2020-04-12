package hyperskill.collection.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Write a program that reads an array of integers and an integer. The program must check if the array contains that number.

Input data format

The first line: the size of an array.

The second line: all the elements of the array separated by the space.

The third line: one integer.

Output data format

Only a single value: true or false.

Sample Input 1:

3
1 3 2
3
Sample Output 1:

true
Sample Input 2:

5
1 3 2 5 4
7
Sample Output 2:

false
 */
public class ArrayContains {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int howMany = Integer.parseInt(scanner.nextLine());
        List<Integer> ints = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        Integer toFind = Integer.parseInt(scanner.nextLine());
        System.out.println(ints.contains(toFind));

    }

}
