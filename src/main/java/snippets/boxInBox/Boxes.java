package snippets.boxInBox;

import java.util.Arrays;
import java.util.Scanner;

//Sample Input 1:
//1 1 1
//2 2 2
//Sample Output 1:
//Box 1 < Box 2
//Sample Input 2:
//2 2 2
//1 2 2
//Sample Output 2:
//Box 1 > Box 2
//Sample Input 3:
//1 2 3
//2 3 1
//Sample Output 3:
//Box 1 = Box 2
//Sample Input 4:
//2 3 4
//1 3 5
//Sample Output 4:
//Incomparable
public class Boxes {
    private static String compareBetter(int a1, int a2, int a3, int b1, int b2, int b3) {
        int[] box1 = {a1, a2, a3};
        int[] box2 = {b1, b2, b3};
        Arrays.sort(box1);
        Arrays.sort(box2);

        if (Arrays.equals(box1, box2)) {
            return "Box 1 == Box 2";
        } else if (box1[0] <= box2[0] && box1[1] <= box2[1] && box1[2] <= box2[2]) {
            return "Box 1 < Box 2";
        } else if (box1[0] >= box2[0] && box1[1] >= box2[1] && box1[2] >= box2[2]) {
            return "Box 1 > Box 2";
        } else {
            return "Incomparable";
        }
    }

    private static String compare(int a1, int a2, int a3, int b1, int b2, int b3) {
        if (b1 == a1 && b2 == a2 && b3 == a3 || b1 == a1 && b2 == a3 && b3 == a2 || b1 == a2 && b2 == a1 && b3 == a3
                || b1 == a2 && b2 == a3 && b3 == a1 || b1 == a3 && b2 == a1 && b3 == a2
                || b1 == a3 && b2 == a2 && b3 == a1) {
            return "Box 1 == Box 2";
        } else if (b1 <= a1 && b2 <= a2 && b3 <= a3 || b1 <= a1 && b2 <= a3 && b3 <= a2
                || b1 <= a2 && b2 <= a1 && b3 <= a3 || b1 <= a2 && b2 <= a3 && b3 <= a1
                || b1 <= a3 && b2 <= a1 && b3 <= a2 || b1 <= a3 && b2 <= a2 && b3 <= a1) {
            return "Box 1 > Box 2";

        } else if (a1 <= b1 && a2 <= b2 && a3 <= b3 || a1 <= b1 && a2 <= b3 && a3 <= b2
                || a1 <= b2 && a2 <= b1 && a3 <= b3 || a1 <= b2 && a2 <= b3 && a3 <= b1
                || a1 <= b3 && a2 <= b1 && a3 <= b2 || a1 <= b3 && a2 <= b2 && a3 <= b1) {
            return "Box 1 < Box 2";

        } else {
            return "Incomparable";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add numbers");
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();

        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int b3 = scanner.nextInt();
        System.out.println(compare(a1, a2, a3, b1, b2, b3));
        System.out.println(compareBetter(a1, a2, a3, b1, b2, b3));
        scanner.close();
    }
}
