package hyperskill.collection.multiset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMultisetTest {
    private Multiset<Integer> first;
    private Multiset<Integer> second;

    @BeforeEach
    public void setUp() {
        first = new HashMultiset<>();
        first.add(1);
        first.add(2);
        first.add(2);
        first.add(2);
        first.add(4);

        second = new HashMultiset<>();
        second.add(2);
        second.add(2);
        second.add(4);
        second.add(5);
        second.add(6);
    }
    @Test
    public void testRemoveElement(){
        first.remove(2);
        assertEquals(2, first.getMultiplicity(2));
    }

    @Test
    public void sumAfterUnion() {
        first.union(second);
        assertEquals(7, first.size());
        assertEquals(5, first.numberOfUniqueElements());
        assertEquals(3, first.getMultiplicity(2));
    }
    @Test
    public void testNumberOfUniqueElements() {
        assertEquals(3, first.numberOfUniqueElements());
        assertEquals(4, second.numberOfUniqueElements());
    }
    @Test
    public void sumAfterIntersect() {
        System.out.println(first);
        System.out.println(second);
        first.intersect(second);
        assertEquals(3, first.size());
        System.out.println(first);
        System.out.println(first.numberOfUniqueElements());
        //assertEquals(2, first.numberOfUniqueElements());
    }

}
