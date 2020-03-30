package snippets.maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class FindMaxInMap {
    public <K, V extends Comparable<V>> V maxUsingCollectionsMaxAndLambda(Map<K, V> map) {
        Entry<K, V> maxEntry = Collections
                .max(map.entrySet(), (Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
        return maxEntry.getValue();
    }

    public <K, V extends Comparable<V>> V maxUsingStreamAndLambda(Map<K, V> map) {
        Optional<Entry<K, V>> maxEntry = map
                .entrySet()
                .stream()
                .max((Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));

        return maxEntry.get().getValue();
    }

    public <K, V extends Comparable<V>> V maxUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Entry<K, V>> maxEntry = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getValue();
    }
}
