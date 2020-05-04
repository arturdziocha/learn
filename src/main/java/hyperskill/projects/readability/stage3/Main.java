package hyperskill.projects.readability.stage3;

import java.io.BufferedReader;
import java.io.File;
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
        System.out.println("add");
        // String fileName =
        // "src/main/java/hyperskill/projects/readability/stage3/test.txt";
        String fileName = "src/main/java/hyperskill/projects/readability/stage3/" + scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            double numOfChars = 0;
            StringBuilder builder = new StringBuilder();
            int next;

            while ((next = reader.read()) != -1) {
                builder.append((char) next);
                if (!Character.isWhitespace(next)) {
                    numOfChars++;
                }
            }
            scanner.close();
            System.out.println("The text is:");
            System.out.print(builder);
            List<String> lines = Arrays
                    .stream(builder.toString().split("[.!?]\\s+"))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println();
            System.out.println();
            double numOfWords = lines.stream().flatMap(l -> Arrays.stream(l.split("\\s"))).count();
            System.out.printf("Words: %.0f\n", numOfWords);
            System.out.printf("Sentences: %d\n", lines.size());
            System.out.printf("Characters: %.0f\n", numOfChars);
            double score = 4.71 * (numOfChars / numOfWords) + 0.5 * (numOfWords / lines.size()) - 21.43;
            int sc = (int) Math.ceil(score);
            System.out.printf("The score is: %.2f\n", score);
            String v = "";
            switch (sc) {
                case 1:
                    v = "5-6";
                    break;
                case 2:
                    v = "6-7";
                    break;
                case 3:
                    v = "7-9";
                    break;
                case 4:
                    v = "9-10";
                    break;
                case 5:
                    v = "10-11";
                    break;
                case 6:
                    v = "11-12";
                    break;
                case 7:
                    v = "12-13";
                    break;
                case 8:
                    v = "13-14";
                    break;
                case 9:
                    v = "14-15";
                    break;
                case 10:
                    v = "15-16";
                    break;
                case 11:
                    v = "16-17";
                    break;
                case 12:
                    v = "17-18";
                    break;
                case 13:
                    v = "18-24";
                    break;
                case 14:
                    v = "24+";
                    break;

                default:
                    break;
            }
            System.out.printf("This text should be understood by %s year olds.", v);

        }

    }
}
