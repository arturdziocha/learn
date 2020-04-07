package hyperskill.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/*
Write a program that takes a date string formatted as YYYY-MM-DD as input, then converts and outputs it as MM/DD/YYYY.

For instance, the input 2007-07-21 will result in the following output 07/21/2007.

Sample Input 1:

2012-09-28
Sample Output 1:

09/28/2012
 */
public class ConvertADate {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String dateString = scanner.nextLine();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-dd-mm");
        Date date = dt.parse(dateString);
        dt = new SimpleDateFormat("dd/mm/yyyy");
        System.out.println(dt.format(date));
        System.out.println(LocalDate.parse(dateString).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));


    }
}
