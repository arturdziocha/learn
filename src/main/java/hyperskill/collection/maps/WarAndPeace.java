package hyperskill.collection.maps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * When Anthony finally finished reading "War and Peace", he began to wonder how many words and how frequently were used in this book. Help Anthony and write a simplified version of a program that can count the words, separated by space and output the resulting statistics.

The program must read one line from the standard input and for each unique word in this line output the count of its repeated occurrence in the "word amount" format (see the output example). The words should be counted as case insensitive.

The order of words output may be arbitrary.

Each unique word must appear in the output only once.

Sample Input 1:

a aa abC aa ac abc bcd a
Sample Output 1:

a 2
aa 2
abc 2
ac 1
bcd 1
Sample Input 2:

a A a
Sample Output 2:

a 3
 */
public class WarAndPeace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add strings");
        SortedMap<String, Integer> map = new TreeMap<>();
        String[] words = scanner.nextLine().toLowerCase().split(" ");
        Arrays.stream(words).forEach(word -> {
            if (map.containsKey(word)) {
                map.computeIfPresent(word, (k, v) -> v += 1);
            } else {
                map.put(word, 1);
            }
        });
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
