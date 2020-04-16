package hyperskill.projects.encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    public static void main(String[] args) throws IOException {
        Parameters parameters = new Parameters(args);
        Context context = new Context(parameters.getMode(), parameters.getAlgorithm());
        String data = parameters.isInputFileDefined() ? readDataFromFile(parameters.getInputFileName())
                // Files.readString(Paths.get(parameters.getInputFileName()))
                : parameters.getData();
        String outputData = data
                .chars()
                .map(c -> context.process(c, parameters.getKey()))
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
        if (parameters.isOutFileDefined()) {
            try (PrintWriter writer = new PrintWriter(new File(parameters.getOutFileName()))) {
                writer.print(outputData);
            }
            // Files.writeString(Paths.get(parameters.getOutFileName()),
            // outputData, StandardOpenOption.WRITE,
            // StandardOpenOption.TRUNCATE_EXISTING);
        } else {
            System.out.println(outputData);
        }
    }

    private static String readDataFromFile(String inputFileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            return scanner.nextLine();
        }
    }
}

class Parameters {
    private Mode mode;
    private Algorithm algorithm;
    private int key;
    private String data;
    private boolean inputFileDefined;
    private String inputFileName;
    private boolean outFileDefined;
    private String outFileName;

    public Parameters(String[] args) {
        Map<String, String> params = toMap(args);
        this.algorithm = AlgorithmFactory.select(params.getOrDefault("alg", "shift"));
        this.mode = Mode.getMode(params.getOrDefault("mode", "enc"));
        this.key = Integer.parseInt(params.getOrDefault("key", "0"));
        this.data = params.getOrDefault("data", "");
        if (params.containsKey("in")) {
            inputFileDefined = true;
            inputFileName = params.get("in");
        } else {
            inputFileDefined = false;
        }
        if (params.containsKey("out")) {
            outFileDefined = true;
            outFileName = params.get("out");
        } else {
            outFileDefined = false;
        }
    }

    public Mode getMode() {
        return mode;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public boolean isInputFileDefined() {
        return inputFileDefined;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public boolean isOutFileDefined() {
        return outFileDefined;
    }

    public String getOutFileName() {
        return outFileName;
    }

    private static Map<String, String> toMap(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0, j = 1; j < args.length; j += 2, i += 2) {
            map.put(args[i].substring(1), args[j]);
        }
        return map;
    }
}

class Context {
    private final Mode mode;
    private final Algorithm algorithm;

    Context(Mode mode, Algorithm algorithm) {
        this.mode = mode;
        this.algorithm = algorithm;
    }

    public int process(int c, int key) {
        switch (mode) {
            case DECRYPTION:
                return algorithm.decode(c, key);
            case ENCRYPTION:
                return algorithm.encode(c, key);
            default:
                throw new RuntimeException("Invalida context mode: " + mode);
        }
    }
}

enum Mode {
    ENCRYPTION,
    DECRYPTION;

    static Mode getMode(String mode) {
        return "enc".equals(mode) ? Mode.ENCRYPTION : Mode.DECRYPTION;
    }
}

class AlgorithmFactory {
    public static Algorithm select(String algorithm) {
        return "unicode".equals(algorithm) ? new UnicodeAlgorithm() : new ShiftAlgorithm();
    }
}

abstract class Algorithm {

    protected abstract int encode(int c, int key);

    protected abstract int decode(int c, int key);
}

class UnicodeAlgorithm extends Algorithm {

    @Override
    protected int encode(int c, int key) {
        return c + key;
    }

    @Override
    protected int decode(int c, int key) {
        return c - key;
    }
}

class ShiftAlgorithm extends Algorithm {
    @Override
    protected int encode(int c, int key) {
        if (Character.isAlphabetic(c)) {
            int s = Character.isUpperCase(c) ? 65 : 97;
            return (c - s + key) % 26 + s;
        } else {
            return c;
        }
    }

    @Override
    protected int decode(int c, int key) {
        return encode(c, 26 - (key % 26));

    }
}
