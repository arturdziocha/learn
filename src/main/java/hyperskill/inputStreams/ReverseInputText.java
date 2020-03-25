package hyperskill.inputStreams;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/*
 * Read an input text from the console and print its characters in reversed order.

Use Reader for collecting characters.

Sample Input 1:

abc
Sample Output 1:

cba
 */
public class ReverseInputText {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream("Dupa".getBytes(StandardCharsets.UTF_8))))) {
            StringBuilder builder = new StringBuilder();
            int n;
            while ((n = reader.read()) != -1) {
                builder.append((char) n);
            }
            System.out.println(builder.reverse().toString());
        }
    }
}
