package hyperskill.inputStreams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Read an input text from the console and print it as a sequence of bytes.

Use System.in as input stream directly. Avoid using Scanner.

Sample Input 1:

abc
Sample Output 1:

979899
 */
public class ConvertToBytes {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        System.out.println("add");
        // Woks in java 9;
        // byte[] bytes = inputStream.readAllBytes();
        int a;
        while ((a = inputStream.read()) >= 0) {
            System.out.print(a);
        }

    }

    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        return outputStream.toByteArray();
    }
}
