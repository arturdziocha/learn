package hyperskill.projects.numericalConverter.stage2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String bin = Integer.toOctalString(scanner.nextInt());
        System.out.println(bin.charAt(bin.length() - 1));
    }
}
