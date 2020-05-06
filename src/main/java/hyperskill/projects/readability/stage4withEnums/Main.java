package hyperskill.projects.readability.stage4withEnums;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Application(new TextStatistics(readFile(args[0]))).run();
        } catch (IOException e) {
            e.printStackTrace();
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
}