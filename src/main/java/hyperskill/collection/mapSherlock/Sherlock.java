package hyperskill.collection.mapSherlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * For this problem, imagine that you are Sherlock Holmes. You've deduced that the clues are somehow hidden within the pairs of words that contain only the same letters with the same frequencies. To crack the case, you now need to find out how many characters must be deleted to get such words (character sequences) from the given ones.

For example: for two words "case" and "seal" you'll need to remove characters "c" and "l" respectively to get "ase" and "sea". In this case, the answer is 2 ("c" and "l").

Remember: these "words" are case-insensitive

Sample Input 1:
case
seal

Sample Output 1:
2
 */
public class Sherlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("add strings");
        String[] arr = new String[2];
        arr[0] = scanner.nextLine();
        arr[1] = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (String str : arr) {
            for (char c : str.toCharArray()) {
                if (map.containsKey(c)) {
                    map.computeIfPresent(c, (k, v) -> v += 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        System.out.println(map.entrySet().stream().filter(x -> x.getValue() == 1).count());
        scanner.close();
    }
}
