package hyperskill.projects.linear.stage3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Matrix matrix = new Matrix();
        matrix.read("src/main/java/hyperskill/projects/linear/stage3/in.txt");
        matrix.print();
        matrix.solve();
        matrix.print();
    }
}

class Matrix {
    private double[][] matrix;
    private int n;

    public void read(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
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

    void print() {
        IntStream.range(0, n).forEach(s -> System.out.println(Arrays.toString(matrix[s])));
    }

    void solve() {
        System.out.println("Start solving the equation.");
        if (matrix[0][0] != 1) {
            double k = matrix[0][0];
            IntStream.range(1, matrix[0].length).forEach(i -> matrix[0][i] /= k);
            matrix[0][0] = 1;
            System.out.printf("1 / %1.0f * R1 -> R1", k);
            System.out.println();
        }
        IntStream.range(0, n).forEach(this::stage1);
    }

    void stage1(int row) {
        if (matrix[row][row] != 0) {
            IntStream.range(row + 1, matrix[row].length).forEach(col -> matrix[row][col] /= matrix[row][row]);
            System.out.println();
            matrix[row][row] = 1;
        }
        print();
        System.out.println();
        IntStream.range(row + 1, n).forEach(i -> {
            double k = matrix[i][row];
            IntStream.range(row, n + 1).forEach(col -> matrix[i][col] -= k * matrix[row][col]);
        });

    }
}