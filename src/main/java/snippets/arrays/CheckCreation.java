package snippets.arrays;

public class CheckCreation {
    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c', 'd'};

        char[] array1 = new char[-1];

        //char[] array2 = new char[10000000000000]; The literal 10000000000000 of type int is out of 

        char[] array3 = new char[1];

        char[] array4 = new char[0];
    }
}
