package hyperskill.collection.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Write a program that finds out the closest integer to a given one from an array. If you find several integers with the same distance to the N, you should output all of them in the ascending order. If the are several equal numbers, output them all.

Input: a set of integers and a number N.  

Output: some number(s) from the given array.

Sample Input 1:

1 2 4 5
3
Sample Output 1:

2 4
Sample Input 2:

1 2 3 4
6
Sample Output 2:

4
Sample Input 3:

5 1 3 3 1 5
4
Sample Output 3:

3 3 5 5
 */
public class FindNearest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        List<Integer> list = readArrayList(scanner);
        int value = Integer.parseInt(scanner.nextLine());
        int distance = Integer.MAX_VALUE;
        List<Integer> values = new ArrayList<>();
        for (int i : list) {
            int d = Math.abs(value - i);
            if (d < distance) {
                distance = d;                
                values.clear();
                values.add(i);
            } else if (d == distance) {
                values.add(i);                
            }
        }
        Collections.sort(values);
        values.forEach(n -> System.out.print(n + " "));
    }

    public static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
