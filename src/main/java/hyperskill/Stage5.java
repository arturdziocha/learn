package hyperskill;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Stage5 {
    public static void main(String[] args) {
        Map<String, String> cards = new TreeMap<>();
        Map<String, BiConsumer<Scanner, Map<String, String>>> actions = new LinkedHashMap<>();
        actions.put("add", (sc, ca) -> {
            System.out.println("The card:");
            String cardName = sc.nextLine();
            if (ca.containsKey(cardName)) {
                System.out.println("The card \"" + cardName + "\" already exists.");
            } else {
                System.out.println("The definition of the card:");
                String definition = sc.nextLine();
                if (ca.containsValue(definition)) {
                    System.out.println("The definition \"" + definition + "\" already exists.");
                } else {
                    ca.put(cardName, definition);
                    System.out.println("The pair (\"" + cardName + "\":\"" + definition + "\") has been added.");
                }
            }
            System.out.println();
        });
        actions.put("remove", (sc, ca) -> {
            System.out.println("The card:");
            String cardName = sc.nextLine();
            if (ca.containsKey(cardName)) {
                ca.remove(cardName);
                System.out.println("The card has been removed.");
            } else {
                System.out.println("Can't remove \"" + cardName + "\": there is no such card.");
            }
            System.out.println();
        });
        actions.put("import", (sc, ca) -> {
            System.out.println("File name:");
            try {
                
            }
        });
        boolean actionFlag = true;
        Scanner scanner = new Scanner(System.in);
        while (actionFlag) {
            System.out.println("Input the action (add, remove, import, export, ask, exit)");
            System.out.println("add action");
            String actionName = scanner.nextLine();
            if (actionName.equals("exit")) {
                System.out.println("Good bye");
                actionFlag = false;
            } else {
                actions.get(actionName).accept(scanner, cards);
            }
            /**
             * switch (actionName) { case "exit": System.out.println("Good
             * bye"); actionFlag = false; break; case "add": add(scanner,
             * cards); break; }
             */
            System.out.println(cards);
        }

    }
}
