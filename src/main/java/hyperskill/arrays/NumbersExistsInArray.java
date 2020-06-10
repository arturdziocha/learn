package hyperskill.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NumbersExistsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(doTheNumbersExistInArray(array, numbers));

    }

    private static boolean doTheNumbersExistInArray(int[] array, int[] numbers) {
        return Arrays.stream(array).filter(i -> i != numbers[0]).filter(i -> i != numbers[1]).count() != array.length;
    }
}
