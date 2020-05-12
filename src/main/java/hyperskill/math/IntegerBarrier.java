package hyperskill.math;

import java.util.Scanner;

/*
 * Write a program that reads a sequence of integer numbers in a loop and adds up all numbers. If a new number is equal to 0, the program must stop the loop and output the accumulated sum. When the sum is equal or exceeded 1000 (the barrier), the program should also stop and output the value equal to sum - 1000.

Note, the input can contain extra numbers. Just ignore them.

Sample Input 1:

800
101
102
300
0
Sample Output 1:

3
Sample Input 2:

103
105
109
0
1000
Sample Output 2:

317
 */
public class IntegerBarrier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int number;
        int i = 0;
        int sum = 0;
        while (scanner.hasNextInt()) {
            i++;
            number = scanner.nextInt();
            sum += number;
            if (sum >= 1000 || number == 0)
                break;
        }
        scanner.close();
        System.out.println(sum >= 1000 ? i : sum - 1000);
    }
}
