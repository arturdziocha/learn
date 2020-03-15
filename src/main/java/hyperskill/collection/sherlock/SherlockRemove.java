package hyperskill.collection.sherlock;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
For this problem, imagine that you are Sherlock Holmes. You've deduced that the clues are somehow hidden within the pairs of words that contain only the same letters with the same frequencies. To crack the case, you now need to find out how many characters must be deleted to get such words (character sequences) from the given ones.

For example: for two words "case" and "seal" you'll need to remove characters "c" and "l" respectively to get "ase" and "sea". In this case, the answer is 2 ("c" and "l").

Remember: these "words" are case-insensitive

Sample Input 1:

case
seal
Sample Output 1:

2
 */
public class SherlockRemove {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("add strings");
        Map<Character, Long> firstWord =
                scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        Map<Character, Long> secondWord = scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));

    }
}
