package hyperskill.collection.maps;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * At some point in the Bioinformatics Institute, biology students no longer understood what did the computer science students say: they spoke a strange set of sounds.

And one of the biologists had suddenly discovered the secret of computer science students: they used the substitution cipher in their communication, i.e. they replaced each symbol of the initial message to another corresponding symbol. Biologists gained the key to the cipher and now they need help:

Write a program that can encode and decode the substitution cipher. The program accepts two input strings of the same length; the first line contains the characters of the original alphabet, the second line - the symbols of a resulting alphabet, then goes a line you need to encode by the transmitted key, and another line to be decrypted.

For example, the program takes the following input:

abcd
*d%#
abacabadaba
#*%*d*%
It means that symbol a of the initial message is changed to symbol * in the cipher, b changed to d, c — to % and d — to #. You need to encode the string abacabadaba and decode the string #*%*d*% using this cipher. So you get the following lines, which should be the output of the program:

*d*%*d*#*d*
dacabac
Sample Input 1:

abcd
*d%#
abacabadaba
#*%*d*%
Sample Output 1:

*d*%*d*#*d*
dacabac
Sample Input 2:

dcba
badc
dcba
badc
Sample Output 2:

badc
dcba
 */
public class SubstitutionCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("add lines");
        char[] chars = scanner.nextLine().toCharArray();
        char[] subs = scanner.nextLine().toCharArray();
        Map<Character, Character> code = IntStream
                .range(0, chars.length)
                .boxed()
                .collect(Collectors.toMap(i -> chars[i], i -> subs[i]));

        String encoded = scanner
                .nextLine()
                .chars()
                .mapToObj(c -> (char) c)
                .map(s -> String.valueOf(code.get(s)))
                .collect(Collectors.joining());
        String decoded = scanner
                .nextLine()
                .chars()
                .mapToObj(c -> (char) c)
                .map(s -> String
                        .valueOf(code
                                .entrySet()
                                .stream()
                                .filter(es -> es.getValue().equals(s))
                                .findFirst()
                                .map(Map.Entry::getKey)
                                .get()))
                .collect(Collectors.joining());

        System.out.println(encoded);
        System.out.println(decoded);
        scanner.close();
    }

}
