package hyperskill.numbers;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(IntStream.rangeClosed(scanner.nextInt(), scanner.nextInt()).sum());
    }
}
