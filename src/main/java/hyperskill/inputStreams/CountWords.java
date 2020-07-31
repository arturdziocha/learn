package hyperskill.inputStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
Read an input text from the console and print the number of words. By word we mean a sequence of characters separated by one or several spaces.

If the input is empty or there are no characters except spaces, print 0.

Sample Input 1:

one two three
Sample Output 1:

3
Sample Input 2:

between   us  several   space characters
Sample Output 2:

5
 */
public class CountWords {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream("between   us  several   space characters".getBytes(StandardCharsets.UTF_8))))) {
            int b;
            StringBuilder line = new StringBuilder();
            while ((b = reader.read()) != -1) {
                line.append((char) b);
            }
            System.out.println(
                    Arrays.stream(
                            line.toString().split(" "))
                            .filter(w -> !w.isEmpty()).count());
        }
    }
}
