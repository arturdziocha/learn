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
        System.out.println();
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
        print();
        IntStream.range(0, n).forEach(this::st1);
        for (int row = n - 1; row > 0; row--) {
            for (int col = row; col > 0; col--) {
                matrix[col][n] -= matrix[col][row]*matrix[row][n];
            }
            System.out.println(row);
            print();
        }
    }

    void st1(int row) {
        if (matrix[row][row] == 0) {

        }
        if (matrix[row][row] != 1) {
            double k = matrix[row][row];
            IntStream.range(row, matrix[row].length).forEach(i -> matrix[row][i] /= k);
            System.out.println((1 / k) + " * R" + (row + 1) + " -> R" + (row + 1));
            print();
        }
        IntStream.range(row + 1, n).forEach(i -> {
            double k = -matrix[i][row];
            IntStream.range(row, n + 1).forEach(j -> {
                matrix[i][j] += k * matrix[row][j];
            });
            System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
            print();
        });

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