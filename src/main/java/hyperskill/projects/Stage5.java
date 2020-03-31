package hyperskill.projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/*
 * Description
Improve the application's interactivity. Ask the user for action and make it.

Support these actions:

add a card: add,
remove a card: remove,
load cards from file: import,
save cards to file: export,
ask for a definition of some random cards: ask,
exit the program: exit.
When entering the word export, the program should request a file name and write all currently available cards into this file.
When entering the word import, the program should request a file name and read all the cards written to this file.

You can use any format to save cards to the file. Tests do not check the content of the file, but they do check that all saved cards are loaded correctly.

In this stage, if you try to add a card with an existing term or an existing definition, the application must just reject it by printing an error message (see example 1).

When you load cards from a file, you shouldn't erase the cards that aren't in the file. If the imported card already exists, it should update the old one (look at cards Japan and Moscow in the example 2). It is guaranteed, that there won't be any conflicts with definitions in the tests.

Examples
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1:

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> France
The definition of the card:
> Paris
The pair ("France":"Paris") has been added.
 
Input the action (add, remove, import, export, ask, exit):
> add
The card:
> France
The card "France" already exists.
 
Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Great Britain
The definition of the card:
> Paris
The definition "Paris" already exists.
 
Input the action (add, remove, import, export, ask, exit):
> remove
The card:
> France
The card has been removed.
 
Input the action (add, remove, import, export, ask, exit):
> remove
The card:
> Wakanda
Can't remove "Wakanda": there is no such card.
 
Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
Example 2:

Input the action (add, remove, import, export, ask, exit):
> import
File name:
> ghost_file.txt
File not found.
 
Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Japan
The definition of the card:
> Tokyo
The pair ("Japan":"Tokyo") has been added.
 
Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Russia
The definition of the card:
> UpdateMeFromFile
The pair ("Russia":"UpdateMeFromFile") has been added.
 
Input the action (add, remove, import, export, ask, exit):
> import
File name:
> capitals.txt
28 cards have been loaded.
 
Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Moscow
Correct answer.
 
Input the action (add, remove, import, export, ask, exit):
> export
File name:
> capitalsNew.txt
29 cards have been saved.
 
Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
Example 3:

Input the action (add, remove, import, export, ask, exit):
> add
The card
> a brother of one's parent
The definition of the card
> uncle
The pair ("a brother of one's parent":"uncle") has been added.
 
Input the action (add, remove, import, export, ask, exit):
> add
The card
> a part of the body where the foot and the leg meet
The definition of the card
> ankle
The pair ("a part of the body where the foot and the leg meet":"ankle") has been added.
 
Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 6
Print the definition of "a brother of one's parent":
> ankle
Wrong answer. The correct one is "uncle", you've just written the definition of "a part of the body where the foot and the leg meet".
Print the definition of "a part of the body where the foot and the leg meet":
> ??
Wrong answer. The correct one is "ankle".
Print the definition of "a brother of one's parent":
> uncle
Correct answer
Print the definition of "a part of the body where the foot and the leg meet":
> ankle
Correct answer
Print the definition of "a brother of one's parent":
> ??
Wrong answer. The correct one is "uncle".
Print the definition of "a part of the body where the foot and the leg meet":
> uncle
Wrong answer. The correct one is "ankle", you've just written the definition of "a brother of one's parent".
Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
 */
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
            // String fileName = "src/main/java/hyperskill/projects/" +
            // sc.nextLine();
            String fileName = sc.nextLine();
            try (Scanner scanner = new Scanner(new File(fileName))) {
                int count = 0;
                while (scanner.hasNext()) {
                    String cardName = scanner.nextLine();
                    String definition = scanner.nextLine();
                    count++;
                    ca.put(cardName, definition);
                }
                System.out.println(count + " cards have been loaded.");
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
            System.out.println();
        });
        actions.put("export", (sc, ca) -> {
            System.out.println("File name:");
            // String fileName = "src/main/java/hyperskill/projects/" +
            // sc.nextLine();
            String fileName = sc.nextLine();
            try (PrintWriter writer = new PrintWriter(fileName)) {
                ca.forEach((key, value) -> {
                    writer.println(key);
                    writer.println(value);
                });
                System.out.println(ca.size() + " cards have been saved.");
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
            System.out.println();
        });
        actions.put("ask", (sc, ca) -> {
            System.out.println("How many times to ask?");
            int howManyAsk = Integer.parseInt(sc.nextLine());
            
            List<String> keys = new ArrayList<>(ca.keySet());
            int cardsSize = keys.size();
            for (int i = 1; i <= howManyAsk; i++) {
                Random random = new Random(i);
                String key = keys.get(random.nextInt(cardsSize));
                String value = ca.get(key);
                System.out.println("Print the definition of \"" + key + "\":");
                String answer = sc.nextLine();
                if (answer.equals(value)) {
                    System.out.println("Correct answer.");
                } else if (ca.containsValue(answer)) {
                    String goodAnswer = ca
                            .entrySet()
                            .stream()
                            .filter(c -> c.getValue().equals(answer))
                            .findFirst()
                            .map(Map.Entry::getKey)
                            .get();
                    System.out
                            .println("Wrong answer.  The correct one is \"" + value
                                    + "\", you've just written the definition of \"" + goodAnswer + "\".");
                } else {
                    System.out.println("Wrong answer. The correct one is \"" + value + "\".");
                }
            }
            
            System.out.println();
        });
        boolean actionFlag = true;
        Scanner scanner = new Scanner(System.in);
        while (actionFlag) {
            System.out.println("Input the action (add, remove, import, export, ask, exit)");
            // System.out.println("add action");
            String actionName = scanner.nextLine();
            if (actionName.equals("exit")) {
                System.out.println("Bye bye!");
                actionFlag = false;
            } else if (actions.containsKey(actionName)) {
                actions.get(actionName).accept(scanner, cards);
            } else {
                actionFlag = false;
            }
            /**
             * switch (actionName) { case "exit": System.out.println("Good
             * bye"); actionFlag = false; break; case "add": add(scanner,
             * cards); break; }
             */
            // System.out.println(cards);
        }
    }   
}
