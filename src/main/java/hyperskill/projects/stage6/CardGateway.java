package hyperskill.projects.stage6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class CardGateway {
    private List<Card> cards;

    public CardGateway() {
        this.cards = new ArrayList<>();
    }

    boolean nameExists(String name) {
        return cards.stream().anyMatch(c -> c.getName().equals(name));
    }

    boolean definitionExists(String definition) {
        return cards.stream().anyMatch(c -> c.getDefinition().equals(definition));
    }

    void add(Card card) {
        boolean nameExists = nameExists(card.getName());
        boolean definitionExists = definitionExists(card.getDefinition());
        if (nameExists || definitionExists) {
            int index = findIndex(card);
            this.cards.set(index, card);

        } else {
            this.cards.add(card);
        }
    }

    void enlargeErrors(Card card) {
        int index = findIndex(card);
        card.enlargeErrors();
        this.cards.set(index, card);
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

    public Optional<Card> getByDefinition(String definition) {
        return this.cards.stream().filter(c -> c.getDefinition().equals(definition)).findFirst();
    }

    int size() {
        return this.cards.size();
    }

    private int findIndex(Card card) {
        return IntStream
                .range(0, cards.size())
                .filter(i -> cards.get(i).getName().equals(card.getName()))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }

}
