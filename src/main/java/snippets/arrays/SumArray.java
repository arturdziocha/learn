package snippets.arrays;

import java.util.Scanner;

public class SumArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = scanner.nextInt();
        int sum = 0;
        for (int s : arr) {
            if (s > max) {
                sum += s;
            }
        }
        System.out.print(sum);
        scanner.close();
    }

}
