package hyperskill.inheritance;

public class SuperTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.printBaseValue();
        subClass.printSubValue();
    }
}

class SuperClass {

    protected int field;

    protected int getField() {
        return field;
    }

    protected void printBaseValue() {
        System.out.println(field);
    }
}

class SubClass extends SuperClass {

    protected int field;

    public SubClass() {
        this.field = 30; // It initializes the field of SubClass
        field = 30; // It also initializes the field of SubClass
        super.field = 20; // It initializes the field of SuperClass
    }

    /**
     * It prints the value of SuperClass and then the value of SubClass
     */
    public void printSubValue() {
        super.printBaseValue(); // It invokes the method of SuperClass, super is
                                // optional here
        System.out.println(field);
    }
}
