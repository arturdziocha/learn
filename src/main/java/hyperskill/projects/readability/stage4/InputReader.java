package hyperskill.projects.readability.stage4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    private final String text;

    public InputReader(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public long getWords() {
        return countWithRegex(text, Regex.WORDS);
    }

    public long getChars() {
        return countWithRegex(text, Regex.CHARS);
    }

    public long getSentences() {
        return countWithRegex(text, Regex.SENTECES);
    }

    public long getSyllabes() {
        List<String> list = new ArrayList<>();
        Matcher matcher = Pattern.compile(Regex.WORDS.getRegex()).matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.stream().mapToLong(w -> countSyllablesInWord(w, Regex.SYLLABES)).sum();
    }

    public long getPolySyllables() {
        List<String> list = new ArrayList<>();
        Matcher matcher = Pattern.compile(Regex.WORDS.getRegex()).matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.stream().mapToLong(word -> countSyllablesInWord(word, Regex.SYLLABES)).filter(s -> s > 2).count();
    }

    enum Regex {
        SENTECES("[!.?][^$]|$"),
        WORDS("\\d+,\\d+|\\w+"),
        CHARS("\\S"),
        SYLLABES("(?i)[aeiouy][^aeiouy\\s]|[aiouy]$");
        private final String regex;

        private Regex(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }
    }

    private long countWithRegex(String text, Regex regex) {
        Pattern pattern = Pattern.compile(regex.getRegex());
        Matcher matcher = pattern.matcher(text);
        long sum = 0;
        while (matcher.find()) {
            sum++;
        }
        return sum;
        // return matcher.results().count(); Java 9
    }

    private long countSyllablesInWord(String word, Regex regex) {
        Matcher m = Pattern.compile(regex.getRegex()).matcher(word);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return Math.max(count, 1);
    }

}
