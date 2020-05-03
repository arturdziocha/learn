package hyperskill.projects.readibility.stage3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Character.isAlphabetic(33));
        //System.out.println("add");
        String fileName = "src/main/java/hyperskill/projects/readibility/stage3/test.txt";// + scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double numOfChars = 0;
            StringBuilder builder = new StringBuilder();
            int next;
            System.out.println("The text is:");
            while ((next = reader.read()) != -1) {
                builder.append((char) next);
                if (!Character.isWhitespace(next)) {
                    numOfChars++;
                }
            }
            List<String> lines =
                    Arrays.stream(builder.toString().split("[.!?]\\s+")).collect(Collectors.toCollection(ArrayList::new));
            System.out.println();
            System.out.println();
            double numOfWords = lines.stream().flatMap(l -> Arrays.stream(l.split("\\s"))).count();
            System.out.printf("Words: %.0f\n", numOfWords);
            System.out.printf("Sentences: %d\n", lines.size());
            System.out.printf("Characters: %.0f\n", numOfChars);
            double score = 4.71 * (numOfChars / numOfWords) + 0.5 * (numOfWords / lines.size()) - 21.43;
            System.out.printf("The score is: %.2f\n", score);
        }

    }
}
