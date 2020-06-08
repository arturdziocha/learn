package hyperskill.numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumToBinary {
    public static void main(String[] args) {
        System.out.println(byDivision(24));
        System.out.println(bySubstraction(24));
    }

    public static String byDivision(long number) {
        StringBuilder builder = new StringBuilder();
        if (number == 0) {
            return "0";
        }
        while (number != 0) {
            if (number == 1) {
                builder.append("1");
                number = 0;
            } else {
                builder.append((int) number % 2);
                number = (int) Math.ceil(number / 2);
            }
        }
        return builder.reverse().toString();
    }

    public static String bySubstraction(long number) {
        if(number==0) {
            return "0";
        }
        List<Long> powers = new ArrayList<>();
        for (int i = 0; i < Math.sqrt(number); i++) {
            long pow = (long) Math.pow(2, i);
            if (pow <= number) {
                powers.add((long) Math.pow(2, i));
            }
        }
        powers.sort(Comparator.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (long s : powers) {
            if (s <= number) {
                builder.append("1");
                number -= s;
            } else {
                builder.append("0");
            }
        }
        return builder.toString();

    }
}
