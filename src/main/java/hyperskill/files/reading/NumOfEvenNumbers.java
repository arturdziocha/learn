package hyperskill.files.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Here is a file containing a sequence of integers. Each number begins a new line.

 

Download the file and write a Java program that counts the number of even numbers in this file. You should stop counting either if you get 0 or the last number is reached.
 */
public class NumOfEvenNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/hyperskill/files/evenNumbers.txt");
        try (Scanner scanner = new Scanner(file)) {
            int sum = 0;
            int num;
            while (scanner.hasNext()) {
                num = scanner.nextInt();
                if(num==0) {
                    break;
                }
                if (num % 2 == 0) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
