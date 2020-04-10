package hyperskill.problems;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Sum of ints divisible by 6
 */
public class NumbersDivisibleBySix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMany = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(IntStream.of(arr).filter(i -> i % 6 == 0).sum());
        scanner.close();
    }
}
