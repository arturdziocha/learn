package hyperskill.inputStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
    //TODO
    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream("between   us      several   space characters. Jezeli.ww".getBytes(StandardCharsets.UTF_8))))) {

            int b;
            int counter = 1;
            boolean isLastWhitespace = true;
            StringBuilder builder = new StringBuilder();
            while ((b = reader.read()) != -1) {
                if(!isLastWhitespace && Character.isWhitespace(b)){
                    counter++;
                }
                isLastWhitespace = Character.isWhitespace(b);

            }
            System.out.println(counter);
        }
    }
}
