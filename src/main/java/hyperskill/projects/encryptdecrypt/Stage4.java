package hyperskill.projects.encryptdecrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Description
Modify the previous program to work with command-line arguments instead of the standard input. 
The program must parse three arguments: -mode, -key and -data. 
The first argument should determine the program’s mode (enc - encryption, dec - decryption). 
The second argument is an integer key to modify the message, and the third argument is a text or ciphertext within quotes to encrypt or decrypt.

All the arguments are guaranteed to be passed to the program. If for some reason it turns out to be wrong:

If there is no -mode, the program should work in enc mode.
If there is no -key, the program should consider that key = 0.
If there is no -data, the program should assume that the data is an empty string.
Keep in mind that arguments may be in different order. For example, -mode enc may be at the end, at the beginning or in the middle of arguments array.
Run configuration examples for encryption
java Main -mode enc -key 5 -data "Welcome to hyperskill!"
Encryption output example
\jqhtrj%yt%m~ujwxpnqq&
Run configuration examples for decryption
java Main -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
Decryption output example
Welcome to hyperskill!
 */
public class Stage4 {
    public static void main(String[] args) {
        Map<String, String> actions = toMap(String.class, String.class, args);
        System.out
                .println(encodeDecode(actions.getOrDefault("-mode", "enc"),
                        actions.containsKey("-key") ? Integer.parseInt(actions.get("-key")) : 0, actions.get("-data")));

    }

    public static String encodeDecode(String mode, int move, String line) {
        return line
                .chars()
                .map(c -> mode.equals("enc") ? c + move : c - move)
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
    }

    public static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, Object... entries) {
        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");
        return IntStream.range(0, entries.length / 2).map(i -> {
            System.out.println(i * 2);
            return i * 2;
        })
                .collect(HashMap::new, (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }
}
