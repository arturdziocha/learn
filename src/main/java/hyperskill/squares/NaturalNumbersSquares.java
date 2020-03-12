package hyperskill.squares;

import java.util.Scanner;

public class NaturalNumbersSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add num");
        int max = scanner.nextInt();
        for (int i = 1; i <= Math.sqrt(max); i++) {
            System.out.println((int) Math.pow(i, 2));
        }
    }
}
