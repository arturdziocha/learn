package hyperskill.collection.arrays;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] a = { 2, 3, 1, 0, 9 };
        int s = a[0] + a[1] + a[a.length - 1];
        int y = a[3] - 2 * a[2];
        System.out.println(s / y);

        int[] c = { 3, 5, 2, 1, 4 };
        int x = c[0];
        x += 10;
        c[0] -= x;
        c[3] += x;
        c[4] -= x;
        x -= c[2];
        c[2] = x;
        c[3] -= x;
        System.out.println(Arrays.toString(c));

    }
    public static void test2() {
        int[] c = { 3, 5, 2, 1, 4 };
        int x = c[0];
        x += 10;
        c[0] -= x;
        c[3] += x;
        c[4] -= x;
        x -= c[2];
        c[2] = x;
        c[3] -= x;
        System.out.println(Arrays.toString(c));
    }
}
