package hyperskill.collection.maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int howManyCards = Integer.parseInt(scanner.nextLine());

        Map<String, String> answers = new TreeMap<>();
        for (int i = 1; i <= howManyCards; i++) {
            System.out.println("The card #" + i + ":");
            String name;
            while (answers.containsKey(name = scanner.nextLine())) {
                System.out.println("The card \"" + name + "\" already exists. Try again:");
            }
            System.out.println("The definition of the card #" + i + ":");
            String definition;
            while (answers.containsValue(definition = scanner.nextLine())) {
                System.out.println("The definition \"" + definition + "\" already exists. Try again:");

            }
            answers.put(name, definition);
        }
        answers.forEach((key, val) -> {
            System.out.println("Print the definition of \"" + key + "\":");
            String answer = scanner.nextLine();
            if (answer.equals(val)) {
                System.out.println("Correct answer.");
            } else {
                System.out.print("Wrong answer. ");
                if (answers.containsValue(answer)) {
                    String k = answers
                            .entrySet()
                            .stream()
                            .filter(es -> es.getValue().equals(answer))
                            .findFirst()
                            .map(Map.Entry::getKey)
                            .get();
                    System.out
                            .println("The correct one is \"" + val + "\", you've just written the definition of \"" + k
                                    + "\".");
                } else {
                    System.out.println("The correct one is \"" + val + "\".");
                }
            }
        });
        scanner.close();
        
        
        /* Old
         * Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int numOfCards = Integer.parseInt(scanner.nextLine());
        String[] nameOfCards = new String[numOfCards];
        String[] definitions = new String[numOfCards];
        String[] cards = new String[numOfCards];
        for (int i = 0; i < numOfCards; i++) {
            System.out.println("The card #" + (i + 1) + ":");
            nameOfCards[i] = scanner.nextLine();
            System.out.println("The definition of the card #" + (i + 1) + ":");
            definitions[i] = scanner.nextLine();
        }
        for (int i = 0; i < numOfCards; i++) {
            System.out.println("Print the definition of \"" + nameOfCards[i] + "\":");
            String answer = scanner.nextLine();
            if (answer.equals(definitions[i])) {
                System.out.println("Correct answer.");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + definitions[i] + "\".");
            }
        }
         */
    }
}
