package hyperskill.collection.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapRemoveChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        Character[] c1 = word1.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] c2 = word1.chars().mapToObj(c -> (char) c).toArray(Character[]::new);


    }
}
