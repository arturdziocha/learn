package hyperskill.projects.linear.stage3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.read(args[1]);
    }
}

class Matrix {
    private double[][] rows;
    private int n;

    public void read(String file) {
        Scanner scanner = new Scanner(file);
        n = scanner.nextInt();
        rows = new double[n][];
        IntStream
                .range(0, n)
                .forEach(row -> rows[row] = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToDouble(Double::valueOf)
                        .toArray());
    }
}

class Row {
    private double[] row;

    Row(double[] row) {
        this.row = row;
    }

}