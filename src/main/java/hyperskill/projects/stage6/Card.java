package hyperskill.projects.stage6;

class Card {
    private final String name;
    private final String definition;
    private int errors;

    Card(String name, String definition, Integer errors) {
        this.name = name;
        this.definition = definition;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public int getErrors() {
        return errors;
    }

    public void enlargeErrors() {
        this.errors += 1;
    }
    @Override
    public String toString() {
        return this.getName() + ": " + this.getDefinition() + " - "+this.getErrors();
    }
}
