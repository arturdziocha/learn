package hyperskill.collection;

import java.util.*;

/*
Write a program that reads a sequence of strings from the standard input and displays them in a lexicographic order without duplicates.

Try to write your solution using a set.

Input data format

The first line contains the size of a string sequence. Next lines contain strings.

Output data format

A sorted sequence of strings without duplicates. Each string must be in a new line.

Sample Input 1:

6
postgres
sqlite
oracle
mongodb
postgres
mssql
Sample Output 1:

mongodb
mssql
oracle
postgres
sqlite
Sample Input 2:

5
1
2
2
11
20
Sample Output 2:

1
11
2
20
 */
public class RemoveSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add lines");
        int hML = scanner.nextInt();
        System.out.println(scanner.nextLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < hML; i++) {
            words.add(scanner.nextLine());
        }
        SortedSet<String> sets = new TreeSet<>(words);
        sets.forEach(System.out::println);
    }
}
