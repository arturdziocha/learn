package hyperskill.collection.sets;

import java.util.*;
/*
mplement a method for finding the symmetric difference of the two given sets. Elements in the resulting set can be in any order.

An example

The symmetric difference of two sets {1, 2, 3} and {0, 1, 2} is {0, 3}

Sample Input 1:

1 2 3
0 1 2
Sample Output 1:

0 3
 */
public class SetSymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> set12 = new HashSet<>(set1);
        Set<T> set22 = new HashSet<>(set2);
        set12.removeAll(set2);
        set22.removeAll(set1);
        set12.addAll(set22);
        return set12;
    }

    public static void main(String[] args) {
        System.out.println(5 | 5 + 4 & 4);
        Scanner scanner = new Scanner(System.in);
        System.out.println("add lines");
        String strSet1 = scanner.nextLine();
        String strSet2 = scanner.nextLine();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        if (!Objects.equals(strSet1, "empty")) {
            Collections.addAll(set1, strSet1.split("\\s+"));
        }

        if (!Objects.equals(strSet2, "empty")) {
            Collections.addAll(set2, strSet2.split("\\s+"));
        }

        Set<String> resultSet = SetSymmetricDifference.symmetricDifference(set1, set2);

        System.out.println(String.join(" ", resultSet));
    }
}
