package hyperskill.patterns.template;

import java.util.Scanner;
/*
 * Now, we'll add a new concrete class Sandwich

Sandwich is different from Steak, so that's why you need to implement it.

The first line of the standard input is the concrete meal.

You must output the meal procedure.

Please do not change the provided code of the classes.

Sample Input 1:

Sandwich
Sample Output 1:

Ingredients: bacon, white bread, egg, cheese, mayonnaise, tomato
Paste ingredients between bread slices. Toast sandwich
That's good
Lick fingers and go to sleep
 */
public class IngredientsTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String order = scanner.nextLine();
        scanner.close();
        Meal meal = null;
        if ("Sandwich".equals(order)) {
            meal = new Sandwich();
            meal.doMeal();
        } else if ("Steak".equals(order)) {
            meal = new Steak();
            meal.doMeal();
        } else {
            System.out.println("Error");
        }
    }
}

abstract class Meal {

    /**
     * It provides template method of meal routine.
     */
    public void doMeal() {
        prepareIngredients();
        cook();
        eat();
        cleanUp();
    }

    public abstract void prepareIngredients();

    public abstract void cook();

    public void eat() {
        System.out.println("That's good");
    }

    public abstract void cleanUp();
}

class Steak extends Meal {

    @Override
    public void prepareIngredients() {
        System.out.println("Ingredients: beef steak, lemon, olive oil, salt, sugar");
    }

    @Override
    public void cook() {
        System.out.println("Fry the steak in the pan");
    }

    @Override
    public void cleanUp() {
        System.out.println("Push dishes in the sink and go coding");
    }
}
class Sandwich extends Meal {

    @Override
    public void prepareIngredients() {
        System.out.println("Ingredients: bacon, white bread, egg, cheese, mayonnaise, tomato");
        
    }

    @Override
    public void cook() {
        System.out.println("Paste ingredients between bread slices. Toast sandwich");
        
    }

    @Override
    public void cleanUp() {
        System.out.println("Lick fingers and go to sleep");
        
    }
}