package hyperskill.switc;

import java.util.Scanner;

/*
 * Residents of the country of Malevia often experiment with the plan of their rooms. Rooms can be triangular, rectangular, and round.
 



 

To quickly calculate the floorage it is required to write a program that gets the type of the room shape and the relevant parameters as input. The program should output the area of the resulting room.

The value of 3.14 is used instead of the number π in Malevia.

Hint: Math library may help you to solve this task.

Input format used by the Malevians:

triangle
a
b
c
where a, b and c — lengths of the triangle sides.

rectangle
a
b
where a and b — lengths of the rectangle sides.

circle
r
where r — circle radius.

Note, the input values (a, b, c, r) are doubles and your answer should be, too.

Sample Input 1:

rectangle
4
10
Sample Output 1:

40.0
Sample Input 2:

circle
5
Sample Output 2:

78.5
Sample Input 3:

triangle
3
4
5
Sample Output 3:

6.0
 */
public class RoomSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String room = scanner.nextLine();
        Shape shape = null;
        switch (room) {
            case "triangle":
                shape = new Triangle(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()),
                        Double.parseDouble(scanner.nextLine()));
                break;
            case "rectangle":
                shape = new Rectangle(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
                break;
            case "circle":
                shape = new Circle(Double.parseDouble(scanner.nextLine()));
                break;
        }
        System.out.println(shape.getArea());
        scanner.close();

    }
}

abstract class Shape {

    abstract double getArea();
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return 3.14 * Math.pow(radius, 2);
    }
}

class Triangle extends Shape {
    private final double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        double perimeter = (a + b + c) / 2;
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }
}

class Rectangle extends Shape {
    private final double a, b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getArea() {
        return a * b;
    }
}