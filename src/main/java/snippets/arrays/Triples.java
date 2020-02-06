package snippets.arrays;

import java.util.Scanner;

public class Triples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please add numbers");
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }                
        int howMany = 0;
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] + 1 == arr[i + 1] && arr[i] + 2 == arr[i + 2]) {
                howMany += 1;
            }
        }
//        for (int i = 2; i < ints.length; i++) {
//            if (ints[i] - ints[i - 1] == 1 && ints[i - 1] - ints[i - 2] == 1) {
//                triples++;
//            }
//        }
        System.out.println(howMany);
        scanner.close();
    }
}
