package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GaussianElimination {
    private final Matrix matrix = new Matrix();
    private boolean logOperations;
    Log log = new Log();
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    public GaussianElimination(boolean logOperations) {
        this.logOperations = logOperations;
    }

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

            for (int j = 0; j < howManyColumns; j++) {
                row.add(new ComplexNumber(r[j]));
            }
            result.add(new ComplexNumber(r[howManyColumns]));
            matrix.add(row);
        }
        scanner.close();
    }

    public String getSolution() {
        return solution;
    }

    public void write(File file, File logFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            log.write("\n");
            log.write(String.format("The solution is: %s\n", solution.replace("\n", ", ")));
            writer.print(solution);
            log.write(String.format("Saved to file %s", file.getAbsolutePath()));
        }
        try (PrintWriter writer = new PrintWriter(logFile)) {
            log.getLog().forEach(writer::print);
        }

    }

    public void solve() {
        stage1();
        IntStream.range(0, howManyEquations).forEach(this::stage2);

        int s = Math.min(howManyColumns, howManyEquations);
        for (int row = s - 1; row > 0; row--) {
            stage3(row);
        }
        computeSolution();
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
                    log.write(String.format("R%d <-> R%d", (i + 1), findNext.getAsInt() + 1));
                    logOpers();
                    // print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    log.write(String.format("C%d <-> C%d", column.get(findNext.getAsInt()), column.get(i)));
                    logOpers();
                    // print();
                } else {
                    Optional<RowColHelper> optional = matrix.findFirstNonZeroColRow(i);
                    if (optional.isPresent()) {
                        int row = optional.get().getRow();
                        matrix.switchRow(i, row);
                        result.switchResult(i, row);
                        log.write(String.format("R%d <-> R%d", (i + 1), row));
                        logOpers();
                        int col = optional.get().getColumn();
                        matrix.switchColumns(i, col);
                        column.switchColumn(i, col);
                        log.write(String.format("C%d <-> C%d", column.get(col), column.get(i)));
                        logOpers();
                        // print();
                    }
                }
            }
        }
    }

    void stage2(int row) {
        if (row < matrix.getRow(row).size()) {
            ComplexNumber number = matrix.getRow(row).getColumn(row);
            if (number.getReal() != 0.0 || (number.getReal() == 0.0 && number.getImaginary() != 0.0)) {
                updateRowByDivide(row, number);
            }
            updateRowByAddDown(row);
        }
    }

    private void updateRowByDivide(int row, ComplexNumber number) {
        result.update(row, result.get(row).divide(number));
        IntStream
                .range(0, matrix.getRow(row).size())
                .forEach(i -> matrix.update(row, i, matrix.getRow(row).getColumn(i).divide(number)));
        log.write(String.format("R%d / %s -> R%d", row + 1, number, row + 1));
        logOpers();
    }

    private void updateRowByAddDown(int row) {
        IntStream.range(row + 1, howManyEquations).forEach(i -> {
            ComplexNumber k = new ComplexNumber(0.0, 0.0).subtract(matrix.getRow(i).getColumn(row));
            if (matrix.getRow(row + 1).countImaginary() != howManyColumns) {
                result.update(i, result.get(i).add(result.get(row).multiply(k)));
                IntStream
                        .range(row, matrix.getRow(row).size())
                        .forEach(j -> matrix
                                .update(i, j,
                                        matrix.getRow(i).getColumn(j).add(k.multiply(matrix.getRow(row).getColumn(j)))));
                log.write(String.format("%s * R%d + R%d -> R%d\n", k, row + 1, i + 1, i + 1));
                logOpers();
                // print();

            }
        });

    }

    private void stage3(int row) {
        for (int i = row - 1; i >= 0; i--) {
            ComplexNumber k = new ComplexNumber(0.0, 0.0).subtract(matrix.getRow(i).getColumn(row));
            if (matrix.getRow(row).getColumn(row).getReal() == 1.0) {
                result.update(i, result.get(i).add(result.get(row).multiply(k)));
                for (int col = howManyColumns - 1; col >= 0; col--) {
                    matrix
                            .update(i, col,
                                    matrix.getRow(i).getColumn(col).add(k.multiply(matrix.getRow(row).getColumn(col))));

                }
                log.write(String.format("%s * R%d + R%d -> R%d", k, row + 1, i + 1, i + 1));
                logOpers();
                // print();
            }
        }
    }

    private void computeSolution() {
        boolean noSol = false;
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
    }

    private void logOpers() {
        if (logOperations) {
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            column.getColumns().forEach(c -> builder.append(String.format("  %s  ", c)));
            builder.append(String.format("%s\n", "result"));
            IntStream.range(0, howManyEquations).forEach(i -> {
                matrix.getRow(i).getAll().forEach(s -> builder.append(String.format("%s | ", s)));
                builder.append(String.format("%s\n", result.get(i)));
            });
            builder.append("\n");
            log.write(builder.toString());
        }
    }
}
