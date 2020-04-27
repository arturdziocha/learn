package hyperskill.projects.tictactoe.stage2;

import java.util.Scanner;

/*
 * In this stage, you should write a program that reads 9 symbols from the input and writes an appropriate 3x3 field. Elements of the field can contain only 'X', 'O' and '_' symbols.

Note, that field has a specific format and should start and end with ---------, all lines in between should start and end with '|' symbol and everything in the middle should be separated with a single space.  

Examples

Examples below show how your output should look.

Example 1:

Enter cells: O_OXXO_XX
---------
| O _ O |
| X X O |
| _ X X |
---------
Example 2: 

Enter cells: OXO__X_OX
---------
| O X O |
| _ _ X |
| _ O X |
---------
Example 3: 

Enter cells: _XO__X___
---------
| _ X O |
| _ _ X |
| _ _ _ |
---------
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        char[] arr = scanner.nextLine().toCharArray();      
        scanner.close();
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 9; i+=3) {            
            System.out.println(String.format("| %c %c %c |", arr[i], arr[i+1], arr[i+2]));
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
    }
}
