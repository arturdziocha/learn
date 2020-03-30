package hyperskill.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        File file = new File("src/main/java/hyperskill/files/numbers.txt");
        try (Scanner scanner = new Scanner(file)) {
            long sum = 0;
            while (scanner.hasNext()) {
                sum += scanner.nextLong();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
