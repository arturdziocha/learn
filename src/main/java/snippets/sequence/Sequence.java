package snippets.sequence;

import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add number");
        int max = scanner.nextInt();
        int current = 1;
        int count = 0;
        while (count != max) {
            for (int i = 0; i < current; i++) {
                System.out.print(current + " ");
                count += 1;
                if (count == max) {
                    break;
                }
            }
            current += 1;
        }
        scanner.close();
    }
}
