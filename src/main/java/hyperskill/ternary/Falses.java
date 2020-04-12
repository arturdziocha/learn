package hyperskill.ternary;

public class Falses {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        System.out.println((b1 && b2) ? b1 : (b2 || b3) ? b2 : b3);

        b1 = false;
        b2 = false;
        b3 = false;
        System.out.println((b1 && b2) ? b1 : (b2 || b3) ? b2 : b3);

        b1 = false;
        b2 = false;
        b3 = true;
        System.out.println((b1 && b2) ? b1 : (b2 || b3) ? b2 : b3);
        b1 = false;
        b2 = true;
        b3 = false;
        System.out.println((b1 && b2) ? b1 : (b2 || b3) ? b2 : b3);
        b1 = true;
        b2 = false;
        b3 = false;
        System.out.println((b1 && b2) ? b1 : (b2 || b3) ? b2 : b3);
    }
}
