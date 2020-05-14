package hyperskill.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * All the letters of the English alphabet are divided into vowels and consonants. 
The vowels are: a, e, i, o, u, y. 
The remaining letters are consonants.

A word is considered euphonious if it has not three or more vowels or consonants in a row. Otherwise, it is considered discordant.

Your task is to create euphonious words from discordant. You can insert any letters inside word. You should output the minimum number of characters needed to create a euphonious word from a given word.

For example, word "schedule" is considered discordant because it has three consonants in a row - "sch". To create a euphonious word you need to add any vowel between 's' and 'c' or between 'c' and 'h'.

Sample Input 1:

schedule
Sample Output 1:

1
Sample Input 2:

garage
Sample Output 2:

0
Sample Input 3:

player
Sample Output 3:

1
Sample Input 4:

biiiiig
Sample Output 4:

2


wwwwwwwwwwwwwwwwwwwwwwwwwwwww
 */
public class Euphenious {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String word = scanner.next();
        scanner.close();
        System.out.println(find(factorialEuph(word.toLowerCase())));

    }

    static String factorialEuph(String string) {
        List<Character> vovels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
        List<Character> consonants = IntStream
                .rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
        consonants.removeAll(vovels);
        String vovelsString = vovels.stream().map(String::valueOf).collect(Collectors.joining());
        String consonantsString = consonants.stream().map(String::valueOf).collect(Collectors.joining());
        Pattern pattern = Pattern.compile("[" + vovelsString + "]{3}|[" + consonantsString + "]{3}");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            int val = matcher.end(0);
            string = factorialEuph(string.substring(0, val - 1) + "_" + string.substring(val - 1));
        }
        return string;
    }

    static int find(String word) {
        Pattern pattern = Pattern.compile("[_]");
        Matcher matcher = pattern.matcher(word);
        int sum = 0;
        while (matcher.find()) {
            sum += 1;
        }
        return sum;
    }

}
