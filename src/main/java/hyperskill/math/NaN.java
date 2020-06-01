package hyperskill.math;

public class NaN {
    public static void main(String[] args) {
        System.out.println(1 / Double.POSITIVE_INFINITY);
        System.out.println(1 / Double.NaN);
        System.out.println(Double.POSITIVE_INFINITY / 5.0);
        System.out.println(Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY);
        System.out.println(Double.NaN - Double.NaN);
    }
}
