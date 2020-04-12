package hyperskill.projects.encryptdecrypt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Description

For the first stage, you need to manually encrypt the message "we found a treasure!" and print only the ciphertext (in lower case).
To encrypt the message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or the exclamation mark.

Use the given template to your program to print the ciphertext instead of the original message.

The output should look like ## ##### # ########! where # is a lower-case English letter.
 */
public class Stage1 {
    public static void main(String[] args) {
        String word = "we found a treasure!";
        List<Character> characters = IntStream
                .rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
        List<Character> subs = characters
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));

        Map<Character, Character> map = IntStream
                .range(0, characters.size())
                .boxed()
                .collect(Collectors.toMap(characters::get, subs::get));
        String encoded = word.chars().mapToObj(c -> (char) c).map(s -> {
            if (Character.isAlphabetic(s)) {
                return String.valueOf(map.get(s));
            } else {
                return String.valueOf(s);
            }
        }).collect(Collectors.joining());
        System.out.println(encoded);

    }
}
