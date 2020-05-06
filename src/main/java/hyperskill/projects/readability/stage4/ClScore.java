package hyperskill.projects.readability.stage4;

public class ClScore implements Score {

    @Override
    public double calculate(InputReader reader) {
        return 0.0588 * (double) reader.getChars() / reader.getWords() * 100
                - 0.296 * (double) reader.getSentences() / reader.getWords() * 100 - 15.8;
    }

}
