package hyperskill.chars.numbers;

import java.util.Scanner;

public class NextEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ss");
        int number = scanner.nextInt();
        int nextEven = number - number % 2 + 2;
        scanner.close();
        System.out.println(nextEven);

    }

}
