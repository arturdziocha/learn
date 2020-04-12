package hyperskill.collection.maps.mapShare;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
You need to implement the mapShare method that should modify and return the given map as follows:

if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unmodified.

{"a":"abstraction","b":"boolean","c":"xyz"} -> {"a":"abstraction","b":"abstraction"}
Sample Input 1:

a:Abstraction
b:Boolean
c:xyz
Sample Output 1:

a:Abstraction
b:Abstraction
 */
public class MapUtils {
    public static void mapShare(Map<String, String> map) {
        if (map.containsKey("a") && (!map.get("a").isEmpty() || map.get("a") != null)) {
            if (map.containsKey("b")) {
                map.replace("b", map.get("a"));
            } else {
                map.put("b", map.get("a"));
            }
        }
        map.remove("c");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(":");
            map.put(pair[0], pair[1]);
        }
        MapUtils.mapShare(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        scanner.close();
    }
}
