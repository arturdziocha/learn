package hyperskill.collection.mapCount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Implement these two methods for a given array of string:

wordCount that returns a SortedMap<String, Integer> where keys are all different strings and values are the number of times that string appears in the array. The method takes an array of strings as input;
printMap that prints all entries of the map ("key : value").
Sample Input 1:

a b b c d a b
Sample Output 1:

a : 2
b : 3
c : 1
d : 1
*/
public class CountingWords {
    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.computeIfPresent(str, (k, v) -> v += 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;

    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add numbers: ");
        String[] words = scanner.nextLine().split(" ");
        CountingWords.printMap(CountingWords.wordCount(words));
    }
}
