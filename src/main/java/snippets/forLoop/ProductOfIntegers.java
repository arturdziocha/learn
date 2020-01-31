package snippets.forLoop;

import java.util.Scanner;

/*
 * Write a program that prints the product of all integer numbers from a to b (a
 * < b). Include a and exclude b from the product.
 * 
 * Sample Input 1: 1 2 
 * Sample Output 1: 1 
 * Sample Input 2: 100 105 
 * Sample Output 2: 11035502400
 */
public class ProductOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add numbers");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        long sum = 1;
        for (; start < end; start++) {
            sum *= start;
        }
        System.out.println(sum);
        scanner.close();
    }
}
