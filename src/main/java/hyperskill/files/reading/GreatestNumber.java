package hyperskill.files.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Here is a file containing a sequence of integers separated by spaces.

Download it and write a Java program that finds the greatest number in this file.

Enter the result.
 */
public class GreatestNumber {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/hyperskill/files/greatestNumber.txt");
        try (Scanner scanner = new Scanner(file)) {
            int greatest = 0;
            int num;
            while (scanner.hasNext()) {
                num = scanner.nextInt();
                greatest = Math.max(num, greatest);
            }
            System.out.println(greatest);
        }
    }
}
