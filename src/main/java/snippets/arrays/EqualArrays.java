package snippets.arrays;

import java.util.Arrays;

public class EqualArrays {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4};
        int[] numbers2 = {1, 2, 3, 4};
        int[] numbers3 = {4, 3, 2, 1};
        int[] numbers4 = {1, 2, 3};
        boolean e1 = Arrays.equals(numbers1, numbers2);
        System.out.println(e1);
        boolean e2 = Arrays.equals(numbers2, numbers3);
        System.out.println(e2);
        boolean e3 = Arrays.equals(numbers1, numbers1);
        System.out.println(e3);
        boolean e4 = Arrays.equals(numbers3, numbers1);
        System.out.println(e4);
        boolean e5 = Arrays.equals(numbers1, numbers4);
        System.out.println(e5);
    }
}
