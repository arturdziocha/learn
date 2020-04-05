package hyperskill.args;

public class Calculator2 {
    public static void main(String[] args) {
        /*String operator = args[0];
        switch (operator) {
            case "MAX":
                int max = 0;
                for (int i = 1; i < args.length; i++) {
                    max = Math.max(Integer.parseInt(args[i]), max);
                }
                System.out.println(max);
                break;
            case "MIN":
                int min = Integer.MAX_VALUE;
                for (int i = 1; i < args.length; i++) {
                    min = Math.min(Integer.parseInt(args[i]), min);
                }
                System.out.println(min);
                break;
            case "SUM":
                int sum = 0;
                for (int i = 1; i < args.length; i++) {
                    sum += Integer.parseInt(args[i]);
                }
                System.out.println(sum);
                break;
        }*/
        String operator = args[0];
        java.util.List<Integer> list = new java.util.ArrayList<>();
        java.util.Map<String, java.util.function.Consumer<java.util.List<Integer>>> actions = new java.util.HashMap<>();
        for (int i = 1; i < args.length; i++) {
            list.add(Integer.parseInt(args[i]));
        }
        actions.put("MAX", l -> {
            System.out.println(l.stream().max(java.util.Comparator.comparing(Integer::valueOf)).get());
        });
        actions.put("MIN", l -> {
            System.out.println(l.stream().min(java.util.Comparator.comparing(Integer::valueOf)).get());
        });
        actions.put("SUM", l -> {
            System.out.println(l.stream().reduce(0, (a, b) -> a + b));
        });
        actions.get(operator).accept(list);
    }

}
