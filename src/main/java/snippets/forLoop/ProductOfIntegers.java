package snippets.forLoop;

import java.util.Scanner;

public class ProductOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int sum = 1;
        for (int i = start; i < end; i++) {
            sum *= i;
        }
        System.out.println(sum);
    }
}
