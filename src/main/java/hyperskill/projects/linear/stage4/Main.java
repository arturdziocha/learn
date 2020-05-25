package hyperskill.projects.linear.stage4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinearSolution solution = new LinearSolution();
        File in = new File("src/main/java/hyperskill/projects/linear/stage4/in.txt");
        // File in = new File(args[1]);
        File out = new File("src/main/java/hyperskill/projects/linear/stage4/out.txt");
        // File out = new File(args[3]);
        solution.read(in);
        solution.solve();
        solution.write(out);
    }
}

class Matrix {
    private final List<Row> rows;

    Matrix() {
        this.rows = new ArrayList<>();
    }

    void add(Row row) {
        rows.add(row);
    }

    Row getRow(int index) {
        return rows.get(index);
    }

    void switchRow(int from, int to) {
        Row temp = rows.get(from);
        rows.set(from, rows.get(to));
        rows.set(to, temp);
    }

    void switchColumns(int from, int to) {
        rows.forEach(r -> r.switchRow(from, to));
    }

    OptionalInt findFirstNonZeroRow(int start) {
        return IntStream
                .range(start + 1, rows.size())
                .filter(i -> !rows.get(i).getColumn(start).equals((double) 0))
                .findFirst();
    }

    OptionalInt findFirstNonZeroInColumn(int start) {
        Row row = rows.get(start);
        return IntStream
                .range(start + 1, row.getAll().size())
                .filter(i -> !row.getColumn(i).equals((double) 0))
                .findFirst();
    }

    Optional<RowColHelper> findFirstNonZeroColRow(int start) {
        for (int row = start + 1; row < rows.size(); row++) {
            for (int col = start + 1; col < rows.get(row).size(); col++) {
                if (!rows.get(row).getColumn(col).equals((double) 0)) {
                    return Optional.of(new RowColHelper(row, col));
                }
            }
        }
        return Optional.empty();
    }

    public void update(int row, int index, double value) {
        rows.get(row).updateColumn(index, value);
    }

    public Double sumOfRow(int row) {
        return rows.get(row).getAll().stream().reduce((double) 0, Double::sum);
    }

    public Double sumOfDigonal(int numOfColumns) {
        return IntStream.range(0, numOfColumns).mapToDouble(row -> rows.get(row).getColumn(row)).sum();
    }
}

class Row {
    private final List<Double> row;

    Row() {
        this.row = new ArrayList<>();
    }

    public void updateColumn(int index, double value) {
        this.row.set(index, value);

    }

    void add(Double value) {
        row.add(value);
    }

    public Double getColumn(int index) {
        return row.get(index);
    }

    public List<Double> getAll() {
        return row;
    }

    int size() {
        return row.size();
    }

    void switchRow(int from, int to) {
        Double temp = row.get(from);
        row.set(from, row.get(to));
        row.set(to, temp);
    }

}

class Column {
    private final List<Integer> columns;

    Column(int howManyColumns) {
        columns = IntStream
                .rangeClosed(1, howManyColumns)
                .mapToObj(i -> +i)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> getColumns() {
        return columns;
    }

    void switchColumn(int from, int to) {
        int temp = columns.get(from);
        columns.set(from, columns.get(to));
        columns.set(to, temp);
    }

    int get(int index) {
        return columns.get(index);
    }

}

class Result {
    List<Double> result;

    Result() {
        result = new ArrayList<>();
    }

    void add(Double value) {
        result.add(value);
    }

    Double get(int index) {
        return result.get(index);
    }

    void switchResult(int from, int to) {
        Double temp = result.get(from);
        result.set(from, result.get(to));
        result.set(to, temp);
    }

    public void update(int index, double value) {
        result.set(index, value);

    }
}

class RowColHelper {
    private final int row;
    private final int column;

