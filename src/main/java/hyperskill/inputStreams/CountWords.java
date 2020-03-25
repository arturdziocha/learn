package hyperskill.inputStreams;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                new ByteArrayInputStream("between   us  several   space characters".getBytes(StandardCharsets.UTF_8))))) {
            int b;            
            StringBuilder line = new StringBuilder();
            while ((b = reader.read()) != -1) {
                
                line.append((char) b);

            }
            String[] words = line.toString().split(" ");
            System.out.println(Arrays.toString(words));
            
            System.out.println(words.length);
        }
    }
}
