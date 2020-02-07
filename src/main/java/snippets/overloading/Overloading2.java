package snippets.overloading;

public class Overloading2 {
    public static long getMaxMinusCurrent(long val) {
        return Long.MAX_VALUE - val;
    }

    public static short getMaxMinusCurrent(short val) {
        return (short) (Short.MAX_VALUE - val);
    }

    public static int getMaxMinusCurrent(int val) {
        return Integer.MAX_VALUE - val;
    }

}
