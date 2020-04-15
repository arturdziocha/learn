package hyperskill.patterns.factoryMethod;

import java.util.Scanner;

/*
 * The given classes are components of the Factory Method pattern.

Robot is the product and RobotCleaner is the concrete product.

Implement a factory method in RobotFactory methods to create RobotCleaner.

Please, do not change the provided code of the classes.

Let's expand our  RobotFactory! We've added a new Robot type — the Guardian. 

Provide the RobotGuardian class and implement a factory method in RobotFactory methods to create Robotinstances.

Please, do not change the provided code of the classes.

Sample Input 1:

TYU11
O13L3
Sample Output 1:

cleaner-robot: {
    name : TYU11
    description : Robot will clean my room and dry my socks
    power : 100
}
guardian-robot: {
    name : O13L3
    description : Knight will secure my daughter while she sleeping
    power : 200
}

 */
public class RobotTest {
    public static void main(String[] args) {

        RobotFactory robotFactory = new RobotFactory();
        Scanner scanner = new Scanner(System.in);

        String nameCleaner = scanner.nextLine();
        Robot robotCleaner = robotFactory
                .getRobot(RobotType.ROBOT_CLEANER, nameCleaner, "Robot will clean my room and dry my socks", 100);

        String nameGuardian = scanner.nextLine();
        Robot robotGuardian = robotFactory
                .getRobot(RobotType.ROBOT_GUARDIAN, nameGuardian, "Knight will secure my daughter while she sleeping",
                    200);

        System.out.println(robotCleaner);
        System.out.println(robotGuardian);

        scanner.close();
    }
}

abstract class Robot {

    public abstract String getName();

    public abstract String getDescription();

    public abstract int getPower();

    @Override
    public String toString() {
        return "robot: {\n\t" + "name : " + getName() + "\n\t" + "description : " + getDescription() + "\n\t"
                + "power : " + getPower() + "\n}";
    }
}

/** Type of product - Robot Type */
enum RobotType {
    ROBOT_CLEANER,
    ROBOT_GUARDIAN
}

/** Concrete Product - Robot Cleaner */
class RobotCleaner extends Robot {

    private String name;
    private String description;
    private int power;

    public RobotCleaner(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "cleaner-" + super.toString();
    }

}

class RobotGuardian extends Robot {
    private String name;
    private String description;
    private int power;

    public RobotGuardian(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "guardian-" + super.toString();
    }
}

/** Factory */
class RobotFactory {

    /** Factory Method **/
    public Robot getRobot(RobotType type, String name, String description, int power) {
        return type.equals(RobotType.ROBOT_CLEANER) ? new RobotCleaner(name, description, power)
                : new RobotGuardian(name, description, power);
    }
}