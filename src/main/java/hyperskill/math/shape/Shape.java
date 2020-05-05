package hyperskill.math.shape;

/*
You have an abstract class Shape with two abstract methods: getPerimeter() and getArea(). See the provided code template.







You need to declare and implement three classes: Triangle, Rectangle and Circle. The classes must extend the Shape class and implement all abstract methods. To implement the methods the standard class Math may help you.

Note: do NOT make your classes public.

- The class Triangle must have a constructor with three double arguments for setting the length of each side. To calculate the area of this shape you may use the Heron's formula.

- The class Rectangle must have a constructor with two double arguments for setting the length of different sides.

- The class Circle must have a constructor with one double argument for setting the radius. You may use Math.PI as the PI constant or you can declare it yourself.



Examples

A circle has a radius = 10: perimeter = 62.831853..., area = 314.159265....

A triangle has three sides a = 3, b = 4 and c = 5: perimeter = 12.0, area = 6.0.

A rectangle has two different sides a = 5, b = 10: perimeter = 30.0, area = 50.0.
 */
public abstract class Shape {
    abstract double getPerimeter();

    abstract double getArea();
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
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
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double perimeter = getPerimeter() / 2;
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
    double getPerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    double getArea() {
        return a * b;
    }
}