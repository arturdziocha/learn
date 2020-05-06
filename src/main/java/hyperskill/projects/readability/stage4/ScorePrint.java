package hyperskill.projects.readability.stage4;

public enum ScorePrint {
    ARI("Automated Readability Index"),
    FK("Flesch–Kincaid readability tests"),
    SMOG("Simple Measure of Gobbledygook"),
    CL("Coleman–Liau index");
    private final String s;

    ScorePrint(final String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
