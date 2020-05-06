package hyperskill.projects.readability.stage4;

public class FKScore implements Score {
    @Override
    public double calculate(InputReader reader) {
        return 0.39 * reader.getWords() / reader.getSentences() + 11.8 * reader.getSyllabes() / reader.getWords()
                - 15.59;
    }
}
