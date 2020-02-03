package snippets.colatz;

import java.util.Scanner;

public class CollatzConjecture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set number: ");
        int n = scanner.nextInt();
        /*while(number>1) {
            System.out.print(number + " ");
            if(number%2==0) {
                number = number/2;
            }
            else {
                number =number*3+1;
            }
        }   */ 
        int i = 0;
        // The following has to occur inside a loop or it'll only occur once
        while (n > 1)
        {
           // The following is what's known as "ternary form" - if the first statement is true, it'll assign the first value. Otherwise it assigns the first value.
           // For example,
           // int a = (1 == 2 ? 10 : 20);
           // will equal 20
           n = (n % 2 == 0) ? (n / 2) :  (3 * n + 1); 
           i++;
           System.out.print(n+" ");
         }
        

    }

}
