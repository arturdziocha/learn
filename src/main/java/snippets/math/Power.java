package snippets.math;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add numbers");
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        System.out.println(power(number, power));
        scanner.close();
    }

    static long power(int n, int m) {
        return (long) Math.pow(n, m);
    }
}
