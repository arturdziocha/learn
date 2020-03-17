package hyperskill.collection.maps.sherlock;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Imagine now you are an outlaw in the Sherlock Holmes times. You are in need of money and you want to demand some by blackmailing. Obviously, you have to write a letter completely anonymously because you do not want to be busted.

So you decide to compose a letter by cuttings the required words from a newspaper.

In this problem, you get two lines: 1) available words you have in a newspaper, 2) your note.

Find out and print if you can write a note from available words ("You get money") or you will be busted ("You are busted").

Remember:  your note is case-sensitive

Sample Input 1:

batman batman batman i i I need am and and money
I am batman and i need money
Sample Output 1:

You get money
 */
public class Kidnapper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add lines");
        Map<String, Long> gazette = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> words = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean ret = true;
        for (Map.Entry<String, Long> entry : words.entrySet()) {
            if (gazette.containsKey(entry.getKey())) {
                if (Long.compare(entry.getValue(), gazette.get(entry.getKey())) > 0) {
                    ret = false;
                    break;
                }
            } else {
                ret = false;
            }
        }
        System.out.println(ret ? "You get money" : "You are busted");
        scanner.close();

    }

}
