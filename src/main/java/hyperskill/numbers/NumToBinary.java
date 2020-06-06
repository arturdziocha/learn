package hyperskill.numbers;

public class NumToBinary {
    public static void main(String[] args) {
        System.out.println(byDivision(42));
    }

    public static String byDivision(double number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0.0) {
            if (number == 1.0) {
                builder.append("1");
                number = 0.0;
            } else {
                builder.append(String.valueOf((int) number % 2));
                number = Math.ceil(number / 2);
            }
        }
        return builder.reverse().toString();
    }
}
