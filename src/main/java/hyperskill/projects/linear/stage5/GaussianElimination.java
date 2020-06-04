package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GaussianElimination {
    private final Matrix matrix = new Matrix();
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        read(scanner);
    }

    void read(String string) {
        Scanner scanner = new Scanner(string);
        read(scanner);
    }

    private void read(Scanner scanner) {
        int[] w = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        howManyColumns = w[0];
        howManyEquations = w[1];

        column = new Column(howManyColumns);
        for (int i = 0; i < howManyEquations; i++) {
            Row row = new Row();
            String[] r = scanner.nextLine().split("\\s+");
            System.out.println(Arrays.toString(r));

            for (int j = 0; j < howManyColumns; j++) {
                row.add(new ComplexNumber(r[j]));
            }
            result.add(new ComplexNumber(r[howManyColumns]));
            matrix.add(row);
        }
        scanner.close();
    }

    public String getSolution() {
        boolean noSol = false;
        boolean oneSol = false;
        // No solution check
        for (int i = 0; i < howManyEquations; i++) {
            if (matrix.getRow(i).countRealZerosInRow() == howManyColumns && result.get(i).getReal() != 0.0) {
                noSol = true;
                solution = "No solutions";
                break;
            }
        }
        if (!noSol) {
            // One solution
            int sum = 0;
            for (int i = 0; i < howManyEquations; i++) {
                long count = matrix.getRow(i).countRealZerosInRow();
                if (count == howManyColumns - 1) {
                    sum += 1;
                }
            }
            if (sum == howManyColumns) {

                Map<Integer, ComplexNumber> map = IntStream
                        .range(0, howManyColumns)
                        .collect(TreeMap::new, (m, i) -> m.put(column.get(i), result.get(i)), TreeMap::putAll);
                solution = map.values().stream().map(String::valueOf).collect(Collectors.joining("\n"));
            } else {
                solution = "Infinitely many solutions";
            }
        }
        return solution;
    }

    public void write(File file) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println();
            System.out.println("The solution is: " + solution.replace("\n", ", "));
            writer.print(solution);
            System.out.println("Saved to file " + file.getAbsolutePath());
        }
    }

    public void solve() {
        print();
        stage1();
        IntStream.range(0, howManyEquations).forEach(this::stage2);
        // IntStream.range(0, howManyEquations).forEach(this::stage3);

        int s = Math.min(howManyColumns, howManyEquations);
        for (int row = s - 1; row > 0; row--) {
            stage4(row);
        }
    }

    private void stage1() {
        int s = Math.min(howManyColumns, howManyEquations);
        for (int i = 0; i < s; i++) {
            ComplexNumber toCheck = matrix.getRow(i).getColumn(i);
            if (toCheck.getReal() == 0.0) {
                OptionalInt findNext;
                if ((findNext = matrix.findNonZeroRow(i)).isPresent()) {
                    matrix.switchRow(i, findNext.getAsInt());
                    result.switchResult(i, findNext.getAsInt());
                    System.out.println("R" + (i + 1) + " <-> R" + (findNext.getAsInt() + 1));
                    print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    System.out.println("C" + column.get(findNext.getAsInt()) + " <-> C" + column.get(i));
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

    void stage2(int row) {
        if (row < matrix.getRow(row).size()) {
            ComplexNumber number = matrix.getRow(row).getColumn(row);
            System.out.println(number.getReal() + " " + number.getImaginary());
            if (number.getReal() != 0.0) {
                result.update(row, result.get(row).divide(number));
                IntStream
                        .range(0, matrix.getRow(row).size())
                        .forEach(i -> matrix.update(row, i, matrix.getRow(row).getColumn(i).divide(number)));
                System.out.println("R" + (row + 1) + " / " + number + " -> R" + (row + 1));
                print();

            } else if (number.getReal() == 0.0 && number.getImaginary() != 0.0) {
                result.update(row, result.get(row).divide(number));
                IntStream
                        .range(0, matrix.getRow(row).size())
                        .forEach(i -> matrix.update(row, i, matrix.getRow(row).getColumn(i).divide(number)));
                System.out.println("R" + (row + 1) + " / " + number + " -> R" + (row + 1));
                print();

            }
            IntStream.range(row + 1, howManyEquations).forEach(i -> {
                ComplexNumber k = new ComplexNumber(0.0, 0.0).subtract(matrix.getRow(i).getColumn(row));

                result.update(i, result.get(i).add(result.get(row).multiply(k)));
                IntStream
                        .range(row, matrix.getRow(row).size())
                        .forEach(j -> matrix
                                .update(i, j,
                                    matrix.getRow(i).getColumn(j).add(k.multiply(matrix.getRow(row).getColumn(j)))));
                System.out.printf("%s * R%d + R%d -> R%d\n", k, row + 1, i + 1, i + 1);
                print();

            });

        }
    }

    void stage3(int row) {
        if (row < matrix.getRow(row).size()) {
            IntStream.range(row + 1, howManyEquations).forEach(i -> {
                ComplexNumber k = new ComplexNumber(0.0, 0.0).subtract(matrix.getRow(i).getColumn(row));

                result.update(i, result.get(i).add(result.get(row).multiply(k)));
                IntStream
                        .range(row, matrix.getRow(row).size())
                        .forEach(j -> matrix
                                .update(i, j,
                                    matrix.getRow(i).getColumn(j).add(k.multiply(matrix.getRow(row).getColumn(j)))));
                System.out.printf("%s * R%d + R%d -> R%d\n", k, row + 1, i + 1, i + 1);

                print();
            });
        }
    }

    private void stage4(int row) {
        for (int i = row - 1; i >= 0; i--) {
            ComplexNumber k = new ComplexNumber(0.0, 0.0).subtract(matrix.getRow(i).getColumn(row));
            if (matrix.getRow(row).getColumn(row).getReal() == 1.0) {
                result.update(i, result.get(i).add(result.get(row).multiply(k)));
                for (int col = howManyColumns - 1; col >= 0; col--) {
                    matrix
                            .update(i, col,
                                matrix.getRow(i).getColumn(col).add(k.multiply(matrix.getRow(row).getColumn(col))));

                }
                System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                print();

            }
        }
    }
    

    private void print() {
        column.getColumns().forEach(c -> System.out.printf("  %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().forEach(s -> System.out.printf("%s | ", s));
            System.out.printf("%s\n", result.get(i));
        });
        System.out.println();
    }
}
