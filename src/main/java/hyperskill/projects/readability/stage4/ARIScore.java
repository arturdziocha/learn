package hyperskill.projects.readability.stage4;

public class ARIScore implements Score {

    @Override
    public double calculate(InputReader reader) {
        return 4.71 * ((double) reader.getChars() / reader.getWords())
                + 0.5 * ((double) reader.getWords() / reader.getSentences()) - 21.43;
    }

}
