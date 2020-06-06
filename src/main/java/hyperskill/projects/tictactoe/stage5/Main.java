package hyperskill.projects.tictactoe.stage5;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe(3);
        do {
            ticTacToe.print();
            System.out.println("Enter the coordinates: ");
            // String[] number = scanner.nextLine().split("\\s+");
            String numbers = scanner.nextLine();
            Scanner scInts = new Scanner(numbers);
            try {
                int y = scInts.nextInt();
                int x = scInts.nextInt();
                ticTacToe.play(x, y);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
            scInts.close();
        } while (!ticTacToe.isFinished());
        scanner.close();

    }

}

class TicTacToe {
    private BoxState[][] board;
    private BoxState lastPlayer;
    private final int size;
    boolean finished;

    public TicTacToe(int size) {
        this.size = size;
        this.lastPlayer = BoxState.EMPTY;

        this.board = IntStream
                .range(0, size)
                .mapToObj(x -> IntStream.range(0, size).mapToObj(y -> BoxState.EMPTY).toArray(BoxState[]::new))
                .toArray(BoxState[][]::new);
        finished = false;
    }

    public void play(int x, int y) {

        if (checkAxis(x, y)) {
            System.out.println("Coordinates should be from 1 to 3!");

        } else {
            x = xChanger(x) - 1;
            y = y - 1;
            if (isBusy(x, y)) {
                System.out.println("This cell is occupied! Choose another one!");

            } else {
                lastPlayer = nextPlayer();
                setBox(x, y);
                if (isWin(lastPlayer)) {
                    finished = true;
                    // print();
                    System.out.println(lastPlayer + " wins");
                } else if (checkFinished()) {
                    finished = true;
                    // print();
                    System.out.println("Draw");
                }
            }
        }

    }

    private boolean checkAxis(int x, int y) {
        return x < 1 || x > size || y < 1 || y > size;
    }

    private boolean isBusy(int x, int y) {
        return !board[x][y].equals(BoxState.EMPTY);
    }

    private BoxState nextPlayer() {
        if (lastPlayer.equals(BoxState.X)) {
            return BoxState.O;
        }
        return BoxState.X;
    }

    private void setBox(int x, int y) {
        board[x][y] = lastPlayer;
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

    boolean checkFinished() {
        return Arrays.stream(board).flatMap(Arrays::stream).noneMatch(s -> s.equals(BoxState.EMPTY));
    }

    public boolean isFinished() {
        return finished;
    }

    public void print() {
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

    private int xChanger(int x) {
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
