package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
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

    public void solve() {
        stage1();
    }

    private void stage1() {
        int s = Math.min(howManyColumns, howManyEquations);
        double zero = 0.0;
        for (int i = 0; i < s; i++) {
            ComplexNumber toCheck = matrix.getRow(i).getColumn(i);
            if (toCheck.getReal() == 0.0 || toCheck.getImaginary() == 0.0) {
                OptionalInt findNext;
                if ((findNext = matrix.findNonZeroRow(i)).isPresent()) {
                    matrix.switchRow(i, findNext.getAsInt());
                    result.switchResult(i, findNext.getAsInt());
                    System.out.println("R" + (i + 1) + " <-> R" + (findNext.getAsInt() + 1));
                    print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    System.out.println("C"+column.get(findNext.getAsInt()) + " <-> C" + column.get(i));
                    print();
                } else {
                    Optional<RowColHelper> optional = matrix.findFirstNonZeroColRow(i);
                    if (optional.isPresent()) {
                        int row = optional.get().getRow();
                        matrix.switchRow(i, row);
                        result.switchResult(i, row);
                        System.out.println("R" + (i + 1) + " <-> R" + (row));

                        int col = optional.get().getColumn();
                        matrix.switchColumns(i, col);
                        column.switchColumn(i, col);
                        System.out.println("Cs" + column.get(col) + " <-> " + "C" + column.get(i));
                        print();
                    }
                }
            }
        }
    }

    void print() {
        column.getColumns().forEach(c -> System.out.printf("  %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().forEach(s -> System.out.printf("%s | ", s));
            System.out.printf("%s\n", result.get(i));
        });
        System.out.println();
    }

}
