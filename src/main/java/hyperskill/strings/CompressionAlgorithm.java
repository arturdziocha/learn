package hyperskill.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Upon learning that DNA is not a random string, freshmen of the Bioinformatics Institute from the informatics group suggested using a compression algorithm that compresses repeated characters in a string.

Encoding is performed as follows:
The string "aaaabbсaa" is converted into "a4b2с1a2", that is, the groups of the same characters of the input string are replaced by the symbol and the number of its repetitions in this string.

Write a program, which reads the string, encodes it by this algorithm and outputs the encoded sequence. The encoding must be case sensitive.

Note, string can contain only a single character.

Sample Input 1:

aaaabbcaa
Sample Output 1:

a4b2c1a2
Sample Input 2:

abc
Sample Output 2:

a1b1c1
Sample Input 3:

aaaaa
Sample Output 3:

a5
 */
public class CompressionAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String str = scanner.nextLine();
        List<Character> chars = new ArrayList<>();
        List<Integer> howMany = new ArrayList<>();
        char lastChar = str.charAt(0);
        chars.add(lastChar);
        howMany.add(1);
        int l = 1;
        int index = 0;
        if (str.length() > 1) {
            do {
                char c = str.charAt(l);
                if (c == lastChar) {
                    howMany.set(index, howMany.get(index) + 1);
                } else {
                    chars.add(c);
                    howMany.add(1);
                    index++;
                    lastChar = c;
                }
                l++;

            } while (l < str.length());
        }
        for (int i = 0; i < chars.size(); i++) {
            System.out.print("" + chars.get(i) + howMany.get(i));
        }
        System.out.println();
        char current = 0;
        char previous = 0;
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            current = str.charAt(i);
            previous = str.charAt(i - 1);
            if (current != previous) {
                builder.append(previous);
                builder.append(count);
                count = 0;
            }
            count++;
        }
        builder.append(current);
        builder.append(count);
        System.out.println(builder.toString());
        scanner.close();

    }
}
