package hyperskill.projects.linear.stage5;

import java.util.ArrayList;
import java.util.List;

class Result {
    private List<ComplexNumber> result = new ArrayList<>();

    void add(ComplexNumber value) {
        result.add(value);
    }

    ComplexNumber get(int index) {
        return result.get(index);
    }

    void switchResult(int from, int to) {
        ComplexNumber temp = result.get(from);
        result.set(from, result.get(to));
        result.set(to, temp);
    }

    public void update(int index, ComplexNumber value) {
        result.set(index, value);

    }
}