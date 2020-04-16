package hyperskill.projects.coffemachine;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        System.out.println("add");
        CoffeMachine coffeMachine = new CoffeMachine(scanner.nextInt());
        System.out.println(coffeMachine);
        scanner.close();
    }
}

class CoffeMachine {
    private final int cubs;
    private final int water = 200;
    private final int milk = 50;
    private final int coffeBeans = 15;

    public CoffeMachine(int cubs) {
        this.cubs = cubs;
    }

    @Override
    public String toString() {
        return "For " + cubs + " cups of coffee you will need:\r\n" + (cubs * water) + " ml of water\r\n"
                + (cubs * milk) + " ml of milk\r\n" + coffeBeans * cubs + " g of coffee beans";
    }
}