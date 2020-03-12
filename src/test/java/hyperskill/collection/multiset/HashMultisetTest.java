package hyperskill.collection.multiset;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void sumAfterUnion() {        
       first.union(second);
       assertEquals(7, first.size());
       assertEquals(5, first.numberOfUniqueElements());
       assertEquals(3, first.getMultiplicity(2));
    }

}
