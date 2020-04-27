package hyperskill.projects.tictactoe.stage3;

import java.util.Optional;
import java.util.Scanner;

public class TicTacToe {
    private State[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("add");

        char[] arr = "O_OXXO_XX".toCharArray();
        scanner.close();
        TicTacToe ticTacToe = new TicTacToe();

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println(arr[(i-1)*3+j-1]);
                    ticTacToe.setBox(i-1, j-1, arr[(i-1)*3+j-1]);
            }
        }
        System.out.println(arr);
        System.out.println(ticTacToe.board);
    }

    private void setBox(int x, int y, char player) {
        if (board[x][y] != State.EMPTY) {
            throw new RuntimeException("Box is busy");
        } else {
            State state = Optional.of(State.valueOf(String.valueOf(player))).orElse(State.EMPTY);
            board[x][y] = state;
        }
    }

    private void draw() {
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i]);
            // System.out.println(String.format("| %c %c %c |", board[i],
            // board[i + 1], board[i + 2]));
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
    }

    enum State {
        EMPTY('_'),
        X('X'),
        Y('Y');
        private final char state;

        State(char state) {
            this.state = state;
        }

        public char getState() {
            return state;
        }
    }
}

interface Game {
    void play();
}

class Field {
    private state[][] field;
    private int fieldSize;

    public Field(int fieldSize) {
        field = new state[fieldSize][fieldSize];
        this.fieldSize = fieldSize; // initialize
        for (int i = 1; i <= fieldSize; i++) {
            for (int j = 1; j <= fieldSize; j++) {
                field[i][j] = state.EMPTY;
            }
        }
    }

    enum state {
        EMPTY,
        X,
        O
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void playO(int xAxis, int yAxis) {
        field[xAxis][yAxis] = state.O;
    }

    public void playX(int xAxis, int yAxis) {
        field[xAxis][yAxis] = state.X;
    }

    @Override
    public String toString() {
        String bar = horizontalBar();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bar);
        for (state[] states : field) {
            stringBuilder.append("| ");
            for (state s : states) {
                char endSpace = ' ';
                stringBuilder.append(stateToString(s));
                stringBuilder.append(endSpace);
            }
            stringBuilder.append('|');
            stringBuilder.append('\n');
        }
        stringBuilder.append(bar);
        return stringBuilder.toString();
    }

    private char stateToString(state s) {
        switch (s) {
            case O:
                return 'O';
            case X:
                return 'X';
            default:
                return '_';
        }
    }

    private String horizontalBar() {
        char[] barChar = new char[2 * fieldSize + 4];
        for (int i = 0; i < 2 * fieldSize + 3; i++) {
            barChar[i] = '-';
        }
        barChar[2 * fieldSize + 3] = '\n';
        return new String(barChar);
    }
}

class MainGame implements Game {
    private Field field;
    private int gameSize;

    MainGame(int size) {
        field = new Field(size);
        gameSize = field.getFieldSize();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        char[] inputs = scanner.next().toCharArray();
        int position = 0;
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                switch (inputs[position++]) {
                    case 'O':
                        field.playO(i, j);
                        break;
                    case 'X':
                        field.playX(i, j);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.print(field);
    }
}

class Main {
    public static void main(String[] args) {
        Game game = new MainGame(3);
        game.play();
    }
}
