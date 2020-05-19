package hyperskill.patterns.command.broker;

import java.util.Scanner;

public class ForexBroker {
    public static void main(String[] args) {
        Command buyCommand;
        Command sellCommand;
        int[] amountList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            amountList[i] = scanner.nextInt();
        }
        scanner.close();
        Broker broker = new Broker();
        for (int i = 0; i < 3; i++) {
            Option option = new Option(amountList[i]);
            if (amountList[i] > 0) {
                buyCommand = new BuyCommand(option);
                broker.setCommand(buyCommand);
                broker.executeCommand();
            } else {
                sellCommand = new SellCommand(option);
                broker.setCommand(sellCommand);
                broker.executeCommand();
            }
        }
    }
}

class Option {
    private int amount;

    Option(int amount) {
        this.amount = amount;
    }

    void buy() {
        System.out.println(amount + " was bought");
    }

    void sell() {
        System.out.println(amount + " was sold");
    }
}

interface Command {
    void execute();
}

class BuyCommand implements Command {
    private Option option;

    BuyCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.buy();

    }

    /* write your code here */
}

class SellCommand implements Command {
    private Option option;

    SellCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.sell();

    }
}

class Broker {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}