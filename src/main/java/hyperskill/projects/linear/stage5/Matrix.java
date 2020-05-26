package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;

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
        rows.forEach(r -> r.switchRow(from, to));
    }
}