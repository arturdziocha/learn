package hyperskill.numbers;

public class BitShift {
    public static void main(String[] args) {
        int n1 = 7;
        int n2 = 1;

        int result = n1 & n2;
        System.out.println(result);

        int n = 15;

        result = n << 2 << 1;
        System.out.println(result);
    }
}
