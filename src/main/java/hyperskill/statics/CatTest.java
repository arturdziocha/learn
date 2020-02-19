package hyperskill.statics;

public class CatTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            Cat cat = new Cat("SS", 7);
            System.out.println(cat.name);
        }
    }
}

class Cat {

    String name;
    int age;
    public static int counter = 0;

    public Cat(String name, int age) {

        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}