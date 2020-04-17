package hyperskill.projects.coffemachine.stage5;

import java.util.Scanner;

/*
Description
But just one action isn’t interesting. Let's improve the program so it can do multiple actions, one after another. The program should repeatedly ask what the user wants to do. If the user types "buy", "fill" or "take", then just do what the program did in the previous step. However, if the user wants to switch off the coffee machine, he should type "exit". Then the program should terminate. Also, when the user types "remaining", the program should output all the resources that the coffee machine has.

Also, do not forget that you can be out of resources for making coffee. If the coffee machine doesn’t have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee.

And the last improvement to the program at this step—if the user types "buy" to buy a cup of coffee and then changes his mind, he should be able to type "back" to return into the main cycle.

Remember, that:

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
Instruction
Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given.

Example
Your coffee machine should have the same initial resources as in the example (400 ml of water, 540 ml of milk, 120 g of coffee beans, 9 disposable cups, $550 in cash).
The symbol > represents the user input. Notice that it's not the part of the input.

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
$550 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
50 of water
465 of milk
100 of coffee beans
8 of disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
Sorry, not enough water!

Write action (buy, fill, take, remaining, exit):
> fill

Write how many ml of water do you want to add:
> 1000
Write how many ml of milk do you want to add:
> 0
Write how many grams of coffee beans do you want to add:
> 0
Write how many disposable cups of coffee do you want to add:
> 0

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
1050 of water
465 of milk
100 of coffee beans
8 of disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
700 of water
390 of milk
80 of coffee beans
7 of disposable cups
$564 of money

Write action (buy, fill, take, remaining, exit):
> take

I gave you $564

Write action (buy, fill, take, remaining, exit):
> remaining

The coffee machine has:
700 of water
390 of milk
80 of coffee beans
7 of disposable cups
0 of money

Write action (buy, fill, take, remaining, exit):
> exit
 */
public class CoffeeMachine {
    private int water, milk, coffeeBeans, cubs, money;

    CoffeeMachine(int water, int milk, int coffeeBeans, int cubs, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cubs = cubs;
        this.money = money;
    }

    void addWater(int water) {
        this.water += water;
    }

    void addMilk(int milk) {
        this.milk += milk;
    }

    void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    void addCubs(int cubs) {
        this.cubs += cubs;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCubs() {
        return cubs;
    }

    public int getMoney() {
        return money;
    }

    public int takeMoney() {
        int temp = this.money;
        this.money = 0;
        return temp;
    }

    public void makeCoffee(CoffeeType coffee) {
        this.water -= coffee.getWater();
        this.milk -= coffee.getMilk();
        this.coffeeBeans -= coffee.getBeans();
        this.cubs--;
        this.money += coffee.getCost();
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cubs + " of disposable cups\n" +
                money + " of money";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Actions actions = new Actions(machine, scanner);
        boolean actionFlag = true;
        while (actionFlag) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            if ("exit".equals(action)) {
                actionFlag = false;
            } else {
                switch (action) {
                    case "remaining":
                        actions.printMachineStatus();
                        break;
                    case "buy":
                        actions.buyAction();
                        break;
                    case "fill":
                        actions.fillAction();
                        break;
                    case "take":
                        actions.takeAction();
                        break;
                }

            }
        }
    }
}

class Actions {
    private final CoffeeMachine machine;
    private final Scanner scanner;

    Actions(CoffeeMachine machine, Scanner scanner) {
        this.machine = machine;
        this.scanner = scanner;
    }

    void printMachineStatus() {
        System.out.println();
        System.out.println(machine);
        System.out.println();
    }


    void buyAction() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.nextLine();
        if ("back".equals(choice)) {
            return;
        }
        int coffeeChoice = Integer.parseInt(choice);
        CoffeeType coffee = CoffeeChoseFactory.choseCoffee(coffeeChoice);
        CoffeeMachineChecker checker = new CoffeeMachineChecker();
        if (checker.canMakeCoffee(machine, coffee)) {
            machine.makeCoffee(coffee);
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println(checker.makeCoffeeChecker(machine, coffee));
        }
        System.out.println();
    }

    void fillAction() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        machine.addWater(Integer.parseInt(scanner.nextLine()));
        System.out.println("Write how many ml of milk do you want to add: ");
        machine.addMilk(Integer.parseInt(scanner.nextLine()));
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        machine.addCoffeeBeans(Integer.parseInt(scanner.nextLine()));
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        machine.addCubs(Integer.parseInt(scanner.nextLine()));
        System.out.println();
    }

    void takeAction() {
        System.out.println();
        int take = machine.takeMoney();
        System.out.println("I gave you $" + take);
        System.out.println();
    }
}

class CoffeeMachineChecker {
    boolean canMakeCoffee(CoffeeMachine machine, CoffeeType coffeeType) {
        return machine.getWater() - coffeeType.getWater() >= 0 && machine.getMilk() - coffeeType.getMilk() >= 0 && machine.getCoffeeBeans() - coffeeType.getBeans() >= 0;
    }

    String makeCoffeeChecker(CoffeeMachine machine, CoffeeType coffeeType) {
        if (machine.getWater() - coffeeType.getWater() < 0) {
            return "Sorry, not enough water!";
        } else if (machine.getMilk() - coffeeType.getMilk() < 0) {
            return "Sorry, not enough milk!";
        } else {
            return "Sorry, not enough coffee beans!";
        }
    }
}

class CoffeeChoseFactory {
    public static CoffeeType choseCoffee(int choose) {
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
}

enum CoffeeType {
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