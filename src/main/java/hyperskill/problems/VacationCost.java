package hyperskill.problems;

import java.util.Scanner;

/*
 * Write a program that will help people who are going on vacation. The program should calculate the total required sum (e.g. $) of money to have a good rest for a given duration.

There are four parameters which have to be considered:
duration in days
total food cost per a day
one-way flight cost
cost of one night in a hotel (the number of nights equal duration minus one)
Read values of these parameters from the standard input and then print the result.

Hint  Do not forget to consider the flight back
Sample Input 1:

7 30 100 40
Sample Output 1:

650
 */
public class VacationCost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int days = scanner.nextInt();
        int foodCost = scanner.nextInt();
        int flightCost = scanner.nextInt();
        int hotel = scanner.nextInt();
        scanner.close();
        int sum = days * foodCost + (days - 1) * hotel + 2 * flightCost;
        System.out.println(sum);

    }

}
