package hyperskill.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Write a program, which inputs the rectangular matrix from a sequence of lines, ending with a line, containing the only word "end" (without the quotation marks).

The program should output the matrix of the same size, where each element in the position (i, j) is equal to the sum of the elements from the first matrix on the positions (i-1, j)(i+1, j)(i, j-1), (i, j+1). Boundary elements have neighbors on the opposite side of the matrix. In the case of one row or column, the element itself may be its neighbor.

Sample Input 1:

9 5 3
0 7 -1
-5 2 9
end
Sample Output 1:

3 21 22
10 6 19
20 16 -1
Sample Input 2:

1
end
Sample Output 2:

4

*
1 2 3 4
end
 */
public class SumOfNeighbors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        List<Integer> matrixList = new ArrayList<>();
        int howMany = 0;
        while (!"end".equals(line = scanner.nextLine())) {
            matrixList.addAll(
                    Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .collect(Collectors.toCollection(ArrayList::new)));
            howMany++;
        }
        scanner.close();
        int[][] matrix = new int[howMany][matrixList.size() / howMany];
        int iter = 0;
        for (int i = 0; i < howMany; i++) {
            for (int j = 0; j < matrixList.size() / howMany; j++) {
                matrix[i][j] = matrixList.get(iter);
                iter++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = 0;
                int x = i - 1 < 0 ? matrix.length - 1 : i - 1;
                int y = j;
                val += matrix[x][y];
                x = i + 1 == matrix.length ? 0 : i + 1;
                val += matrix[x][y];
                x = i;
                y = j - 1 < 0 ? matrix[i].length - 1 : j - 1;
                val += matrix[x][y];
                y = j + 1 == matrix[i].length ? 0 : j + 1;
                val += matrix[x][y];
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
