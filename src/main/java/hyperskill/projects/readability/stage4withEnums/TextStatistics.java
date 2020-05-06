package hyperskill.projects.readability.stage4withEnums;

import static java.lang.String.join;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextStatistics {
    public static final long NOT_CALCULATED = -1;
    private final String text;
    private long characters = NOT_CALCULATED;
    private long words = NOT_CALCULATED;
    private long sentences = NOT_CALCULATED;
    private long syllables = NOT_CALCULATED;
    private long polysyllables = NOT_CALCULATED;

    public TextStatistics(final String text) {
        this.text = text;
    }

    public long getCharacters() {
        if (characters == NOT_CALCULATED) {
            characters = countWithRegex(text, "\\S");
        }
        return characters;
    }

    public long getWords() {
        if (words == NOT_CALCULATED) {
            words = getWordsStream().count();
        }
        return words;
    }

    public long getSentences() {
        if (sentences == NOT_CALCULATED) {
            sentences = countWithRegex(text, "[!.?][^$]|$");
        }
        return sentences;
    }

    public long getSyllables() {
        if (syllables == NOT_CALCULATED) {
            syllables = getWordsStream().mapToLong(TextStatistics::countSyllables).sum();
        }
        return syllables;
    }

    public long getPolysyllables() {
        if (polysyllables == NOT_CALCULATED) {
            polysyllables = getWordsStream().filter(TextStatistics::isPolysyllable).count();
        }
        return polysyllables;
    }

    public String getText() {
        return text;
    }

    public static long countSyllables(final String word) {
        Matcher m = Pattern.compile("(?i)[aeiouy][^aeiouy\\s]|[aiouy]$").matcher(word);
        long count = 0;
        while (m.find()) {
            count++;
        }
        return Math.max(count, 1);
    }   

    public static boolean isPolysyllable(final String word) {
        return countSyllables(word) > 2;
    }

    public Stream<String> getWordsStream() {
        return Stream.of(text.split("[^\\p{Alpha}]+"));
    }

    @Override
    public String toString() {
        return String
                .format(
                    join("%n", "The text is: %n%s", "Words: %d", "Sentences: %d", "Characters: %d", "Syllables: %d",
                        "Polysyllables: %d%n"),
                    getText(), getWords(), getSentences(), getCharacters(), getSyllables(), getPolysyllables());
    }

    private long countWithRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        long sum = 0;
        while (matcher.find()) {
            sum++;
        }
        return sum;
        // return matcher.results().count(); Java 9
    }
}