package hyperskill.collection;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
Implement two methods.

The first method should create a set from a string of numbers separated by a space.

The second method should remove all numbers greater than 10 from the given set.

Sample Input 1:

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
Sample Output 1:

1 2 3 4 5 6 7 8 9 10
 */
public class SetRemovingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add num: ");
        String numbers = scanner.nextLine();
        Set<Integer> set = SetRemovingElements.getSetFromString(numbers);
        SetRemovingElements.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }

    private static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(num -> num > 10);
    }

    private static Set<Integer> getSetFromString(String numbers) {
        return Arrays.stream(numbers.split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
    }
}
