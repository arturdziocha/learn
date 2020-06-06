package hyperskill.arrays;

public class DeterminantOfMatrix {   

    public static long determinant(long[][] matrix) {
        int size = matrix.length;
        if (size == 2) {            
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        } else {
            long s = 0;
            for (int i = 0; i < size; i++) {
                if (i % 2 == 0) {
                    s += matrix[0][i] * determinant(cut(matrix, i));
                } else {
                    s -= matrix[0][i] * determinant(cut(matrix, i));
                }
            }
            return s;
        }
    }

    private static long[][] cut(long[][] matrix, int withoutColumn) {
        int size = matrix.length;
        long[][] m = new long[size - 1][size - 1];

        for (int i = 0; i < size - 1; i++) {
            int s = 0;
            for (int j = 0; j < size; j++) {
                if (j != withoutColumn) {
                    m[i][s] = matrix[i + 1][j];
                    s++;
                }
            }
        }
        // print(m);
        return m;
    }

}
