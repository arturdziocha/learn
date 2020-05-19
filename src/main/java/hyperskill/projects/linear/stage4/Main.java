package hyperskill.projects.linear.stage4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    }
}

class Matrix {
    private int vars;
    private int equations;
    private Row[] rows;
    private List<Character> variables;

    Matrix(int vars, int equations) {
        this.vars = vars;
        this.equations = equations;
        this.rows = new Row[equations];
        variables = IntStream
                .rangeClosed('a', 'a' + vars)
                .mapToObj(c -> (char) c).collect(Collectors.toCollection(ArrayList::new));
    }
}

class Row {
    int variables;
    Map<Integer, Double> map;
    double[] row;

    Row(int variables) {
        this.variables = variables;
        this.row = new double[variables];
    }

    public double get(int variable) {
        return row[variable];
    }

    public void set(int variable, double value) {
        row[variable] = value;
    }

    public double[] getRow() {
        return row;
    }

    public int getVariables() {
        return variables;
    }
}

class LinearSolution {
    Matrix matrix;

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int variables = scanner.nextInt();
        int equations = scanner.nextInt();


    }
}
