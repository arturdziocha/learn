package hyperskill.projects.linear.stage3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        Matrix matrix = new Matrix(lines);
        for (int i = 0; i < lines; i++) {
            matrix.addRow(i, scanner.nextLine().split(" "));
        }
    }
}

class Matrix {
    private Row[] rows;
    private final int n;

    Matrix(int n) {
        this.n = n;
        this.rows = new Row[n];
    }

    public void addRow(int i, String[] arr) {

    }
}

class Row {
    private double row[];
    private final int n;

    Row(int n) {
        this.n = n;
        this.row = new double[n];
    }
}