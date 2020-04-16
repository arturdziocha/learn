package hyperskill.projects.coffemachine;

import java.util.Scanner;

/*
Let's simulate an actual coffee machine. It has a limited supply of water, milk, coffee beans, and disposable cups. Also, it counts how much money it gets for selling coffee. The coffee machine has several options: first, it needs to be able to sell coffee. It can make different varieties of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, except that all of them requires only one disposable cup. Second, the coffee machine should be able to get replenished by a special worker. Third, another special worker should be able to take money from the coffee machine.

Write the program that can do one of these actions at a time. It reads one line from standard input, which can be "buy", "fill", "take". If you want to buy some coffee, input "buy". If you are a special worker and you think that it is time to fill out all the supplies for the coffee machine, input "fill". If you are another special worker and it is time to take the money from the coffee machine, input "take".

If the user writes "buy" then he must choose one of three varieties of coffee that the coffee machine can make: espresso, latte, or cappuccino.

For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
If the user writes "fill", the program should ask him how much water, milk, coffee beans and how many disposable cups he wants to add into the coffee machine.

If the user writes "take" the program should give him all the money that it earned from selling coffee.

At the moment, the coffee machine has $550, 1200 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

Write the program that prints the coffee machine’s state, processes one query from the user, and also prints the coffee machine’s state after that. Try to use methods to implement every action that the coffee machine can do.

Instruction
Write a program that offers to buy one cup of coffee or to fill the ingredients or to take it's money. At the same time, the program should calculate how many ingredients it has left. And also display the number of ingredients before and after purchase.

Examples

An espresso should be as number 1 in the list, a latte as number 2 and a cappuccino as number 3.
Options also should be named as "buy", "fill", "take".
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1

The coffee machine has:
1200 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take):
> buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
> 3

The coffee machine has:
1000 of water
440 of milk
108 of coffee beans
8 of disposable cups
556 of money
Example 2

The coffee machine has:
1200 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take):
> fill
Write how many ml of water do you want to add:
> 2000
Write how many ml of milk do you want to add:
> 500
Write how many grams of coffee beans do you want to add:
> 100
Write how many disposable cups of coffee do you want to add:
> 10

The coffee machine has:
3200 of water
1040 of milk
220 of coffee beans
19 of disposable cups
550 of money
Example 3

The coffee machine has:
1200 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money

Write action (buy, fill, take):
> take
I gave you $550

The coffee machine has:
1200 of water
540 of milk
120 of coffee beans
9 of disposable cups
0 of money
 */
public class Stage4 {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(1200, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        printMachineStatus(machine);
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                buyAction(machine, scanner);
                break;
            case "fill":
                fillAction(machine, scanner);
                break;
            case "take":
                takeAction(machine, scanner);
                break;
        }
        System.out.println();
        printMachineStatus(machine);

    }

    private static void printMachineStatus(CoffeeMachine machine) {
        System.out.println("The coffee machine has:\n" +
                machine.getWater() + " of water\n" +
                machine.getMilk() + " of milk\n" +
                machine.getCoffeeBeans() + " of coffee beans\n" +
                machine.getCubs() + " of disposable cups\n" +
                machine.getMoney() + " of money");
    }

    private static void buyAction(CoffeeMachine machine, Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeChoice = Integer.parseInt(scanner.nextLine());
        Coffee coffee = CoffeeChoseFactory.choseCoffee(coffeeChoice);
        machine.makeCoffee(coffee);
    }

    private static void takeAction(CoffeeMachine machine, Scanner scanner) {
        int take = machine.takeMoney();
        System.out.println("I gave you $" + take);
    }

    private static void fillAction(CoffeeMachine machine, Scanner scanner) {
        System.out.println("Write how many ml of water do you want to add: ");
        machine.addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        machine.addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        machine.addCoffeeBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        machine.addCubs(scanner.nextInt());
    }
}

class CoffeeMachine {
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

    public void makeCoffee(Coffee coffee) {
        this.water -= coffee.getWaterForCub();
        this.milk -= coffee.getMilkForCub();
        this.coffeeBeans -= coffee.getBeansForCub();
        this.cubs--;
        this.money += coffee.getCost();
    }
}

class CoffeeChoseFactory {
    public static Coffee choseCoffee(int choose) {
        switch (choose) {
            case 1:
                return new Expresso(250, 16, 4);
            case 2:
                return new Latte(350, 75, 20, 7);
            case 3:
                return new Cappuccino(200, 100, 12, 6);
            default:
                return null;
        }
    }
}

abstract class Coffee {
    protected int milkForCub;
    protected int waterForCub;
    protected int beansForCub;
    protected int cost;

    Coffee(int waterForCub, int milkForCub, int beansForCub, int cost) {
        this.waterForCub = waterForCub;
        this.milkForCub = milkForCub;
        this.beansForCub = beansForCub;
        this.cost = cost;
    }

    public int getWaterForCub() {
        return waterForCub;
    }

    public int getMilkForCub() {
        return milkForCub;
    }

    public int getBeansForCub() {
        return beansForCub;
    }

    public int getCost() {
        return cost;
    }
}

class Expresso extends Coffee {
    Expresso(int waterForCub, int beansForCub, int cost) {
        super(waterForCub, 0, beansForCub, cost);
    }
}

class Latte extends Coffee {
    Latte(int waterForCub, int milkForCub, int beansForCub, int cost) {
        super(waterForCub, milkForCub, beansForCub, cost);
    }
}

class Cappuccino extends Coffee {
    Cappuccino(int waterForCub, int milkForCub, int beansForCub, int cost) {
        super(waterForCub, milkForCub, beansForCub, cost);
    }
}