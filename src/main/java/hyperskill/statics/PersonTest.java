package hyperskill.statics;

public class PersonTest {
    public static void main(String args[]) {

        Person person = new Person("R. Johnson");

        System.out.println(person.getNextId()); // (1)
    }
}

class Person {

    private static long nextId = 1;

    long id;
    String name;

    public Person(String name) {
        this.name = name;
        this.id = nextId;
        nextId++; // (2)
    }

    public long getNextId() { // (3)
        return nextId;
    }
}