package hyperskill.projects.coffemachine.stage6;

import java.util.Scanner;

public class CoffeeMachine {
    private int water, milk, coffeeBeans, cubs, money;
    private Scanner scanner;
    CoffeeMachine(int water, int milk, int coffeeBeans, int cubs, int money) {
        this.scanner = new Scanner(System.in);
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cubs = cubs;
        this.money = money;
    }
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
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


}
