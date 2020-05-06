package hyperskill.projects.readability.stage4;

public class Context {
    private final Score score;

    public Context(Score score) {
        this.score = score;
    }

    public double getScore(InputReader reader) {
        return score.calculate(reader);
    }
}
