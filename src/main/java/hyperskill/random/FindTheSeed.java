package hyperskill.random;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FindTheSeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add nums:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int max = k;
        int seed = 0;
        
        for (int i = a; i <= b; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = new Random().nextInt(k);
            }
            
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            if (max > arr[n - 1]) {
                max = arr[n - 1];
                seed = i;
            }
            System.out.println(seed);
            System.out.println(max);
        }
        System.out.println(seed);
        System.out.println(max);
    }
}
