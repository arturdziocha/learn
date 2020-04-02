package hyperskill.projects.stage6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/*
 * Add some statistics features. We suggest you implement the following:

Action log saves the application log to the given file. Save all lines that have been input in or output to the console to the file. You can use a list to store the lines.
Action hardest card prints the term of the card that has the most mistakes. You can store the mistake count in a map. If there are no cards with mistakes, you should print There are no cards with errors.. And for multiple hardest cards, you should list them all, like in the example below.
Action reset stats erases the mistake counts for all cards.
Also you should update serialization/deserialization to store sets of three items (term, definition, mistakes) instead of pairs (term, definition).

Example

The symbol > represents the user input. Notice that it's not the part of the input.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> import
File name:
> capitals.txt
28 cards have been loaded.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest card is "France". You have 10 errors answering it.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Paris
Wrong answer. (The correct one is "Moscow", you've just written the definition of "France" card.)

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest cards are "Russia", "France". You have 10 errors answering them.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> reset stats
Card statistics has been reset.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> log
File name:
> todayLog.txt
The log has been saved.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> exit
Bye bye!
 */
public class Stage6 {
    private final CardFacade cardFacade;
    private final LogFacade logFacade;

    public Stage6() {
        this.cardFacade = new CardFacade();
        this.logFacade = new LogFacade();
    }

    public CardFacade getCardFacade() {
        return cardFacade;
    }

    public LogFacade getLogFacade() {
        return logFacade;
    }

