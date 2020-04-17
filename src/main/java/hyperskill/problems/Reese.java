package hyperskill.problems;

import java.util.Scanner;

/*
 * Groundhogs like to throw fun parties, and at their parties, they like to eat Reese's peanut butter cups. But not too many of them, or they feel sick! A successful groundhog party will have between 10 and 20 Reese's peanut butter cups, inclusive unless it is the weekend, in which case they will need 15 to 25 Reese's peanut butter cups, inclusive.

 

Write a Java program that reads two values:

the first is the number of Reese's peanut butter cups;
the second is a boolean representing whether it is the weekend.
The program must print the boolean value - the party is successful or not.

Sample Input 1:

5 true
Sample Output 1:

false
Sample Input 2:

16 false
Sample Output 2:

true
 */
public class Reese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int peanuts = scanner.nextInt();
        final boolean isWeekend = scanner.nextBoolean();
        final boolean goodForNormalDays = peanuts >= 10 && peanuts <= 20 && !isWeekend;
        final boolean goodForWeekend = peanuts >= 15 && peanuts <= 25 && isWeekend;

        System.out.println(goodForNormalDays || goodForWeekend);
        scanner.close();
    }
}
