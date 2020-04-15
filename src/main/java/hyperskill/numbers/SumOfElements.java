package hyperskill.numbers;

import java.util.Scanner;

public class SumOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next;
        int sum = 0;
        do {
            next = Integer.parseInt(scanner.nextLine());
            sum += next;
        } while (next == 0);
        System.out.println(sum);
    }
}
