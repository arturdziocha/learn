package hyperskill.projects.readability.stage4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M {

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/hyperskill/projects/readability/stage4/test.txt";
        // String fileName = args[0];
        String text = readFile(fileName);
        InputReader reader = new InputReader(text);
        print(reader);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.next().toLowerCase();
        scanner.close();
        System.out.println();
        double score, age;
        switch (input) {
            case "ari":
                score = getScore(reader, new ARIScore());
                age = getAge(score);
                printScore(ScorePrint.ARI, score, age);
                break;
            case "fk":
                score = getScore(reader, new FKScore());
                age = getAge(score);
                printScore(ScorePrint.ARI, score, age);
            case "smog":
                score = getScore(reader, new SmogScore());
                age = getAge(score);
                printScore(ScorePrint.SMOG, score, age);
            case "cl":
                score = getScore(reader, new ClScore());
                age = getAge(score);
                printScore(ScorePrint.CL, score, age);
            case "all":
                double totalAge = 0;
                score = getScore(reader, new ARIScore());
                age = getAge(score);
                printScore(ScorePrint.ARI, score, age);
                totalAge += age;
                score = getScore(reader, new FKScore());
                age = getAge(score);
                printScore(ScorePrint.ARI, score, age);
                totalAge += age;
                score = getScore(reader, new SmogScore());
                age = getAge(score);
                printScore(ScorePrint.SMOG, score, age);
                totalAge += age;
                score = getScore(reader, new ClScore());
                age = getAge(score);
                printScore(ScorePrint.CL, score, age);
                totalAge += age;
                System.out.printf("This text should be understood in average by %.2f year olds.", totalAge / 4.0);

        }

    }

    private static String readFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int next;
            while ((next = reader.read()) != -1) {
                builder.append((char) next);
            }
        }
        return builder.toString();
    }

    private static void print(InputReader reader) {
        System.out
                .printf(
                    "The text is: \n%s\n\n" + "Words: %d\n" + "Sentences: %d\n" + "Characters: %d\n" + "Syllables: %d\n"
                            + "Polysyllables: %d\n",
                    reader.getText(), reader.getWords(), reader.getSentences(), reader.getChars(), reader.getSyllabes(),
                    reader.getPolySyllables());

    }

    private static double getScore(InputReader reader, Score strategy) {
        Context context = new Context(strategy);
        return context.getScore(reader);
    }

    private static void printScore(ScorePrint scorePrint, double score, double age) {
        System.out.printf("%s: %.2f (about %.0f year olds)\n", scorePrint.getS(), score, age);
    }

    private static double getAge(double score) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 5.0);
        map.put(2, 6.0);
        map.put(3, 7.0);
        map.put(4, 9.0);
        map.put(5, 10.0);
        map.put(6, 11.0);
        map.put(7, 12.0);
        map.put(8, 13.0);
        map.put(9, 14.0);
        map.put(10, 15.0);
        map.put(11, 16.0);
        map.put(12, 17.0);
        map.put(13, 18.0);
        return map.getOrDefault((int) Math.ceil(score), 24.0);
    }

}
