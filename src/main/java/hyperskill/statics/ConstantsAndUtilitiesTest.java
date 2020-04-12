package hyperskill.statics;

public class ConstantsAndUtilitiesTest {
    public static void main(String[] args) {
        System.out.println(ConstantsAndUtilities.A_CONSTANT_TTT);
        System.out.println(ConstantsAndUtilities.B_CONSTANT_QQQ);
        System.out.println(ConstantsAndUtilities.getMagicString());
        System.out.println(ConstantsAndUtilities.convertStringToAnotherString("aa"));
    }
}

class ConstantsAndUtilities {

    public static final String A_CONSTANT_TTT = "A_CONSTANT_TTT"; // here is a value

    public static final String B_CONSTANT_QQQ = "B_CONSTANT_QQQ";// here is another value

    public static String getMagicString() {
        return "getMagicString()";
    }

    public static String convertStringToAnotherString(String s) {
        return "convertStringToAnotherString(" + s + ")";
    }
}