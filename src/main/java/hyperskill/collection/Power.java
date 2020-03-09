package hyperskill.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Power {
    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        // write your code here
        return numbers.stream().map(num -> num * num).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collection<Integer> result = Power.pow2(numbers);

        System.out.println(result.stream()
                .map(Object::toString).collect(Collectors.joining()));

    }

}
