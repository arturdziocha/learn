package hyperskill.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LuckyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        List<Integer> numbers =
                scanner.nextLine().chars().boxed().collect(Collectors.toCollection(ArrayList::new));
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0, j = numbers.size() / 2; i < numbers.size() / 2; i++, j++) {
            sum1 += numbers.get(i);
            sum2 += numbers.get(j);
        }
        System.out.println(sum1 == sum2 ? "Lucky" : "Regular");
    }
}
