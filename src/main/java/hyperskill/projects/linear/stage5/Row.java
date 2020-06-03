package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Row {
    private final List<ComplexNumber> row = new ArrayList<>();

    public void updateColumn(int index, ComplexNumber value) {
        this.row.set(index, value);

    }

    void add(ComplexNumber value) {
        row.add(value);
    }

    public ComplexNumber getColumn(int index) {
        return row.get(index);
    }

    public List<ComplexNumber> getAll() {
        return row;
    }

    int size() {
        return row.size();
    }

    void switchColumn(int from, int to) {
        ComplexNumber temp = row.get(from);
        row.set(from, row.get(to));
        row.set(to, temp);
    }

    int sumOfRealZeroInRow() {
        return row.stream().filter(r -> r.getReal() == 0.0).map(i -> 1).reduce(0, Integer::sum);
    }

}