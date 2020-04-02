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
    void enlargeErrors(Card card) {
        cardGateway.enlargeErrors(card);
    }

    void remove(String name) {
        cardGateway.remove(name);
    }

    List<Card> getAll() {
        return cardGateway.getAll();
    }

    Optional<Card> getByName(String name) {
        return cardGateway.get(name);
    }
    Optional<Card> getByDefinition(String definition){
        return cardGateway.getByDefinition(definition);
    }
    int size() {
        return cardGateway.size();
    }
}
