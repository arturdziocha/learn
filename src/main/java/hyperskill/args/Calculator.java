package hyperskill.args;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Calculator {
    public static void main(String[] args) {
        Map<String, BiConsumer<Integer, Integer>> actions = new HashMap<>();
        actions.put("+", (first, second) -> {
            System.out.println(Integer.sum(first, second));
        });
        actions.put("-", (first, second) -> {
            System.out.println(first.intValue() - second.intValue());
        });
        actions.put("*", (first, second) -> {
            System.out.println(first * second);
        });
        String operator = args[0];
        Integer first = Integer.parseInt(args[1]);
        Integer second = Integer.parseInt(args[2]);
        if (actions.containsKey(operator)) {
            actions.get(operator).accept(first, second);
        } else {
            System.out.println("Unknown operator");
        }
    }
}
