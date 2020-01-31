package snippets.date;

import java.time.Year;
import java.util.Calendar;
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me year");
        int year = scanner.nextInt();
        if (leapYear(year)) {
            System.out.println("Leap");
        } else {
            System.out.print("Regular");
        }
        scanner.close();
    }

    static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    static boolean leapYear1(int year) {
        return Year.of(year).isLeap();
    }

    static boolean leapYear2(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
}
