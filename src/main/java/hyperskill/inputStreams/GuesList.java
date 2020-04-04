package hyperskill.inputStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * You have a guest list of the people who registered their stay at the hotel. There are 4 rooms in the hotel: 1 single room, 2 double rooms and 1 family room for three guests. The guest list consists of 4 lines. Each line contains the name or the names of the guests registered together in one room. 

Read the names of the registered guests from the list and output each name in a separate line and in reverse order starting with the last registered guest. Note that the order of the guests registered in each room is undefined.

Sample Input 1:

Jane Kate
John
Mary Susan Paul
Boris Ann
Sample Output 1:

Ann
Boris
Paul
Susan
Mary
John
Kate
Jane
Sample Input 2:

Joseph 
Piotr Eugene
Jack Sarah 
Helen James Alex
Sample Output 2:

Alex
James
Helen
Sarah
Jack
Eugene
Piotr
Joseph
 */
public class GuesList {

    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> words = new ArrayList<>();
            System.out.println("add");
            StringBuilder builder = new StringBuilder();
            int n;
            while ((n = reader.read()) != -1) {
                char c = (char) n;
                if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
                    builder.append(c);
                }

            }
            System.out.println(builder.toString());
        }
    }

}
