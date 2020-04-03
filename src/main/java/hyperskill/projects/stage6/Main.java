package hyperskill.projects.stage6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
Wrong answer. (The correct one is "Moscannerow", you've just written the definition of "France" card.)

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
public class Main {

    private final CardFacade cardFacade;
    private final LogFacade logFacade;

    public Main() {
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

        Map<String, BiConsumer<Scanner, Main>> actions = new LinkedHashMap<>();
        actions.put("add", Main::add);
        actions.put("remove", Main::remove);
        actions.put("import", Main::im);
        actions.put("export", Main::export);
        actions.put("ask", Main::ask);
        actions.put("log", Main::log);
        actions.put("hardest card", Main::hardestCard);
        actions.put("reset stats", Main::resetStats);
        Scanner scanner = new Scanner(System.in);
        boolean actionFlag = true;
        Main stage = new Main();
        while (actionFlag) {
            printAndLog("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats)",
                    stage.getLogFacade());
            // System.out.println("add action");
            String actionName = scanner.nextLine();
            log(actionName, stage.getLogFacade());
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

    private static void add(Scanner scanner, Main main) {
        printAndLog("The card:", main.getLogFacade());

        String cardName = scanner.nextLine();
        log(cardName, main.getLogFacade());
        if (main.getCardFacade().nameExists(cardName)) {
            printAndLog("The card \"" + cardName + "\" already exists.", main.getLogFacade());
        } else {
            printAndLog("The definition of the card:", main.getLogFacade());
            String definition = scanner.nextLine();
            log(definition, main.getLogFacade());
            if (main.getCardFacade().definitionExists(definition)) {
                printAndLog("The definition \"" + definition + "\" already exists.", main.getLogFacade());
            } else {
                Card card = new Card(cardName, definition, 0);
                main.getCardFacade().add(card);
                printAndLog("The pair (\"" + cardName + "\":\"" + definition + "\") has been added.",
                        main.getLogFacade());
            }
        }
        System.out.println();
    }

    private static void im(Scanner scanner, Main main) {
        printAndLog("File name:", main.getLogFacade());
        //String fileName = "src/main/java/hyperskill/projects/stage6/" + scanner.nextLine();
        String fileName = scanner.nextLine();
        log(fileName, main.getLogFacade());
        try (Scanner sc = new Scanner(new File(fileName))) {
            int count = 0;
            while (sc.hasNext()) {
                Card card = new Card(sc.nextLine(), sc.nextLine(),
                        Integer.parseInt(sc.nextLine()));
                count++;
                main.getCardFacade().add(card);
            }
            printAndLog(count + " cards have been loaded.", main.getLogFacade());
        } catch (FileNotFoundException e) {
            printAndLog("File not found.", main.getLogFacade());
        }
        System.out.println();
    }

    private static void export(Scanner scanner, Main main) {
        printAndLog("File name:", main.getLogFacade());
        //String fileName = "src/main/java/hyperskill/projects/stage6/" + scanner.nextLine();
        String fileName = scanner.nextLine();
        log(fileName, main.getLogFacade());
        try (PrintWriter writer = new PrintWriter(fileName)) {
            List<Card> allCards = main.getCardFacade().getAll();
            allCards.forEach(card -> {
                writer.println(card.getName());
                writer.println(card.getDefinition());
                writer.println(card.getErrors());
            });
            printAndLog(allCards.size() + " cards have been saved.", main.getLogFacade());
        } catch (FileNotFoundException e) {
            printAndLog("File not found.", main.getLogFacade());
        }
        System.out.println();
    }

    private static void remove(Scanner scanner, Main main) {
        printAndLog("The card:", main.getLogFacade());
        String cardName = scanner.nextLine();
        log(cardName, main.getLogFacade());
        if (main.getCardFacade().nameExists(cardName)) {
            main.getCardFacade().remove(cardName);
            printAndLog("The card has been removed.", main.getLogFacade());
        } else {
            printAndLog("Can't remove \"" + cardName + "\": there is no such card.", main.getLogFacade());
        }
        System.out.println();
    }

    private static void ask(Scanner scanner, Main main) {
        printAndLog("How many times to ask?", main.getLogFacade());
        int howManyAsk = Integer.parseInt(scanner.nextLine());
        log("" + howManyAsk, main.getLogFacade());
        List<Card> allCards = main.getCardFacade().getAll();
        for (int i = 1; i <= howManyAsk; i++) {
            Random random = new Random(i);
            Card card = allCards.get(random.nextInt(allCards.size()));
            printAndLog("Print the definition of \"" + card.getName() + "\":", main.getLogFacade());
            String answer = scanner.nextLine();
            log(answer, main.getLogFacade());
            if (answer.equals(card.getDefinition())) {
                printAndLog("Correct answer.", main.getLogFacade());
            } else {
                ifPresentOrElse(main.getCardFacade().getByDefinition(answer),
                        s -> printAndLog(
                                "Wrong answer. The correct one is \"" + card.getDefinition()
                                        + "\", you've just written the definition of \"" + s.getName() + "\".",
                                main.getLogFacade()),
                        () -> printAndLog("Wrong answer.The correct one is \"" + card.getDefinition() + "\".",
                                main.getLogFacade()));
                main.getCardFacade().enlargeErrors(card);
            }
        }
        System.out.println();
    }

    private static void log(Scanner scanner, Main main) {
        printAndLog("File name:", main.getLogFacade());
        //String fileName = "src/main/java/hyperskill/projects/stage6/" + scanner.nextLine();
        String fileName = scanner.nextLine();
        log(fileName, main.getLogFacade());
        try (PrintWriter writer = new PrintWriter(fileName)) {
            main.getLogFacade().getAll().forEach(writer::println);
            printAndLog("The log has been saved.", main.getLogFacade());
        } catch (FileNotFoundException e) {
            printAndLog("File not found.", main.getLogFacade());
        }
        System.out.println();
    }

    private static void hardestCard(Scanner scanner, Main main) {
        List<Card> cards = main.getCardFacade().getAll();
        Optional<Integer> max = cards.stream().map(Card::getErrors).max(Comparator.naturalOrder());
        ifPresentOrElse(max, m -> {
            if (m == 0) {
                printAndLog("There are no cards with errors.", main.getLogFacade());
            } else {
                List<Card> maxCards = cards
                        .stream()
                        .filter(c -> c.getErrors() == m)
                        .collect(Collectors.toCollection(ArrayList::new));
                if (maxCards.size() == 1) {
                    printAndLog("The hardest card is \"" + maxCards.get(0).getName() + "\". You have " + m
                                    + " errors answering it.",
                            main.getLogFacade());
                } else {
                    int sum = maxCards.stream().mapToInt(Card::getErrors).sum();
                    printAndLog("The hardest cards are "
                                    + maxCards.stream().map(Card::getName).collect(Collectors.joining("\", \"", "\"", "\""))
                                    + ". You have" + " " + sum + " " + "errors answering " + "them.",
                            main.getLogFacade());
                }
            }
        }, () -> printAndLog("There are no cards with errors.", main.getLogFacade()));

        System.out.println();
    }

    private static void resetStats(Scanner scanner, Main main) {
        main.getCardFacade().resetStats();
        printAndLog("Card statistics has been reset.", main.getLogFacade());
        System.out.println();
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

class Card {
    private final String name;
    private final String definition;
    private int errors;

    Card(String name, String definition, Integer errors) {
        this.name = name;
        this.definition = definition;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public int getErrors() {
        return errors;
    }

    public void enlargeErrors() {
        this.errors += 1;
    }

    public void eraseErrors() {
        this.errors = 0;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getDefinition() + " - " + this.getErrors();
    }
}

class CardFacade {
    private final CardGateway cardGateway;

    public CardFacade() {
        this.cardGateway = new CardGateway();
    }

    boolean nameExists(String name) {
        return cardGateway.nameExists(name);
    }

    boolean definitionExists(String definition) {
        return cardGateway.definitionExists(definition);
    }

    void add(Card card) {
        cardGateway.add(card);
    }

    void enlargeErrors(Card card) {
        cardGateway.enlargeErrors(card);
    }

    void remove(String name) {
        cardGateway.remove(name);
    }

    void resetStats() {
        cardGateway.eraseErrors();
    }

    List<Card> getAll() {
        return cardGateway.getAll();
    }

    Optional<Card> getByName(String name) {
        return cardGateway.get(name);
    }

    Optional<Card> getByDefinition(String definition) {
        return cardGateway.getByDefinition(definition);
    }

    int size() {
        return cardGateway.size();
    }
}

class CardGateway {
    private List<Card> cards;

    public CardGateway() {
        this.cards = new ArrayList<>();
    }

    boolean nameExists(String name) {
        return cards.stream().anyMatch(c -> c.getName().equals(name));
    }

    boolean definitionExists(String definition) {
        return cards.stream().anyMatch(c -> c.getDefinition().equals(definition));
    }

    void add(Card card) {
        boolean nameExists = nameExists(card.getName());
        boolean definitionExists = definitionExists(card.getDefinition());
        if (nameExists || definitionExists) {
            int index = findIndex(card);
            this.cards.set(index, card);

        } else {
            this.cards.add(card);
        }
    }

    void enlargeErrors(Card card) {
        int index = findIndex(card);
        card.enlargeErrors();
        this.cards.set(index, card);
    }

    void eraseErrors() {
        this.cards = cards
                .stream()
                .map(card -> card = new Card(card.getName(), card.getDefinition(), 0))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    void remove(String name) {
        this.cards.removeIf(c -> c.getName().equals(name));
    }

    List<Card> getAll() {
        return cards;
    }

    Optional<Card> get(String name) {
        return this.cards.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    public Optional<Card> getByDefinition(String definition) {
        return this.cards.stream().filter(c -> c.getDefinition().equals(definition)).findFirst();
    }

    int size() {
        return this.cards.size();
    }

    private int findIndex(Card card) {
        return IntStream
                .range(0, cards.size())
                .filter(i -> cards.get(i).getName().equals(card.getName()))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }

}

class LogFacade {
    private final LogGateway logGateway;

    public LogFacade() {
        this.logGateway = new LogGateway();
    }

    void add(String log) {
        logGateway.add(log);
    }

    List<String> getAll() {
        return logGateway.getAll();
    }
}

class LogGateway {
    private List<String> logs;

    public LogGateway() {
        this.logs = new ArrayList<>();
    }

    void add(String log) {
        this.logs.add(log);
    }

    List<String> getAll() {
        return logs;
    }
}