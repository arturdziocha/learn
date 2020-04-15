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
 * Extend your program by adding different algorithms to encode/decode data. 
 * The first one would be shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle). 
 * The second one would be based on Unicode table, like in the previous stage.

When starting the program, the necessary algorithm should be specified by an argument (-alg). 
The first algorithm should be named shift, the second one should be named unicode. 
If there is no -alg you should default it to shift.

Remember that in case of shift algorithm you need to encode only English letters (from 'a' to 'z' as the first circle and from 'A' to 'Z' as the second circle i.e. after 'z' comes 'a' and after 'Z" comes 'A').

To complete this stage, we recommend that you create a set of classes and interfaces for encryption and decryption algorithms.

Examples

Example 1

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

Example 2

Input:

java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
Output:

\jqhtrj%yt%m~ujwxpnqq&
Example 3

Input:

java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
Output:

Welcome to hyperskill!
Example 4:

Input:

java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
Output:

Bjqhtrj yt mdujwxpnqq!
Example 5:

Input:

java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
Output:

Welcome to hyperskill!
 */
public class Stage6 {
    public static void main(String[] args) {
        Map<String, String> actions = toMap(args);
        String line = "";
        Hash algorithm = actions.containsKey("-alg") ? HashFactory.hash(actions.get("-alg")) : new ShiftHash();
        if (actions.containsKey("-in")) {
            File file = new File("src/main/java/hyperskill/projects/encryptdecrypt/" + actions.get("-in"));
            // File file = new File(actions.get("-in"));
            try (Scanner scanner = new Scanner(file)) {
                line = scanner.nextLine();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (actions.containsKey("-data")) {
            line = actions.get("-data");
        }
        String ret = encodeDecode(algorithm, actions.getOrDefault("-mode", "enc"),
            actions.containsKey("-key") ? Integer.parseInt(actions.get("-key")) : 0, line);
        if (actions.containsKey("-out")) {
            File file = new File("src/main/java/hyperskill/projects/encryptdecrypt/" + actions.get("-out"));
            // File file = new File(actions.get("-out"));
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

    private static Map<String, String> toMap(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0, j = 1; j < args.length; j += 2, i += 2) {
            map.put(args[i], args[j]);
        }
        return map;
    }

    public static String encodeDecode(Hash hash, String mode, int move, String line) {
        return line
                .chars()
                .map(c -> mode.equals("enc") ? hash.encode(c, move) : hash.decode(c, move))
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
    }
}

enum HashMode {
    DECODE,
    ENCODE;
}

class HashFactory {
    public static Hash hash(String hash) {
        return hash.equals("unicode") ? new UnicodeHash() : new ShiftHash();
    }
}

abstract class Hash {

    protected abstract int encode(int c, int offset);

    protected abstract int decode(int c, int offset);
}

class UnicodeHash extends Hash {

    @Override
    protected int encode(int c, int offset) {
        return c + offset;
    }

    @Override
    protected int decode(int c, int offset) {
        return c - offset;
    }
}

class ShiftHash extends Hash {
    @Override
    protected int encode(int c, int offset) {
        if (Character.isAlphabetic(c)) {
            int originalAlphabetPosition = c - 'a';
            System.out.println(originalAlphabetPosition);
            int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
            return ('a' + newAlphabetPosition);
        } else {
            return c;
        }
    }

    @Override
    protected int decode(int c, int offset) {
        return encode(c, 26 - (offset % 26));
    }
}
