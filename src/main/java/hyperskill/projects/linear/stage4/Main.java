package hyperskill.projects.linear.stage4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinearSolution solution = new LinearSolution();
        File file = new File("src/main/java/hyperskill/projects/linear/stage4/in.txt");
        solution.read(file);
        solution.print();
        solution.solve();
    }
}

class Matrix {
    private List<Row> rows;

    Matrix() {
        this.rows = new ArrayList<>();
    }

    void add(Row row) {
        rows.add(row);
    }

    int size() {
        return rows.size();
    }

    Row getRow(int index) {
        return rows.get(index);
    }

    public List<Row> getRows() {
        return rows;
    }

    void switchRow(int from, int to) {
        Row temp = rows.get(from);
        rows.set(from, rows.get(to));
        rows.set(to, temp);
    }

    void switchColumns(int from, int to) {
        rows.stream().forEach(r -> r.switchRow(from, to));
    }

    OptionalInt findFirstNonZeroRow(int start) {
        return IntStream
                .range(start + 1, rows.size())
                .filter(i -> !rows.get(i).getColumn(start).equals(Double.valueOf(0)))
                .findFirst();
    }

    OptionalInt findFirstNonZeroInColumn(int start) {
        Row row = rows.get(start);
        return IntStream
                .range(start + 1, row.getAll().size())
                .filter(i -> !row.getColumn(i).equals(Double.valueOf(0)))
                .findFirst();
    }

    Optional<RowColHelper> findFirstNonZeroColRow(int start) {
        for (int row = start + 1; row < rows.size(); row++) {
            for (int col = start + 1; col < rows.get(row).size(); col++) {
                if (!rows.get(row).getColumn(col).equals(Double.valueOf(0))) {
                    return Optional.of(new RowColHelper(row, col));
                }
            }
        }
        return Optional.empty();
    }

    public void update(int row, int index, double value) {
        rows.get(row).updateColumn(index, value);
    }
}

class Row {
    List<Double> row;

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
    private List<String> columns;

    Column(int howManyColumns) {
        columns = IntStream
                .rangeClosed(1, howManyColumns)
                .mapToObj(i -> String.valueOf("x" + i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getColumns() {
        return columns;
    }

    void switchColumn(int from, int to) {
        String temp = columns.get(from);
        columns.set(from, columns.get(to));
        columns.set(to, temp);
    }

    String get(int index) {
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

    List<Double> getAll() {
        return result;
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
    private Matrix matrix;
    private Column column;
    private Result result;
    int howManyColumns;
    int howManyEquations;

    public LinearSolution() {
        this.matrix = new Matrix();
        this.result = new Result();
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

    void solve() {
        stage1();
        IntStream.range(0, howManyEquations).forEach(this::stage2);
    }

    void stage1() {
        for (int i = 0; i < howManyColumns; i++) {
            if (matrix.getRow(i).getColumn(i).equals(Double.valueOf(0))) {
                System.out.println(i);
                OptionalInt findNext;
                if ((findNext = matrix.findFirstNonZeroRow(i)).isPresent()) {
                    matrix.switchRow(i, findNext.getAsInt());
                    result.switchResult(findNext.getAsInt(), i);
                    System.out.println("R" + (i + 1) + " <-> R" + (findNext.getAsInt() + 1));
                    print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    System.out
                            .println(
                                column.get(findNext.getAsInt()).toUpperCase() + " <-> " + column.get(i).toUpperCase());
                    print();
                } else {
                    Optional<RowColHelper> optional = matrix.findFirstNonZeroColRow(i);
                    if (optional.isPresent()) {
                        int row = optional.get().getRow();
                        matrix.switchRow(i, row);
                        result.switchResult(i, row);
                        System.out.println("R" + (i + 1) + " <-> R" + (row));
                        print();
                        int col = optional.get().getColumn();
                        matrix.switchColumns(i, col);
                        column.switchColumn(i, col);
                        System.out.println(column.get(col).toUpperCase() + " <-> " + column.get(i).toUpperCase());
                        print();
                    }
                }
            }
        }
    }

    void stage2(int row) {
        if (row < matrix.getRow(row).size()) {
            if (matrix.getRow(row).getColumn(row) == 0) {

            }

            if (!matrix.getRow(row).getColumn(row).equals(Double.valueOf(1))) {
                Double k = matrix.getRow(row).getColumn(row);
                IntStream.range(row, matrix.getRow(row).size()).forEach(i -> {
                    matrix.update(row, i, matrix.getRow(row).getColumn(i) / k);
                    result.update(i, result.get(i) / k);
                });
                System.out.println((1 / k) + " * R" + (row + 1) + " -> R" + (row + 1));
                print();
            }
            IntStream.range(row + 1, howManyEquations).forEach(i -> {
                double k = -matrix.getRow(i).getColumn(row);
                if (k != 0) {
                    result.update(i, result.get(i) + k * result.get(row));
                    IntStream.range(row, matrix.getRow(row).size()).forEach(j -> {
                        
                            matrix.update(i, j, matrix.getRow(i).getColumn(j) + k * matrix.getRow(row).getColumn(j));
                        
                        // matrix[i][j] += k * matrix[row][j];
                    });
                    System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                    // print();
                }
            });
            print();
        }
    }

    void print() {
        column.getColumns().stream().forEach(c -> System.out.printf(" %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().stream().forEach(s -> System.out.printf("%.2f ", s));
            System.out.printf("%.2f\n", result.get(i));
        });

    }
}
