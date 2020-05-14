package hyperskill.projects.linear.stage3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Matrix matrix = new Matrix();
        matrix.read("src/main/java/hyperskill/projects/linear/stage3/in.txt");
        matrix.print();
    }
}

class Matrix {
    private Row[] matrix;
    private int n;

    public void read(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        n = Integer.parseInt(scanner.nextLine());
        
        scanner.close();
    }

    void print() {
        IntStream.range(0, n).forEach(System.out::println);
    }
}

class Row {
    private double[] row;

    Row(int size) {
        this.row = new double[size];
    }

    void addValue(int num, double value) {
        this.row[num] = value;
    }

    @Override
    public String toString() {
        return Arrays.stream(row).boxed().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public static Row parse(String string) {
        double[] arr = Stream.of(string.split(" ")).mapToDouble(Double::valueOf).toArray();
        Row row = new Row(arr.length);
        IntStream.range(0, arr.length).forEach(i -> row.addValue(i, arr[i]));
        return row;

    }

}