package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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