package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

class Matrix {
    private final List<Row> rows = new ArrayList<>();

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
        rows.forEach(r -> r.switchColumn(from, to));
    }

    public OptionalInt findNonZeroRow(int start) {
        return IntStream.range(start + 1, rows.size()).filter(i -> {
            ComplexNumber number = rows.get(i).getColumn(start);
            return number.getReal() != 0.0;
        }).findFirst();
    }

    public OptionalInt findFirstNonZeroInColumn(int start) {
        Row row = rows.get(start);
        return IntStream.range(start, row.getAll().size()).filter(i -> {
            ComplexNumber complexNumber = row.getColumn(i);
            return complexNumber.getReal() != 0.0 && complexNumber.getImaginary() != 0.0;
        }).findFirst();
    }

    public Optional<RowColHelper> findFirstNonZeroColRow(int start) {
        for (int row = start + 1; row < rows.size(); row++) {
            for (int col = start + 1; col < rows.get(row).size(); col++) {
                ComplexNumber number = rows.get(row).getColumn(col);
                if (number.getReal() != 0.0 && number.getImaginary() != 0.0) {
                    return Optional.of(new RowColHelper(row, col));
                }
            }
        }
        return Optional.empty();
    }

    public void update(int row, int index, ComplexNumber value) {
        rows.get(row).updateColumn(index, value);
    }

    public double sumOfRealInRow(int row) {
        return IntStream.range(0, rows.get(row).size()).mapToDouble(i->rows.get(row).getColumn(i).getReal()).sum();
    }
    public double sumOfImaginaryInRow(int row) {
        return IntStream.range(0, rows.get(row).size()).mapToDouble(i->rows.get(row).getColumn(i).getImaginary()).sum();
    }

    public double sumOfDiagonalReal(int numOfColumns) {
        return IntStream.range(0, numOfColumns).mapToDouble(i -> rows.get(i).getColumn(i).getReal()).sum();
    }
    public double sumOfDiagonalImaginary(int numOfColumns) {
        return IntStream.range(0, numOfColumns).mapToDouble(i -> rows.get(i).getColumn(i).getImaginary()).sum();
    }
}