package snippets.math;

import java.util.Scanner;

public class NumberReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add number");
        int value = scanner.nextInt();
        int units = value % 10;
        int hundreds = value / 100;
        int tens = (value - units - hundreds * 100) / 10;

        System.out.println(units * 100 + tens * 10 + hundreds);
    }
}
