package hyperskill.toString;

public class Overri {

}

class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person{name=%s,age=%d}", name, age);
    }
}

class Patient extends Person {

    protected int height;

    public Patient(String name, int age, int height) {
        super(name, age);
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Patient{name=%s,age=%d,height=%d}", name, age, height);
    }
}
class Vehicle {

    protected String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    @Override
    public String toString() {
        return String.format("Vehicle{licensePlate=%d}", licensePlate);
    }
}

class Car extends Vehicle {

    protected int numberOfSeats;

    public Car(String licensePlate, int numberOfSeats) {
        super(licensePlate);
        this.numberOfSeats = numberOfSeats;
    }
    @Override
    public String toString() {
        return String.format("Car{licensePlate=%d,numberOfSeats=%d}", licensePlate, numberOfSeats);
    }
}