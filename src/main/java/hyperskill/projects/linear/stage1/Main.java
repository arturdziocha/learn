package hyperskill.projects.linear.stage1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        scanner.close();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.print(b / a);
    }
}
