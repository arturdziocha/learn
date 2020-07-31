package hyperskill.patterns.factoryMethod;

import java.util.Scanner;

/*
 * A lovely idea befalls you: you decide to automate the production of motors.

You have 4 types of motors: electric, hydraulic, pneumatic and warp drive.

You must implement MotorFactory and specified classes of motors.

Please, do not change the provided code of the motor classes.

Sample Input 1:

E
R-45
1000
Sample Output 1:

Electric motor={model:R-45,power:1000}
 */
public class MotorTest {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);
        final String model = scanner.next();
        final long power = scanner.nextLong();
        Motor motor = MotorFactory.make(type, model, power);
        scanner.close();
        System.out.println(motor);

    }

}

abstract class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {

    public PneumaticMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {

        return "Pneumatic " + super.toString();
    }
}

class HydraulicMotor extends Motor {

    public HydraulicMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Hydraulic " + super.toString();
    }

}

class ElectricMotor extends Motor {

    public ElectricMotor(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "Electric " + super.toString();
    }

}

class WarpDrive extends Motor {

    public WarpDrive(String model, long power) {
        super(model, power);
    }

    @Override
    public String toString() {
        return "WarpDrive " + super.toString();
    }
}

class MotorFactory {
    /**
     * It returns an initialized motor according to the specified type by the
     * first character: 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or
     * 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        Motor motor = null;
        switch (Character.toLowerCase(type)) {
            case 'p':
                motor = new PneumaticMotor(model, power);
                break;
            case 'h':
                motor = new HydraulicMotor(model, power);
                break;
            case 'e':
                motor = new ElectricMotor(model, power);
                break;
            case 'w':
                motor = new WarpDrive(model, power);
                break;
            default:
                break;
        }
        return motor;
    }
}
