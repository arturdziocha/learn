package hyperskill.collection.arrays;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();

    }

    public static void test1() {
        int[] a = {2, 3, 1, 0, 9};
        int s = a[0] + a[1] + a[a.length - 1];
        int y = a[3] - 2 * a[2];
        System.out.println(s / y);
    }

    /**
     * Print array after changes
     */
    public static void test2() {
        int[] c = {3, 5, 2, 1, 4};
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

    // Given below is an array of integers:
    //
    // a = [3, 0, 3, 9, 2, 1]
    // The following procedures perform some calculations with the array:
    //
    // 1: r = 7 for i in 0..len(a): x = a[i] x = x * x - x r += x
    // 2: r = 13 r += a[a[0]] r -= a[a[len(a)-1]]
    // 3: r = 0 for i in 0..len(a): if a[i] < len(a): r += a[a[i]]

    public static void test3() {
        int[] a = {3, 0, 3, 9, 2, 1};
        int r = 7;
        int x;
        for (int i = 0; i < a.length; i++) {
            x = a[i];
            x = x * x - x;
            r += x;
        }
        System.out.println(r);
        r = 13;
        r += a[a[0]];
        r -= a[a[a.length - 1]];
        System.out.println(r);

        r = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a.length)
                r += a[a[i]];
        }
        System.out.println(r);
    }

    // Given below is an array of integer numbers:
    //
    // a = [9, 8, 3, 1, 5, 4]
    // Assume we apply the following procedure for the array:
    //
    // for i in 0..len(a):
    // if a[i] % 2 == 0:
    // a[i] += 1
    // elif a[i] < len(a):
    // a[i] += a[a[i]]
    public static void test4() {
        int[] a = {9, 8, 3, 1, 5, 4};
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                a[i] += 1;
            } else if (a[i] < a.length) {
                a[i] += a[a[i]];
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //    Consider two arrays aa and bb:
//
//        a = [4, 0, 9, 2, 1]
//        b = [6, 3, 2, 9, 0]
//        Assume that we performed the following procedure with the arrays:
//
//        for i in 0..len(a):
//            if i % 2 == 0:
//                a[i] -= b[i]
//            else:
//                b[i] -= a[i]
//            
//            if a[i] % 2 == 0:
//                a[i] += 1
//                b[i] += 1
//        What is the state of the arrays after the procedure is completed? 
    // Print the elements of each array separated by spaces in the field below.
    // Each array should be on a separate line (first aa, then bb). For example,
    // your output may look like this:
    public static void test5() {
        int[] a = {4, 0, 9, 2, 1};
        int[] b = {6, 3, 2, 9, 0};
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] -= b[i];
            } else {
                b[i] -= a[i];
            }
            if (a[i] % 2 == 0) {
                a[i] += 1;
                b[i] += 1;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
