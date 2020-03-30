package hyperskill.files.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
  Here is a file containing a sequence of integers separated by spaces.

Download it and write a Java program that counts numbers that are greater than or equal to 9999.

Enter the count.
 */
public class CountNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/hyperskill/files/countNumbers.txt");
        try (Scanner scanner = new Scanner(file)) {
            int sum = 0;
            int number;
            while (scanner.hasNext()) {
                number = scanner.nextInt();
                if (number >= 9999) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
