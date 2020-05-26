package hyperskill.toString;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Here is an example: "title=Java 8 & 9 in Action,yearOfPublishing=2017,authors=[Mario Fusco,Alan Mycroft]".
 */
public class Book {
    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        String auth = Arrays.stream(authors).collect(Collectors.joining(","));
        return String.format("title=%s,yearOfPublishing=%d,authors=[%s]", title, yearOfPublishing, auth);
    }
}
