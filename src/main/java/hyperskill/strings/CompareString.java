package hyperskill.strings;

import java.util.Scanner;

public class CompareString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First str");
        String s1 = scanner.nextLine();
        System.out.println("Second str");
        String s2 = scanner.nextLine();
        System.out.println(s1.replaceAll(" ", "").equals(s2.replaceAll(" ", "")));
        scanner.close();

    }

}
