package hyperskill.collection;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

/*
Write a program that reads key-value pairs and outputs pairs whose keys belongs to the specified range (inclusive) in the ascending order by the key.

Input data format

The first line contains two values - range borders. The second line contains the number of key-value pairs. Next lines contain pair (an integer key and a string value separated by a space).

Output data format

All pairs whose keys belong to the range. Each pair in a new line. The key and the value of a pair must be separated by a space.
Sample Input 1:

2 4
5
1 aa
5 ee
2 bb
4 dd
3 cc
Sample Output 1:

2 bb
3 cc
4 dd
 */
public class MapGettingSubmaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Add lines");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        NavigableMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            map.put(Integer.parseInt(line[0]), line[1]);
        }
        map.subMap(start, true, end, true).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
