package hyperskill.inputStreams;

import java.util.Arrays;
import java.util.Scanner;

public class ScanningTheInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.next();
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

}