    public RowColHelper(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

class LinearSolution {
    private final Matrix matrix;
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    public LinearSolution() {
        this.matrix = new Matrix();
    }

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        howManyColumns = scanner.nextInt();
        howManyEquations = scanner.nextInt();

        column = new Column(howManyColumns);
        for (int i = 0; i < howManyEquations; i++) {
            Row row = new Row();
            for (int j = 0; j < howManyColumns; j++) {
                row.add(scanner.nextDouble());
            }
            result.add(scanner.nextDouble());
            matrix.add(row);
        }
        scanner.close();

    }

    public void write(File file) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println();
            System.out.println("The solution is: " + solution.replace("\n", ", "));
            writer.println(solution);
            System.out.println("Saved to file " + file.getAbsolutePath());
        }
    }

    void solve() {
        print();
        stage1();
        IntStream.range(0, howManyEquations).forEach(this::stage2);
        boolean noSolutions = false;
        for (int i = 0; i < howManyEquations; i++) {
            if (isNoSolutions(i)) {
                noSolutions = true;
                break;
            }
        }
        if (noSolutions) {
            solution = "No solutions";
        } else {
            int s = Math.min(howManyColumns, howManyEquations);
            for (int row = s - 1; row > 0; row--) {
                stage3(row);
            }
            if (matrix.sumOfDigonal(s).equals((double) howManyColumns)) {
                Map<Integer, Double> map = IntStream
                        .range(0, howManyColumns)
                        .collect(TreeMap::new, (m, i) -> m.put(column.get(i), result.get(i)), TreeMap::putAll);
                solution = map.values().stream().map(String::valueOf).collect(Collectors.joining("\n"));
            } else {
                solution = "Infinitely many solutions";
            }
        }
    }

    void stage1() {
        int s = Math.min(howManyColumns, howManyEquations);
        for (int i = 0; i < s; i++) {
            if (matrix.getRow(i).getColumn(i).equals((double) 0)) {
                OptionalInt findNext;
                if ((findNext = matrix.findFirstNonZeroRow(i)).isPresent()) {
                    matrix.switchRow(i, findNext.getAsInt());
                    result.switchResult(findNext.getAsInt(), i);
                    System.out.println("R" + (i + 1) + " <-> R" + (findNext.getAsInt() + 1));
                    print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    System.out.println(column.get(findNext.getAsInt()) + " <-> " + column.get(i));
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
                        System.out.println(column.get(col) + " <-> " + column.get(i));
                        print();
                    }
                }
            }
        }
    }

    void stage2(int row) {
        if (row < matrix.getRow(row).size()) {
            if (matrix.getRow(row).getColumn(row) != 0) {
                if (!matrix.getRow(row).getColumn(row).equals(1d)) {
                    Double k = matrix.getRow(row).getColumn(row);
                    result.update(row, result.get(row) / k);
                    IntStream
                            .range(row, matrix.getRow(row).size())
                            .forEach(i -> matrix.update(row, i, matrix.getRow(row).getColumn(i) / k));
                    System.out.println((1 / k) + " * R" + (row + 1) + " -> R" + (row + 1));
                    print();

                }
                IntStream.range(row + 1, howManyEquations).forEach(i -> {
                    double k = -matrix.getRow(i).getColumn(row);
                    if (k != 0) {
                        result.update(i, result.get(i) + k * result.get(row));
                        IntStream.range(row, matrix.getRow(row).size()).forEach(j -> {
                            matrix.update(i, j, matrix.getRow(i).getColumn(j) + k * matrix.getRow(row).getColumn(j));
                        });
                        System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                        print();
                    }
                });
            }
        }

    }

    void stage3(int row) {
        for (int i = row - 1; i >= 0; i--) {
            double k = -matrix.getRow(i).getColumn(row);
            if (matrix.getRow(row).getColumn(row) == 1) {
                result.update(i, result.get(i) + k * result.get(row));
                for (int col = howManyColumns - 1; col >= 0; col--) {
                    matrix.update(i, col, matrix.getRow(i).getColumn(col) + k * matrix.getRow(row).getColumn(col));
                }
                System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                print();
            }

        }
    }

    private boolean isNoSolutions(int row) {
        return matrix.sumOfRow(row).equals((double) 0) && !result.get(row).equals((double) 0);
    }

    void print() {
        column.getColumns().forEach(c -> System.out.printf("  %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().forEach(s -> System.out.printf("%.2f ", s));
            System.out.printf("%.2f\n", result.get(i));
        });
        System.out.println();
    }
}
