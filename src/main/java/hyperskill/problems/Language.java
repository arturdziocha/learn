package hyperskill.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * We need your help to improve an adaptive system. Write a program that asks learners what programming language they are learning. I hope you know which answer is correct.

Question: what programming language are you learning here?

Java
Kotlin
Scala
Python
The program should read the answer’s number from the standard input and output the result of the test: "Yes!", "No!" or "Unknown number".

Sample Input 1:

1
Sample Output 1:

Yes!
Sample Input 2:

6
Sample Output 2:

Unknown number
 */
public class Language {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> langs = Arrays.asList("Java", "Kotlin", "Scala", "Python");
        System.out.println("add");
        int answer = scanner.nextInt();
        scanner.close();
        System.out.println(answer > 0 && answer <= langs.size() ? answer == 1 ? "Yes!" : "No!" : "Unknown number");
    }
}
