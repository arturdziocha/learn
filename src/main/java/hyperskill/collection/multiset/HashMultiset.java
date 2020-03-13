package hyperskill.collection.multiset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 To deal with various tasks you may need collections which are not included in standard Java libraries. In this case, let’s create a collection that represents the concept of multiset, which is a generalization of a set. 

Multiset is a collection that supports order-independent equality. As with sets, the order of the elements in a multiset does not matter. Unlike sets, multiset can store duplicate elements. The number of instances of an element is called multiplicity.

For example, let’s consider the following multiset:

{a, a, b, b, b, c}

The multiplicity of a is 2, the multiplicity of b is 3, the multiplicity of c is 1. If a multiset does not have an element, the multiplicity of it is 0.

In this task, you should implement all methods of the generic class HashMultiset according to its interface. This class is based on the HashMap class. The description of the methods is provided in the interface. It will help you to understand the common Multiset operations (add, remove, union, intersection and so on). Feel free to use additional methods if it is necessary for your solution.

Hint

If you have difficulties with union and intersection operations, look at the examples below:
Union

Initial multisets:

{1, 2, 2, 2, 4}

{2, 2, 4, 5, 6}

Result:

{1, 2, 2, 2, 4, 5, 6}


Intersection

 

Initial multisets:

{1, 2, 2, 2, 4}

{2, 2, 4, 5, 6}

Result:

{2, 2, 4}
 */
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
            if (map.containsKey(e)) {
                int howManyInMap = getMultiplicity(e);
                int howManyInOther = other.getMultiplicity(e);
                map.replace(e, howManyInMap > howManyInOther ? howManyInMap : howManyInOther);

            } else {
                map.put(e, other.getMultiplicity(e));
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        Map<E, Integer> temp = new HashMap<>();
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            if (other.contains(entry.getKey())) {
                int howMany = other.getMultiplicity(entry.getKey());
                temp.put(entry.getKey(), entry.getValue() > howMany ? howMany : entry.getValue());
            }
        }
        this.map = temp;
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
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
