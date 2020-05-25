package hyperskill.projects.linear.stage4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
    String from = "";
    String to = "";

    for (int i = 0; i < args.length; i += 2) {
        if ("-in".equals(args[i])) {
            from = args[i + 1];
        } else {
            to = args[i + 1];
        }
    }

    // there is probably a design patter for that, but...
    toFile(rref(fromFile(from)), to);
}


    /**
     * Returns an augmented matrix from fileName as double[][]
     *
     * @param  fileName read data from file if exists
     * @return          rref augmented matrix
     */
    static double[][] fromFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        String[] initValues = sc.nextLine().split(" ");
        int initColumns = Integer.parseInt(initValues[0]);
        int initRows = Integer.parseInt(initValues[1]);

        double[][] augmentedMatrix = new double[initRows][initColumns + 1];

        // fill the augmented matrix
        for (int i = 0; i < initRows; i++) {
            for (int j = 0; j < initColumns + 1; j++) {
                augmentedMatrix[i][j] = sc.nextDouble();
            }
        }
        sc.close();

        return augmentedMatrix;
    }


    /**
     * Returns a solution if exists or appropriate message
     * Saves to the file
     *
     * @param augmentedMatrix rref matrix
     * @param fileName        write data to file
     */
    static void toFile(double[][] augmentedMatrix, String fileName) throws IOException {
        File file = new File(fileName);
        int matrixLength = augmentedMatrix.length;
        boolean inf = false;
        boolean nosol = false;

        // check if no solutions
        for (double[] k : augmentedMatrix) {
            int cnt = 0;
            for (double v : k) {
                if (v == 0) {
                    cnt += 1;
                }
            }
            if (cnt == k.length) {
                matrixLength -= 1;
            }
            if (k[k.length - 1] != 0 && cnt == k.length - 1) {
                nosol = true;
                break;
            }
        }

        // check if more than one solution
        if (augmentedMatrix.length - matrixLength > 1 ||
                matrixLength < augmentedMatrix[0].length - 1) {
            inf = true;
        }

        // write solution to the file
        String[] tmp = new String[matrixLength];
        try (PrintWriter printWriter = new PrintWriter(file)) {
            if (nosol) {
                System.out.println("No solutions");
                printWriter.println("No solutions");
            } else if (inf) {
                System.out.println("Infinitely many solutions");
                printWriter.println("Infinitely many solutions");
            } else {
                for (int i = 0; i < matrixLength; i++) {
                    printWriter.println(augmentedMatrix[i][augmentedMatrix[0].length - 1]);
                    tmp[i] = Double.toString(augmentedMatrix[i][augmentedMatrix[0].length - 1]);
                }
                System.out.println("The solution is: (" + String.join(", ", tmp) + ")");
            }
        }

        System.out.println("Saved to file " + fileName);
    }

    /**
     * Performing rref on a given augmentedMatrix
     *
     * @param augmentedMatrix matrix
     * @return augmentedMatrix in rref form
     */
    static double[][] rref(double[][] augmentedMatrix) {
        System.out.println("Start solving the equation.");
        int rows = augmentedMatrix.length;
        int columns = augmentedMatrix[0].length;
        double multiplier;

        int pivot = 0;
        for (int c = 0; c < columns - 1; c++) {
            int r = pivot;
            int row = r;

            while (row < rows - 1 && augmentedMatrix[row][c] == 0.0) {
                row += 1;
            }

            if (augmentedMatrix[row][c] != 0.0) {
                pivot += 1;

                if (r != row) {
                    double[] aux = augmentedMatrix[r];
                    augmentedMatrix[r] = augmentedMatrix[row];
                    augmentedMatrix[row] = aux;
                    System.out.printf("R%d <-> R%d%n", r, row);
                }

                multiplier = augmentedMatrix[r][c];
                if (multiplier != 1 && multiplier != 0) {
                    String ph = new DecimalFormat("#.##").format(1 / multiplier);
                    System.out.printf("%s * R%d -> R%d%n", ph, r + 1, r + 1);
                    for (int q = 0; q < columns; q++) {
                        augmentedMatrix[r][q] /= multiplier;
                    }
                }

                for (int z = r + 1; z < rows; z++) {
                    multiplier = -augmentedMatrix[z][c];
                    if (multiplier != 1 && multiplier != 0) {
                        String ph = new DecimalFormat("#.##").format(multiplier);
                        System.out.printf("%s * R%d + R%d -> R%d%n", ph, r + 1, z + 1, z + 1);

                        for (int k = 0; k < columns; k++) {
                            augmentedMatrix[z][k] += augmentedMatrix[r][k] * multiplier;
                        }
                    }
                }
            }
        }

        for (int i = rows - 2; i > -1; i--) {
            for (int j = i; j > -1; j--) {
                if (augmentedMatrix[j][i + 1] == 0) {
                    continue;
                }

                multiplier = -augmentedMatrix[j][i + 1];
                String ph = new DecimalFormat("#.##").format(multiplier);
                System.out.printf("%s * R%d + R%d -> R%d%n", ph, i + 2, j + 1, j + 1);

                for (int k = 0; k < columns; k++) {
                    augmentedMatrix[j][k] += augmentedMatrix[i + 1][k] * multiplier;
                }
            }
        }

        return augmentedMatrix;
    }
}