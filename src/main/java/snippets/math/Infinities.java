package snippets.math;

public class Infinities {
    public static void main(String[] args) {
        System.out.println(Double.POSITIVE_INFINITY - 2 * Double.POSITIVE_INFINITY);// NaN
        System.out.println(Double.NEGATIVE_INFINITY + Double.NEGATIVE_INFINITY);// -Infinity
        System.out.println(-21.3 / 0.0);// -Infinity
        System.out.println(Double.NaN - Double.POSITIVE_INFINITY);// NaN
        System.out.println(0.0 / 0.0);// NaN
        System.out.println(1.0 / 0.0);// +Inifinity
        System.out.println(Float.MAX_VALUE < Double.MAX_VALUE);// true
        System.out.println(Float.POSITIVE_INFINITY < Double.POSITIVE_INFINITY);// false
        System.out.println(0.0 / 0.0 == 0.0 / 0.0);
    }
}
