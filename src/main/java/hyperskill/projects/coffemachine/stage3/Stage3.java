package hyperskill.projects.coffemachine.stage3;

import java.util.Scanner;

/*
 * A real coffee machine never has an infinite supply of water, milk, or coffee beans. And if you input a really big number, it’s almost certain that a real coffee machine wouldn't have the supplies needed to make all that coffee.

In this stage, you need to improve the previous program. Now you need to input amounts of water, milk, and coffee beans that your coffee machine has at the moment.

If the coffee machine has enough supplies to make the specified amount of coffee, the program should print "Yes, I can make that amount of coffee". If the coffee machine can make more than that, the program should output "Yes, I can make that amount of coffee (and even N more than that)", where N is the number of additional cups of coffee that the coffee machine can make. If the amount of resources is not enough to make the specified amount of coffee, the program should output "No, I can make only N cup(s) of coffee".

Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.

Instruction

Write a program that calculates whether it will be able to make the required amount of coffee from the specified amount of ingredients.

Examples

The program should firstly request for water, then milk, then beans, then amount of cups.
The symbol > represents the user input. Notice that it's not the part of the input.

Example 1

Write how many ml of water the coffee machine has: 
> 300
Write how many ml of milk the coffee machine has: 
> 65
Write how many grams of coffee beans the coffee machine has: 
> 100
Write how many cups of coffee you will need: 
> 1
Yes, I can make that amount of coffee
Example 2 

Write how many ml of water the coffee machine has: 
> 500
Write how many ml of milk the coffee machine has: 
> 250
Write how many grams of coffee beans the coffee machine has: 
> 200
Write how many cups of coffee you will need: 
> 10
No, I can make only 2 cup(s) of coffee
Example 3 

Write how many ml of water the coffee machine has: 
> 1550
Write how many ml of milk the coffee machine has: 
> 299
Write how many grams of coffee beans the coffee machine has: 
> 300
Write how many cups of coffee you will need: 
> 3
Yes, I can make that amount of coffee (and even 2 more than that)
Example 4

Write how many ml of water the coffee machine has: 
> 0
Write how many ml of milk the coffee machine has: 
> 0
Write how many grams of coffee beans the coffee machine has: 
> 0
Write how many cups of coffee you will need: 
> 1
No, I can make only 0 cup(s) of coffee
Example 5

Write how many ml of water the coffee machine has: 
> 0
Write how many ml of milk the coffee machine has: 
> 0
Write how many grams of coffee beans the coffee machine has: 
> 0
Write how many cups of coffee you will need: 
> 0
Yes, I can make that amount of coffee
Example 6

Write how many ml of water the coffee machine has: 
> 200
Write how many ml of milk the coffee machine has: 
> 50
Write how many grams of coffee beans the coffee machine has: 
> 15
Write how many cups of coffee you will need: 
> 0
Yes, I can make that amount of coffee (and even 1 more than that)
 */
public class Stage3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cubs = scanner.nextInt();

        CoffeMachine3 coffeMachine3 = new CoffeMachine3(water, milk, coffeBeans);
        int howManyCanMake = 0;
        while (coffeMachine3.canMakeCofee()) {
            coffeMachine3.makeCofee();
            howManyCanMake += 1;
        }

        int par = howManyCanMake - cubs;
        if (par == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (par < 0) {
            System.out.println("No, I can make only " + howManyCanMake + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + par + " more than that)");
        }
        scanner.close();
    }
}

class CoffeMachine3 {
    private static int waterPerCub = 200;
    private static int milkPerCub = 50;
    private static int coffeBeansPerCub = 15;
    private int water, milk, coffeBeans;

    CoffeMachine3(int water, int milk, int coffeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeBeans = coffeBeans;
    }

    public boolean canMakeCofee() {
        return water - waterPerCub >= 0 && milk - milkPerCub >= 0 && coffeBeans - coffeBeansPerCub >= 0;
    }

    public void makeCofee() {
        this.water -= waterPerCub;
        this.milk -= milkPerCub;
        this.coffeBeans -= coffeBeansPerCub;
    }
}