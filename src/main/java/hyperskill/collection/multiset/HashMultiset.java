package hyperskill.collection.multiset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMultiset<E> implements Multiset<E> {
    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        if (map.containsKey(elem)) {
            map.computeIfPresent(elem, (k, v) -> v += 1);
        } else {
            map.put(elem, 1);
        }
    }

    @Override
    public void remove(E elem) {
        if (map.get(elem) > 2) {
            map.computeIfPresent(elem, (k, v) -> v -= 1);
        }

    }

    @Override
    public void union(Multiset<E> other) {

    }

    @Override
    public void intersect(Multiset<E> other) {

    }

    @Override
    public int getMultiplicity(E elem) {
        return 0;
    }

    @Override
    public boolean contains(E elem) {
        return false;
    }

    @Override
    public int numberOfUniqueElements() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<E> toSet() {
        return null;
    }
}
