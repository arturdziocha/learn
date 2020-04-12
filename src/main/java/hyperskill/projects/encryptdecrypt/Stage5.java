package hyperskill.projects.encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * At this stage, you need to add the ability to read and write original and cipher data to files. The program must parse two additional arguments -in and -out to specify the full name of a file to read data and to write the result. Arguments -mode, -key, and -data should still work as before.

Your program should read data from -data or from a file written in the -in argument. That's why you can't have both -data and -in arguments simultaneously, only one of them.

If there is no -mode, the program should work in enc mode.
If there is no -key, the program should consider that key = 0.
If there is no -data, and there is no -in the program should assume that the data is an empty string.
If there is no -out argument, the program must print data to the standard output.
If there are both -data and -in arguments, your program should prefer -data over -in.
If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program should not fail. Instead, it must display a clear message about the problem and stop successfully. The message should contain the word "Error" in any case.

Examples
Example 1

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5
This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

Example 2

Input:

java Main -mode enc -key 5 -data "Welcome to hyperskill!"
Output:

\jqhtrj%yt%m~ujwxpnqq&
Example 3

Input:

java Main -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
Output:

Welcome to hyperskill
 */
public class Stage5 {
    public static void main(String[] args) {
        Map<String, String> actions = toMap(String.class, String.class, args);
        String line = "";
        if (actions.containsKey("-in")) {
            File file = new File("src/main/java/hyperskill/projects/encryptdecrypt/" + actions.get("-in"));
            try (Scanner scanner = new Scanner(file)) {
                line = scanner.nextLine();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (actions.containsKey("-data")) {
            line = actions.get("-data");
        }
        String ret = encodeDecode(actions.getOrDefault("-mode", "enc"),
                actions.containsKey("-key") ? Integer.parseInt(actions.get("-key")) : 0, line);
        if (actions.containsKey("-out")) {
            File file = new File("src/main/java/hyperskill/projects/encryptdecrypt/" + actions.get("-out"));
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(ret);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println(ret);
        }
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
        return IntStream
                .range(0, entries.length / 2)
                .map(i -> i * 2)
                .collect(HashMap::new, (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }
}
