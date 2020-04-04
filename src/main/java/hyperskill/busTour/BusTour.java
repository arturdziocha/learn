package hyperskill.busTour;

import java.util.Scanner;

/*A bus tour of Europe has been very successful. Due to an increase in the number of people that want to go on a tour, the tour company decided to increase the height of the bus. The new height of the bus is exactly N centimeters.

But the tour’s route runs under a lot of bridges, and there is a chance that the bus will crash into one of these bridges. Can you find out if this will happen?

The first line of the input contains the height of the bus and number of bridges under which the bus passes. The second line contains heights of these bridges.

You should output "Will not crash" if everything will be all right; otherwise, output "Will crash on bridge i" (where i is a number of a bridge) into which the bus will crash. If the height of a bridge equals the height of the bus, the bus will crash.
 */
/*
 * 234 8 465 453 981 463 1235 871 475 981
 */
/*
 * 211 5 871 205 123 871 1681
*/
public class BusTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add numbers");

        int busHeight = scanner.nextInt();
        int bridges = scanner.nextInt();
        int bridgHeight;
        int numOfBridg = 1;
        boolean crash = false;
        while (numOfBridg <= bridges) {
            bridgHeight = scanner.nextInt();
            if (bridgHeight < busHeight) {
                crash = true;
                break;
            }
            numOfBridg++;
        }
        String out = crash ? "Will crash on bridge " + numOfBridg : "Will not crash";
        System.out.println(out);
        scanner.close();
    }
}
