package hyperskill.projects.stage6;

import java.util.List;
import java.util.Optional;

class CardFacade {
    private final CardGateway cardGateway;

    public CardFacade() {
        this.cardGateway = new CardGateway();
    }

    boolean nameExists(String name) {
        return cardGateway.nameExists(name);
    }

    boolean definitionExists(String definition) {
        return cardGateway.definitionExists(definition);
    }

    void add(Card card) {
        cardGateway.add(card);
    }

    void remove(String name) {
        cardGateway.remove(name);
    }

    List<Card> getAll() {
        return cardGateway.getAll();
    }

    Optional<Card> get(String name) {
        return cardGateway.get(name);
    }
    int size() {
        return cardGateway.size();
    }
}
