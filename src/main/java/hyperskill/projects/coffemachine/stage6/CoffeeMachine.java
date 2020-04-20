package hyperskill.projects.coffemachine.stage6;

import java.util.Scanner;

public class CoffeeMachine {
    private int water, milk, coffeeBeans, cubs, money;
    private Scanner scanner;

    CoffeeMachine(int water, int milk, int coffeeBeans, int cubs, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cubs = cubs;
        this.money = money;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        boolean status;
        do {
            status = machine.process();
        } while (status);
    }

    public boolean process() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        switch (action) {
            case "remaining":
                printStatus();
                break;
            case "buy":
                buyAction();
                break;
            case "exit":
                return false;
            case "fill":
                fillAction();
                break;
        }
        return true;
    }

    private void printStatus() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cubs + " of disposable cups\n" +
                money + " of money");
    }

    private void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String type = scanner.nextLine();
        if ("back".equals(type)) {
            return;
        }

        CoffeeType coffeeType = choseCoffee(Integer.parseInt(type));
        if (water < coffeeType.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < coffeeType.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < coffeeType.getBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cubs < 1) {
            System.out.println("not enought cubs");
        } else {
            buy(coffeeType);
        }
    }

    private void buy(CoffeeType type) {
        this.water -= type.getWater();
        this.milk -= type.getMilk();
        this.coffeeBeans -= type.getBeans();
        this.cubs--;
        this.money += type.getCost();
    }

    private CoffeeType choseCoffee(int choose) {
        switch (choose) {
            case 1:
                return CoffeeType.Espresso;
            case 2:
                return CoffeeType.Latte;
            case 3:
                return CoffeeType.Cappuccino;
            default:
                return null;
        }
    }

    private enum CoffeeType {
        Espresso(250, 0, 16, 4),
        Latte(350, 75, 20, 7), Cappuccino(200, 100, 12, 6);
        private final int milk;
        private final int water;
        private final int beans;
        private final int cost;

        CoffeeType(int water, int milk, int beans, int cost) {
            this.milk = milk;
            this.water = water;
            this.beans = beans;
            this.cost = cost;
        }

        public int getMilk() {
            return milk;
        }

        public int getWater() {
            return water;
        }

        public int getBeans() {
            return beans;
        }

        public int getCost() {
            return cost;
        }
    }

    private void fillAction() {
        System.out.println("Write how many ml of water do you want to add: ");
        this.water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add: ");
        this.milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        this.coffeeBeans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        this.cubs += Integer.parseInt(scanner.nextLine());
    }

    void takeAction() {
        int take = takeMoney();
        System.out.println("I gave you $" + take);
    }

    public int takeMoney() {
        int temp = this.money;
        this.money = 0;
        return temp;
    }
}
