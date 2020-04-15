package hyperskill.patterns.factoryMethod;
/*
 * In this task, you'll be asked to write almost a full working code by yourself. However, you can find some tips in the correct output and in parts of the code.

Let's create the BurgerStore. We will stick to the good old classic and simply create a burger with Bun, Cutlet and Sauce. Do not forget that FactoryMethod does not include details, it only knows the general creation process. 

Sample Input 1:

Sample Output 1:

Making a Chinese Burger
Putting bun
Putting cutlet
Putting sauce
Done a Chinese Burger

Making a American Burger
Putting bun
Putting cutlet
Putting sauce
Done a American Burger

Making a Russian Burger
Putting bun
Putting cutlet
Putting sauce
Done a Russian Burger
 */
public class BurgerTest {
    public static void main(String[] args) throws InterruptedException {
        BurgerFactory burgerFactory = new BurgerStore();
        Burger chinese = burgerFactory.orderBurger("ch");
        Burger american = burgerFactory.orderBurger("a");
        Burger russian = burgerFactory.orderBurger("r");
    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are not able to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println("Done a " + burger.getName() + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "ch":
                return new ChineseBurger("Chinese Burger");
            case "a":
                return new AmericanBurger("American Burger");
            case "r":
                return new RussianBurger("Russian Burger");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting cutlet");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    ChineseBurger(String name) {
        super(name);
    }

}

class AmericanBurger extends Burger {
    AmericanBurger(String name) {
        super(name);
    }

}

class RussianBurger extends Burger {
    RussianBurger(String name) {
        super(name);
    }

}