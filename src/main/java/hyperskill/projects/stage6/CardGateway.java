package hyperskill.projects.stage6;

import java.util.List;
import java.util.Optional;

public class CardGateway {
    private List<Card> cards;

    boolean nameExists(String name) {
        return cards.stream().anyMatch(c -> c.getName().equals(name));
    }

    boolean definitionExists(String definition) {
        return cards.stream().anyMatch(c -> c.getDefinition().equals(definition));
    }

    void add(Card card) {
        //TODO update to check if exists
        this.cards.add(card);
    }

    void remove(String name) {
        this.cards.removeIf(c -> c.getName().equals(name));
    }

    List<Card> getAll() {
        return cards;
    }

    Optional<Card> get(String name) {
        return this.cards.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    int size() {
        return this.cards.size();
    }
}
