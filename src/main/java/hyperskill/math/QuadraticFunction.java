package hyperskill.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
 * You are given real numbers a, b and c, where a ≠ 0.

Solve the quadratic equation ax^2 + bx + c = 0 ax 
2
 +bx+c=0 and output all of its roots.

It is guaranteed that the equation always has two roots.

 

Output the results roots in ascending order. Do not round or format them, the testing system does it automatically.

Sample Input 1:

1
-1
-2
Sample Output 1:

-1 2
Sample Input 2:

1
-7.5
3
Sample Output 2:

0.423966 7.07603
Sample Input 3:

0.1
-2
0.999
Sample Output 3:

0.51264 19.4874
Sample Input 4:

-11
-32
41
Sample Output 4:

-3.87177 0.962679
 */
public class QuadraticFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        String xs = calculate(a, b, c).stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(xs);

    }

    public static double delta(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    public static List<Double> calculate(double a, double b, double c) {
        List<Double> ret = new ArrayList<>();
        double delta = delta(a, b, c);
        if (delta > 0) {            
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);            
            ret.add(x1);
            ret.add(x2);
        } else if (delta == 0) {
            ret.add(-b / 2 * a);
        }
        return ret;
    }
}
