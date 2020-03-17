package hyperskill.collection.maps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * Modify and return the given map as follows:

if the first key % 2 != 0, return sub-map from firstKey inclusive to firstKey + 4 inclusive in descending order;
else return sub-map from lastKey - 4 inclusive to the lastKey inclusive in descending order.
Hint

To make TreeMap store elements in descending order you can create it this way: new TreeMap<>(Collections.reverseOrder());

To put all elements from one map to another map you can do anotherMap.putAll(map) 

Sample Input 1:

1:one 2:two 3:three 4:four 5:five 6:six 7:seven
Sample Output 1:

5 : five
4 : four
3 : three
2 : two
1 : one
Sample Input 2:

2:two 4:four 6:six 8:eight 10:ten 12:twelve 14:fourteen
Sample Output 2:

14 : fourteen
12 : twelve
10 : ten
 */
public class ProcessingMaps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add lines");

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = ProcessingMaps.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));

    }

    private static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        SortedMap<Integer, String> ret = new TreeMap<>(Collections.reverseOrder());
        System.out.println(map.size());
        if (map.firstKey() % 2 != 0) {
            ret.putAll(map.subMap(1, true, 5, true));
        } else {
            ret.putAll(map.subMap(map.size()-5, true, map.size()-1, true));
        }
        return ret;
    }

}
