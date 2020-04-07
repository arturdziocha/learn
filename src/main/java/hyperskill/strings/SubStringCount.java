package hyperskill.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Write a program that finds the frequency of occurrences of substring in given string.


Input data format

The first input line contains a string, the second one contains a substring.

Sample Input 1:

hello there
the
Sample Output 1:

1
Sample Input 2:

hello yellow jello
ll
Sample Output 2:

3
 */
public class SubStringCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String line = scanner.nextLine();
        String occurences = scanner.nextLine();

        System.out.println(countFreq(line, occurences));
        scanner.close();
        System.out.println(countSubstring(occurences, line));

    }

    public static int countSubstring(String subStr, String str) {
        int count = 0;
        for (int loc = str.indexOf(subStr); loc != -1; loc = str.indexOf(subStr, loc + subStr.length())) {
            System.out.println(loc);
            count++;
        }
        return count;
    }

    public static int countSubstring1(String subString, String string) {
        int counter = 0;
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    static int countFreq(String line, String occurences) {
        int res = 0;
        int lineLength = line.length();
        int occurencesLength = occurences.length();
        for (int i = 0; i <= lineLength - occurencesLength; i++) {
            int j;
            for (j = 0; j < occurencesLength; j++) {
                if (line.charAt(i + j) != occurences.charAt(j)) {
                    break;
                }
            }
            if (j == occurencesLength) {
                res++;
                j = 0;
            }
        }
        return res;
    }

}
