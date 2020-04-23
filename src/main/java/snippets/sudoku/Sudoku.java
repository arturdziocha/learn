package snippets.sudoku;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * https://leetcode.tgic.me/valid-sudoku/index.html
 * 
3
5 8 9 6 7 4 2 1 3
7 4 3 1 8 2 9 5 6
1 2 6 9 5 3 8 7 4
9 3 5 4 2 1 7 6 8
4 1 2 8 6 7 3 9 5
6 7 8 3 9 5 1 4 2
8 6 4 2 1 9 5 3 7
3 9 7 5 4 8 6 2 1
2 5 1 7 3 6 4 8 9
Sample Output 1:

YES
Sample Input 2:

2
1 1 2 2
1 1 2 2
3 3 4 4
3 3 4 4
Sample Output 2:

NO
Sample Input 3:

1
1
Sample Output 3:

YES

2
1 2 3 4
2 3 4 1
3 4 1 2
4 1 2 3
NO

 */
public class Sudoku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int n = Integer.parseInt(scanner.nextLine());
        int size = n * n;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(isValidSudoku(matrix, n) ? "YES" : "NO");
        scanner.close();
    }

    public static boolean isValidSudoku(int[][] board, int n) {
        int size = (int) n * n;
        return isValidBox(board, n, size) && isValidRowCol(board, size);
    }

    private static boolean isValidRowCol(int[][] board, int size) {
        int x;
        int y;
        for (x = 0; x < size; x++) {
            HashSet<Integer> col = new HashSet<>();
            HashSet<Integer> row = new HashSet<>();
            for (y = 0; y < size; y++) {
                int c = board[x][y];
                int r = board[y][x];
                if (c > 0 && c < size + 1) {
                    if (col.contains(c)) {
                        return false;
                    }
                    col.add(c);
                } else {
                    return false;
                }
                if (r > 0 && r < size + 1) {
                    if (row.contains(r))
                        return false;
                    row.add(r);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidBox(int[][] board, int n, int size) {
        int x;
        int y;
        for (x = 0; x < size; x += n) {
            for (y = 0; y < size; y += n) {
                Set<Integer> block = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int c = board[x + j][y + i];
                        if (block.contains(c)) {
                            return false;
                        }
                        block.add(c);
                    }
                }
            }
        }
        return true;
    }

    public void hyperskillSudoku() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxNum = n * n;

        int[][] table = new int[maxNum][maxNum];
        boolean solved = true;

        for (int row = 0; row < maxNum; row++) {
            for (int col = 0; col < maxNum; col++) {
                table[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < maxNum; row++) {
            for (int col = 0; col < maxNum; col++) {
                if (table[row][col] <= 0 || table[row][col] > maxNum) {
                    solved = false;
                }

                for (int i = 0; i < maxNum; i++) {
                    if (row != i && table[row][col] == table[i][col]) {
                        solved = false;
                    }

                    if (col != i && table[row][col] == table[row][i]) {
                        solved = false;
                    }
                }

                int startRow = row - (row % n);
                int startCol = col - (col % n);

                for (int r = startRow; r < startRow + n; r++) {
                    for (int c = startCol; c < startCol + n; c++) {
                        if ((row != r || col != c) && table[row][col] == table[r][c]) {
                            solved = false;
                        }
                    }
                }
            }
        }

        System.out.println(solved ? "YES" : "NO");

    }
}
