package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class GaussianElimination {
    private final Matrix matrix = new Matrix();
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int[] w = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        howManyColumns = w[0];
        howManyEquations = w[1];

        column = new Column(howManyColumns);
        for (int i = 0; i < howManyEquations; i++) {
            Row row = new Row();
            String[] r = scanner.nextLine().split("\\s+");
            System.out.println(Arrays.toString(r));

            for (int j = 0; j < howManyColumns; j++) {
                row.add(new ComplexNumber(r[j]));
            }
            result.add(new ComplexNumber(r[howManyColumns]));
            matrix.add(row);
        }
        scanner.close();
    }

    public String getSolution() {
        return solution;
    }

    public void write(File file) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println();
            System.out.println("The solution is: " + solution.replace("\n", ", "));
            writer.print(solution);
            System.out.println("Saved to file " + file.getAbsolutePath());
        }
    }
}
