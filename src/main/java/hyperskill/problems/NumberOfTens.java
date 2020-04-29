package hyperskill.problems;

import java.util.Scanner;
/*
 * Integer types and operations → The number of tens
Failure rate is 55%
Medium

5 minutes
2614 users solved this problem. Latest completion was about 6 hours ago .
Code Challenge — Write a program
Given a non-negative integer N (0 ≤ N ≤ 1000000), find the number of tens in it (i.e. next to last digit of the number). If there is no next to last digit, you can consider that the number of tens equals to zero.

Sample Input 1:

173
Sample Output 1:

7
 */
public class NumberOfTens {

    public static void main(String[] args) {       
        System.out.print(new Scanner(System.in).nextInt() % 100 / 10);

    }

}
