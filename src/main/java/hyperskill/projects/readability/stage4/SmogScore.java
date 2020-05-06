package hyperskill.projects.readability.stage4;

public class SmogScore implements Score {
    @Override
    public double calculate(InputReader reader) {
        return 1.043 * Math.sqrt(reader.getPolySyllables() * (double) 30 / reader.getSentences()) + 3.1291;
    }
}
