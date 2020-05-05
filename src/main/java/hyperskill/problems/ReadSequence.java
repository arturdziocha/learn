package hyperskill.problems;

import java.util.Scanner;

public class ReadSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (next != 0) {
            next = Integer.parseInt(scanner.nextLine());
            sum++;
        }
        scanner.close();
        System.out.println(sum);
    }
}
