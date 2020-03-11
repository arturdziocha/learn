package snippets.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShiftigTest {

    @Test
    public void test1() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Assertions.assertEquals("5 1 2 3 4", Shifting.shift(5, arr));
    }
}
