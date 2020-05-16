package hyperskill.projects.linear.stage3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix();
        // matrix.read(args[1]);
        matrix.read("src/main/java/hyperskill/projects/linear/stage3/in.txt");
        // matrix.print();
        matrix.solve();
        // matrix.write(args[3]);
        matrix.write("src/main/java/hyperskill/projects/linear/stage3/out.txt");
    }
}

class Matrix {
    private double[][] matrix;
    private int n;

    public void read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        n = Integer.parseInt(scanner.nextLine());
        matrix = new double[n][];
        IntStream
                .range(0, n)
                .forEach(i -> matrix[i] = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToDouble(Double::valueOf)
                        .toArray());
        scanner.close();
    }

    public void write(String filename) throws FileNotFoundException, IOException {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            double[] toPrint = IntStream.range(0, n).mapToDouble(s -> matrix[s][n]).toArray();
            System.out.println();
            System.out
                    .println("The solution is: ("
                            + Arrays.stream(toPrint).boxed().map(String::valueOf).collect(Collectors.joining(", "))
                            + ")");
            Arrays.stream(toPrint).forEach(writer::println);
            System.out.println("Saved to file " + filename);
        }
    }

    void print() {
        IntStream.range(0, n).forEach(s -> System.out.println(Arrays.toString(matrix[s])));
        System.out.println();
    }

    void solve() {
        System.out.println("Start solving the equation.");
        IntStream.range(0, n).forEach(this::st1);
        for (int row = n - 1; row > 0; row--) {
            st2(row);
        }
    }

    void st1(int row) {
        if (matrix[row][row] == 0) {

        }
        if (matrix[row][row] != 1) {
            double k = matrix[row][row];
            IntStream.range(row, matrix[row].length).forEach(i -> matrix[row][i] /= k);
            System.out.println((1 / k) + " * R" + (row + 1) + " -> R" + (row + 1));
            // print();
        }
        IntStream.range(row + 1, n).forEach(i -> {
            double k = -matrix[i][row];
            IntStream.range(row, n + 1).forEach(j -> {
                matrix[i][j] += k * matrix[row][j];
            });
            System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
            // print();
        });
    }

    void st2(int row) {
        for (int i = row - 1; i >= 0; i--) {
            double k = -matrix[i][row];
            for (int col = n; col >= 0; col--) {
                matrix[i][col] += k * matrix[row][col];
            }
            System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
            // print();
        }
    }

    void stage1(int row) {
        print();
        System.out.println();
        IntStream.range(row + 1, n).forEach(i -> {
            double k = matrix[i][row];
            IntStream.range(row, n + 1).forEach(col -> matrix[i][col] -= k * matrix[row][col]);
        });

    }
}