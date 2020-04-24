package hyperskill.arrays;

import java.util.Scanner;

/*
 * The cinema has n rows, each row consists of m seats (n and m do not exceed 20). The two-dimensional matrix stores the information on the sold tickets, number 1 means that the ticket for this place is already sold, the number 0 means that the place is available. You want to buy k tickets to the neighboring seats in the same row. Find whether it can be done.

Input data format

On the input, the program gets the number of n rows and m seats. Then, there are n lines, each containing m numbers (0 or 1) separated by spaces. The last line contains a number k.

Output data format

The program should output the number of the row with k consecutive available seats. If there are several rows with k available seats, output the first row with these seats. If there is no such a row, output the number 0.

Sample Input 1:

3 4
0 1 0 1
1 1 0 1
1 0 0 1
2
Sample Output 1:

3
Sample Input 2:

3 3
0 1 0
1 0 0
1 1 1
3
Sample Output 2:

0
 */
public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String[] m = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(m[0]);
        int seatsInRow = Integer.parseInt(m[1]);
        int[][] cinema = new int[rows][seatsInRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int tickets = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= seatsInRow - tickets; j++) {
                int freeSeats = 0;
                for (int k = 0; k < tickets; k++) {
                    if (cinema[i][j + k] == 0) {
                        freeSeats++;
                    }
                }
                if (freeSeats == tickets) {
                    System.out.print(i + 1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
}
