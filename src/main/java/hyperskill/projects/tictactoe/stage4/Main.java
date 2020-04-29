package hyperskill.projects.tictactoe.stage4;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");

        String input = scanner.nextLine();

        TicTacToe ticTacToe = new TicTacToe(3);
        int pos = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                ticTacToe.setBox(i, j, BoxState.fromChar(input.charAt(pos++)).orElse(BoxState.EMPTY));
            }
        }
        ticTacToe.draw();        
        boolean play = true;
        while (play) {

            System.out.printf("Enter the coordinates: ");
            String[] number = scanner.nextLine().split("\\s+");
            try {
                int y = Integer.parseInt(number[0]);
                int x = xChanger(Integer.parseInt(number[1]));
                System.out.println("y= " + y + "; x= " + x);
                if (ticTacToe.checkAxis(x) && ticTacToe.checkAxis(y)) {
                    if (ticTacToe.isEmptyState(x, y)) {
                        ticTacToe.setBox(x, y, BoxState.X);
                        ticTacToe.draw();
                        play = false;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        scanner.close();
    }

    private static int xChanger(int x) {
        switch (x) {
            case 1:
                return 3;
            case 3:
                return 1;
            default:
                return 2;
        }
    }
}

class TicTacToe {
    private BoxState[][] board;
    private final int size;
    private BoxState lastPlayer;

    TicTacToe(int size) {
        this.size = size;

        this.lastPlayer = BoxState.EMPTY;
        this.board = new BoxState[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.board[x][y] = BoxState.EMPTY;
            }
        }
    }

    public BoxState nextPlayer() {
        if (lastPlayer == BoxState.X) {
            return BoxState.O;
        }
        return BoxState.X;
    }

    public boolean checkAxis(int axis) {
        return axis >= 1 || axis <= size;
    }

    void setBox(int x, int y, BoxState state) {
        board[x - 1][y - 1] = state;
        lastPlayer = nextPlayer();
    }

    public boolean isEmptyState(int x, int y) {
        if (board[x - 1][y - 1] == BoxState.EMPTY) {
            return true;
        }
        return false;
    }

    public void draw() {
        for (int i = 0; i < Math.pow(size, 2); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getState() + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    boolean checkNotFinished() {
        return Arrays.stream(board).flatMap(Arrays::stream).anyMatch(s -> s.equals(BoxState.EMPTY));
    }

    boolean isWin(BoxState state) {
        if (state != BoxState.EMPTY) {
            int playerTotal = state.getState() * 3;
            int diagonal1 = 0;
            int diagonal2 = 0;
            for (int i = 0; i < size; i++) {
                diagonal1 += board[i][i].getState();
                diagonal2 += board[i][size - i - 1].getState();
                if ((board[0][i].getState() + board[1][i].getState() + board[2][i].getState()) == playerTotal) {
                    return true;
                } else if ((board[i][0].getState() + board[i][1].getState() + board[i][2].getState()) == playerTotal) {
                    return true;
                }
            }
            return diagonal1 == playerTotal || diagonal2 == playerTotal;
        }
        return false;
    }

    boolean checkToManyMoves() {
        long numOfX = Arrays.stream(board).flatMap(Arrays::stream).filter(s -> s.equals(BoxState.X)).count();
        long numOfO = Arrays.stream(board).flatMap(Arrays::stream).filter(s -> s.equals(BoxState.O)).count();
        return Math.abs(numOfO - numOfX) > 1;

    }

}

enum BoxState {
    EMPTY('_'),
    X('X'),
    O('O');
    private final char state;

    BoxState(char state) {
        this.state = state;
    }

    public char getState() {
        return state;
    }

    public static Optional<BoxState> fromChar(char c) {
        return Arrays.stream(values()).filter(e -> e.name().equals(String.valueOf(c))).findFirst();
    }
}