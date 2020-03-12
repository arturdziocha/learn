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
        if (contains(elem)) {
            Integer howMany = map.get(elem);
            if (howMany > 1) {
                map.computeIfPresent(elem, (k, v) -> v -= 1);
            } else {
                map.remove(elem);
            }

        }

    }

    @Override
    public void union(Multiset<E> other) {
        for (E e : other.toSet()) {
            if (!map.containsKey(e)) {
                map.put(e, other.getMultiplicity(e));
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        Map<E, Integer> temp = new HashMap<>();
        for(Map.Entry<E, Integer> entry: map.entrySet()) {
            if(other.contains(entry.getKey())) {
                //TODO Finish Mutiset
            }
        }
    }

    @Override
    public int getMultiplicity(E elem) {
        return contains(elem) ? map.get(elem) : 0;
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.size();
    }

    @Override
    public int size() {
        int sum = 0;
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    @Override
    public Set<E> toSet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
