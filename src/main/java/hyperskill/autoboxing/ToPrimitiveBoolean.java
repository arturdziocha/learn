package hyperskill.autoboxing;

public class ToPrimitiveBoolean {
    public static boolean toPrimitive(Boolean b) {
        return b != null && b;
    }

    public static void main(String[] args) {
        Boolean b1 = Boolean.valueOf("false");
        System.out.println(toPrimitive(b1));
    }
}
