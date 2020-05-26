package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class LinearSolution {
    private final Matrix matrix = new Matrix();
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int[] w = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        howManyColumns = w[0];
        howManyEquations = w[1];

        column = new Column(howManyColumns);
        for (int i = 0; i < howManyEquations; i++) {
            Row row = new Row();
            String[] r = scanner.nextLine().split("\\s+");
            System.out.println(Arrays.toString(r));

            for (int j = 0; j < howManyColumns; j++) {
                row.add(ComplexNumber.parse(r[j]));
            }
            result.add(ComplexNumber.parse(r[howManyColumns]));
            matrix.add(row);
        }
        scanner.close();
    }

    void print() {
        column.getColumns().forEach(c -> System.out.printf("  %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().forEach(s -> System.out.printf("%s ", s));
            System.out.printf("%s\n", result.get(i));
        });
        System.out.println();
    }

}
