package hyperskill.exceptions;

import java.util.Arrays;
import java.util.Scanner;

/*
Consider the two methods: methodThrowingExceptions and methodCatchingSomeExceptions.

The first one throws unchecked exceptions of different types.

Your task is to implement the second method. It must call the first method and catch two types of exceptions:

ArrayIndexOutOfBoundsException
NumberFormatException
Inside the catch block (or blocks) you should print the name of the handled exception class (only name, without packages) to the standard output, like:

ArrayIndexOutOfBoundsException
Other types of exceptions must not be caught by the methodCatchingSomeExceptions.
 */
public class MethodCatchingSomeExceptions {
    public static void methodCatchingSomeExceptions() {
        try {
            methodThrowingExceptions();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    /* Do not change code below */
    public static void methodThrowingExceptions() {
        if (array == null) {
            return;
        }
        int[] integers = Arrays.stream(array.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Object someValue = integers[integers[0]];
        if (integers[0] + integers[1] == integers[2]) {
            integers = null;
        }
        int sum = 0;
        for (int i : integers) {
            sum += i;
        }
        int meanValue = integers.length / sum;
        if (integers[2] == integers[3]) {
            String string = (String) someValue;
            System.out.print("Random value is " + string);
        }
        System.out.print("Mean is " + meanValue);
    }

    private static String array = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        array = scanner.nextLine();
        try {
            methodCatchingSomeExceptions();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getName());
        }
    }
}
