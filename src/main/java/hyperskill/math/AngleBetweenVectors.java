package hyperskill.math;

import java.util.Arrays;
import java.util.Scanner;

/*
 * You are given two 2D vectors. Find the angle (in degrees) between them.

If you don't know how to find the angle, see here: http://www.wikihow.com/Find-the-Angle-Between-Two-Vectors.

Input data format

The first line contains two components of the first vector; the second line contains two components of the second vector. Components in one line are separated by space.

Output data format

One double value: an angle between two vectors. The result can have an error of less than 1e-8.

Sample Input 1:

1 3
4 2
Sample Output 1:

45
Sample Input 2:

0 4
0 4
Sample Output 2:

0
 */
public class AngleBetweenVectors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int[] u = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] v = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        double num = u[0] * v[0] + u[1] * v[1];
        double uManitude = Math.sqrt(Math.pow(u[0], 2) + Math.pow(u[1], 2));// Math.hypot(u[0]+u[1])
        double vManitude = Math.sqrt(Math.pow(v[0], 2) + Math.pow(v[1], 2));// Math.hypot(v[0]+v[1])
        double cosA = num / (uManitude * vManitude);
        System.out.println((int) Math.toDegrees(Math.acos(cosA)));
        System.out
                .println(Math
                        .toDegrees((Math
                                .acos(
                                    (u[0] * v[0] + u[1] * v[1]) / (Math.hypot(u[0], u[1]) * Math.hypot(v[0], v[1]))))));

    }

}
