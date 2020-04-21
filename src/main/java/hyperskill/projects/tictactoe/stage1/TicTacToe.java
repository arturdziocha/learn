package hyperskill.projects.tictactoe.stage1;

public class TicTacToe {
    public static void main(String[] args) {
        int tableSize = 3;
        char[][] table = new char[tableSize][tableSize];
        char lastInput = 'X';
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                System.out.print(lastInput);
                lastInput = lastInput == 'X' ? 'O' : 'X';
            }
            System.out.println();
        }
    }
}
