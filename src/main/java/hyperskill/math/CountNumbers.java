package hyperskill.math;

import java.util.Scanner;
import java.util.stream.LongStream;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long count =
                LongStream.rangeClosed(1, number / 2).filter(i -> number % i == 0).count();
        System.out.println(count > 0);
    }

}
