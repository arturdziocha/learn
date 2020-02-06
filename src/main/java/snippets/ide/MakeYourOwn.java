package snippets.ide;

import java.util.Scanner;

public class MakeYourOwn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
    }
}