    public static void main(String[] args) {

        Map<String, BiConsumer<Scanner, Stage6>> actions = new LinkedHashMap<>();
        actions.put("add", (sc, st) -> {
            printAndLog("The card:", st.getLogFacade());

            String cardName = sc.nextLine();
            log(cardName, st.getLogFacade());
            if (st.getCardFacade().nameExists(cardName)) {
                printAndLog("The card \"" + cardName + "\" already exists.", st.getLogFacade());
            } else {
                printAndLog("The definition of the card:", st.getLogFacade());
                String definition = sc.nextLine();
                log(definition, st.getLogFacade());
                if (st.getCardFacade().definitionExists(definition)) {
                    printAndLog("The definition \"" + definition + "\" already exists.", st.getLogFacade());
                } else {
                    Card card = new Card(cardName, definition, 0);
                    st.getCardFacade().add(card);
                    printAndLog("The pair (\"" + cardName + "\":\"" + definition + "\") has been added.",
                            st.getLogFacade());
                }
            }
            System.out.println();
        });
        actions.put("remove", (sc, st) -> {
            printAndLog("The card:", st.getLogFacade());
            String cardName = sc.nextLine();
            log(cardName, st.getLogFacade());
            if (st.getCardFacade().nameExists(cardName)) {
                st.getCardFacade().remove(cardName);
                printAndLog("The card has been removed.", st.getLogFacade());
            } else {
                printAndLog("Can't remove \"" + cardName + "\": there is no such card.", st.getLogFacade());
            }
            System.out.println();
        });
        actions.put("import", (sc, st) -> {
            printAndLog("File name:", st.getLogFacade());
            String fileName = "src/main/java/hyperskill/projects/stage6/" + sc.nextLine();
            log(fileName, st.getLogFacade());
            // String fileName = sc.nextLine();
            try (Scanner scanner = new Scanner(new File(fileName))) {
                int count = 0;
                while (scanner.hasNext()) {
                    Card card = new Card(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
                    count++;
                    st.getCardFacade().add(card);
                }
                printAndLog(count + " cards have been loaded.", st.getLogFacade());
            } catch (FileNotFoundException e) {
                printAndLog("File not found.", st.getLogFacade());
            }
            System.out.println();
        });
        actions.put("export", (sc, st) -> {
            printAndLog("File name:", st.getLogFacade());
            String fileName = "src/main/java/hyperskill/projects/stage6/" + sc.nextLine();
            log(fileName, st.getLogFacade());
            // String fileName = sc.nextLine();
            try (PrintWriter writer = new PrintWriter(fileName)) {
                List<Card> allCards = st.getCardFacade().getAll();
                allCards.forEach(card -> {
                    writer.println(card.getName());
                    writer.println(card.getDefinition());
                    writer.println(card.getErrors());
                });
                printAndLog(allCards.size() + " cards have been saved.", st.getLogFacade());
            } catch (FileNotFoundException e) {
                printAndLog("File not found.", st.getLogFacade());
            }
            System.out.println();
        });
        actions.put("ask", (sc, st) -> {
            printAndLog("How many times to ask?", st.getLogFacade());
            int howManyAsk = Integer.parseInt(sc.nextLine());
            log("" + howManyAsk, st.getLogFacade());
            List<Card> allCards = st.getCardFacade().getAll();
            for (int i = 1; i <= howManyAsk; i++) {
                Random random = new Random(i);
                Card card = allCards.get(random.nextInt(allCards.size()));
                printAndLog("Print the definition of \"" + card.getName() + "\":", st.getLogFacade());
                String answer = sc.nextLine();
                log(answer, st.getLogFacade());
                if (answer.equals(card.getDefinition())) {
                    printAndLog("Correct answer.", st.getLogFacade());
                } else {
                    ifPresentOrElse(st.getCardFacade().getByDefinition(answer),
                            s -> printAndLog(
                                    "Wrong answer. The correct one is \"" + card.getDefinition()
                                            + "\", you've just written the definition of \"" + s.getName() + "\".",
                                    st.getLogFacade()),
                            () -> printAndLog("Wrong answer.The correct one is \"" + card.getDefinition() + "\".",
                                    st.getLogFacade()));
                    st.getCardFacade().enlargeErrors(card);
                }
            }
        });
        actions.put("log", (sc, st) -> {
            printAndLog("File name:", st.getLogFacade());
            String fileName = "src/main/java/hyperskill/projects/stage6/" + sc.nextLine();
            log(fileName, st.getLogFacade());
            try (PrintWriter writer = new PrintWriter(fileName)) {
                st.getLogFacade().getAll().forEach(writer::println);
                printAndLog("The log has been saved.", st.getLogFacade());
            } catch (FileNotFoundException e) {
                printAndLog("File not found.", st.getLogFacade());
            }
        });
        actions.put("hardest card", (sc, st) -> {
            List<Card> cards = st.getCardFacade().getAll();
            int max = cards.stream().map(Card::getErrors).max(Comparator.naturalOrder()).get();
            if (max == 0) {

                printAndLog("There are no cards with errors.", st.getLogFacade());
            } else {
                System.out.println("Max errors" + max);
                List<Card> maxCards = cards
                        .stream()
                        .filter(c -> c.getErrors() == max)
                        .collect(Collectors.toCollection(ArrayList::new));
                System.out.println(maxCards);
                if (maxCards.size() == 1) {
                    printAndLog("The hardest card is \"" + maxCards.get(0).getName() + "\". You have " + max
                                    + " errors answering it.",
                            st.getLogFacade());
                } else {
                    int sum = maxCards.stream().mapToInt(Card::getErrors).sum();
                    printAndLog(
                            "The hardest cards are " + maxCards.stream().map(Card::getName).collect(Collectors.joining(
                                    "\", \"",
                                    "\"", "\"")) + ". You have" +
                                    " " + sum +
                                    " " +
                                    "errors answering " +
                                    "them.",
                            st.getLogFacade());
                }
            }
        });
        actions.put("reset stats", (sc, st) -> {
        });
        Scanner scanner = new Scanner(System.in);
        boolean actionFlag = true;
        Stage6 stage = new Stage6();
        while (actionFlag) {
            printAndLog("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats)",
                    stage.getLogFacade());
            // System.out.println("add action");
            String actionName = scanner.nextLine();
            if (actionName.equals("exit")) {
                printAndLog("Bye bye!", stage.getLogFacade());
                actionFlag = false;
            } else if (actions.containsKey(actionName)) {
                actions.get(actionName).accept(scanner, stage);
            } else {
                actionFlag = false;
            }

        }
        scanner.close();
    }

    public static void printAndLog(String message, LogFacade logFacade) {
        System.out.println(message);
        logFacade.add(message);
    }

    public static void log(String message, LogFacade logFacade) {
        logFacade.add(message);
    }

    public static <T> void ifPresentOrElse(Optional<T> optional, Consumer<? super T> action, Runnable emptyAction) {
        if (optional.isPresent()) {
            action.accept(optional.get());
        } else {
            emptyAction.run();
        }
    }

}
