package hyperskill.projects.readibility.stage2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sentences = line.split("[.!?]");
        long wordCount = Arrays.stream(sentences).flatMap(s -> Arrays.stream(s.split("\\s"))).count();
        System.out.println(wordCount / (sentences.length) > 10 ? "HARD" : "EASY");
    }
}
