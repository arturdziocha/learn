package snippets.colatz;

import java.util.Scanner;

public class CollatzConjecture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set number: ");
        int n = scanner.nextInt();
        while (n != 1) {
            System.out.print(n + " ");
            n = (n % 2 == 0) ? (n / 2) : (n * 3 + 1);
        }
        System.out.print(n);
        scanner.close();
    }
}
