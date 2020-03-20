package snippets.palindrom;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PalindromCheckerTest {    

    @Test
    void test() {
        assertTrue(PalindromChecker.isPalindrom("I lali masoni wydrom w mordy wino, sami lali!"));
    }
    @Test
    void test2() {
        assertTrue(PalindromChecker.isPalindrom("Albo nałowi ci Wałęsa masę ławic i woła: \"Nobla!\""));
    }

}
