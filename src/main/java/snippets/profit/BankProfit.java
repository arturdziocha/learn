package snippets.profit;

import java.util.Scanner;

/*
Ann put MM money in the bank. The bank increases Ann's deposit by PP percent every year. Ann wants to know how many
years should pass until her deposit in the bank reaches KK money. Can you help her to answer this question?
Input contains three integers - M, P, KM,P,K. It is guaranteed that all numbers are positive and K \geq MK≥M. Output
the answer to Ann's question.*/
/*
Sample Input 1:
1 100 8
Sample Output 1
3
Sample Input 2:
100 15 120
Sample Output 2
2
*/
public class BankProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add numbers");
        double deposit = scanner.nextInt();
        double percent = scanner.nextInt();
        double value = scanner.nextInt();
        int years = 0;
        while (deposit < value) {
            deposit += deposit * percent / 100;
            years++;
        }
        System.out.println(years);
    }
}
