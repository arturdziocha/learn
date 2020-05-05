package hyperskill.projects.readability.stage5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/hyperskill/projects/readability/stage3/test.txt";
        // String fileName = args[0];
        String text = readFile(fileName);
        String[] ages = {"5-6", "6-7", "7-9", "9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17",
                "17-18", "18-24", "24+"};
        long sentences = countWithRegex(text, "[!.?][^$]|$");
        long words = countWithRegex(text, "\\d+,\\d+|\\w+");
        long chars = countWithRegex(text, "\\S");
        double score = 4.71 * ((double) chars / words) + 0.5 * ((double) words / sentences) - 21.43;
        System.out.printf("The text is: \n%s\n\n", text);
        System.out.printf("Words: %d\n", words);
        System.out.printf("Sentences: %d\n", sentences);
        System.out.printf("Characters: %d\n", chars);
        System.out.printf("The score is: %.2f \n", score);
        System.out.println(Math.ceil(score) - 1);
        System.out.printf("This text should be understood by %s year olds.", ages[(int) Math.ceil(score) - 1]);

        List<String> w = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+,\\d+|\\w+").matcher(text);
        while (matcher.find()) {
            w.add(matcher.group());
        }
        System.out.println();
        System.out.println(w);
        int l=0;
        for (String s : w) {
            l += countWithRegex(s);
            System.out.println(s + " " + countWithRegex(s));
        }
        System.out.println(l);
    }

    private static int countWithRegex(String word) {
        String i = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher m = Pattern.compile(i).matcher(word);
        int count = 0;

        while (m.find()) {
            count++;
        }

        // return at least 1
        return Math.max(count, 1);
    }

    private static long countWithRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        long sum = 0;
        while (matcher.find()) {
            sum++;
        }
        return sum;
        // return matcher.results().count(); Java 9
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
}
