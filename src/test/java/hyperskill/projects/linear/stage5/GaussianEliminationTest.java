package hyperskill.projects.linear.stage5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GaussianEliminationTest {
    private GaussianElimination elimination;
    private final String noSolutions = "No solutions";
    private final String infiniteSolutions = "Infinitely many solutions";


    @BeforeEach
    void setUp() {
        this.elimination = new GaussianElimination();
    }

    @DisplayName("Should return Double array")
    @Test
    void test1() {
        // Given
        String testString = "3 3\n" + "1 1 2 9\n" + "2 4 -3 1\n" + "3 6 -5 0";
        ComplexNumber[] expected = toComplex(new Double[]{1d, 2d, 3d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 2")
    @Test
    void test2() {
        // Given
        String testString = "2 2\n" + "1 0 1\n" + "0 1 1";
        ComplexNumber[] expected = toComplex(new Double[]{1d, 1d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 3")
    @Test
    void test3() {
        // Given
        String testString = "2 2\n" + "2 0 2\n" + "0 2 2";
        ComplexNumber[] expected = toComplex(new Double[]{1d, 1d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 4")
    @Test
    void test4() {
        // Given
        String testString = "2 2\n" + "1 2 1\n" + "3 4 1";
        ComplexNumber[] expected = toComplex(new Double[]{-1d, 1d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 5")
    @Test
    void test5() {
        // Given
        String testString = "20 20\n" + "26 90 17 67 68 9 60 38 37 38 76 14 33 94 88 58 99 84 9 45 18\n"
                + "37 34 20 53 10 61 75 49 91 84 55 84 84 81 30 22 42 76 33 27 2\n"
                + "99 69 63 57 39 45 33 43 99 26 25 24 80 91 62 90 54 77 88 32 94\n"
                + "37 40 14 5 47 30 5 21 36 77 57 38 29 3 61 12 81 19 39 56 9\n"
                + "36 73 71 39 9 9 31 10 84 7 13 45 9 34 2 14 88 43 17 4 86\n"
                + "31 29 76 89 26 35 11 55 37 5 41 96 19 18 100 20 21 49 83 5 20\n"
                + "18 18 25 70 79 74 30 66 41 93 63 2 90 4 46 1 77 89 21 47 52\n"
                + "32 62 27 80 57 10 35 44 97 18 58 19 5 81 33 54 83 66 25 75 75\n"
                + "56 53 13 91 30 11 72 52 13 86 73 88 94 20 25 77 90 75 73 52 36\n"
                + "63 9 40 40 35 90 55 92 12 98 34 37 64 21 67 91 15 65 82 87 30\n"
                + "71 5 65 64 6 20 9 81 40 56 39 93 74 55 83 81 74 2 58 86 58\n"
                + "13 50 31 86 73 36 83 27 37 96 37 28 75 91 15 78 90 56 57 18 18\n"
                + "34 9 51 11 92 54 25 91 61 69 37 37 89 91 95 50 10 16 69 71 66\n"
                + "25 16 79 36 6 28 51 100 5 28 97 23 44 32 50 2 96 18 5 48 44\n"
                + "80 38 47 96 41 72 85 79 2 3 96 14 2 65 97 38 76 73 88 59 89\n"
                + "31 98 88 52 49 68 46 79 26 30 31 76 84 87 27 16 66 55 78 2 46\n"
                + "57 2 32 78 70 7 95 56 77 97 49 14 74 7 85 48 83 59 71 5 44\n"
                + "4 64 4 43 54 99 77 7 72 82 27 22 29 94 53 48 65 88 26 86 42\n"
                + "69 59 62 63 42 29 73 18 82 78 48 60 84 73 84 9 82 53 14 1 12\n"
                + "98 2 47 62 69 11 28 14 83 32 94 24 71 1 16 91 53 50 38 26 17";
        ComplexNumber[] expected = toComplex(new Double[]{0.5428d, -2.3923d, 1.5789d, -1.3679d, 0.6433d, -1.7531d,
                -0.0432d, -0.7503d, -0.8245d, -0.4562d, -1.2163d, 0.3093d, -0.1105d, 1.1717d, -0.5873d, -1.3933d,
                1.1229d, 3.0693d, 1.1995d, 1.5399});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 6")
    @Test
    void test6() {
        // Given
        String testString = "20 20\n"
                + "0.11 0.62 0.28 0.94 0.53 0.94 0.06 1.0 0.61 0.45 0.03 0.79 0.87 0.32 0.66 0.5 0.14 0.82 0.44 0.13 0.43\n"
                + "0.8 0.7 0.16 0.09 0.4 0.63 0.46 1.0 0.9 0.14 0.03 0.8 0.98 0.71 0.67 0.42 0.73 0.01 0.75 0.59 0.64\n"
                + "0.99 0.01 0.45 0.85 0.17 0.14 0.58 0.27 0.96 0.52 0.74 0.89 0.72 0.93 0.22 0.9 0.41 0.78 0.56 0.67 0.84\n"
                + "0.19 0.35 0.98 0.28 0.74 0.42 0.82 0.51 0.33 0.84 0.85 0.46 0.71 0.93 0.11 0.88 0.08 0.72 0.68 0.73 0.82\n"
                + "0.59 0.52 0.17 0.62 0.9 0.66 0.23 0.47 0.29 0.78 0.43 0.99 0.67 0.63 0.38 0.85 0.72 0.6 0.97 0.75 0.96\n"
                + "0.66 0.24 0.9 0.43 0.39 0.31 0.64 0.17 0.75 0.62 0.38 0.38 0.41 0.38 0.41 0.9 0.29 0.21 0.54 0.87 0.35\n"
                + "0.06 0.57 0.04 0.74 0.27 0.75 0.0 0.52 0.42 0.85 0.35 0.19 0.57 0.42 0.93 0.77 0.09 0.4 0.83 0.39 0.46\n"
                + "0.87 0.77 0.71 0.61 0.73 0.28 0.02 0.96 0.29 0.37 0.27 0.43 0.02 0.82 0.16 0.34 0.49 0.9 0.35 0.11 0.18\n"
                + "0.87 0.7 0.4 0.27 0.35 0.57 0.36 0.89 0.09 0.78 0.64 0.84 0.06 0.69 0.41 0.4 0.64 0.55 0.81 0.69 0.27\n"
                + "0.34 0.49 0.27 1.0 0.78 0.01 0.58 0.87 0.47 0.27 0.23 0.35 0.55 0.06 0.67 0.74 0.17 0.68 0.75 0.76 0.16\n"
                + "0.38 0.71 0.29 0.94 0.84 0.46 0.98 0.0 0.89 0.58 0.09 0.04 0.04 0.66 0.21 0.58 0.8 0.96 0.78 0.67 0.11\n"
                + "0.36 0.37 0.1 0.36 0.46 0.15 0.99 0.38 0.39 0.52 0.76 0.68 0.94 0.31 0.21 0.99 0.78 0.17 0.15 0.06 0.06\n"
                + "0.94 0.3 0.35 0.24 0.79 0.86 0.7 0.81 0.2 0.23 0.52 0.91 0.55 0.21 0.47 0.44 0.1 0.97 0.61 0.13 0.03\n"
                + "0.03 0.28 0.32 0.06 0.54 0.08 1.0 0.69 0.29 0.48 0.84 0.37 0.74 0.13 0.2 0.75 0.46 0.03 0.68 0.72 0.33\n"
                + "0.43 0.78 0.69 0.91 0.8 0.68 0.46 0.9 0.65 0.19 0.81 0.28 0.3 0.75 0.94 0.05 0.65 0.29 0.61 0.74 0.68\n"
                + "0.01 0.46 0.38 0.72 0.97 0.39 0.88 0.62 0.93 0.26 0.58 0.02 0.95 0.49 0.69 0.64 0.47 0.53 0.43 0.1 0.09\n"
                + "0.83 0.72 0.84 0.41 0.53 0.53 0.67 0.09 0.49 0.42 0.88 0.14 0.09 0.02 0.49 0.29 0.29 0.17 0.08 0.9 0.45\n"
                + "0.54 0.57 0.53 0.23 0.78 0.89 0.24 0.98 0.7 0.75 0.46 0.85 0.39 0.58 0.36 0.29 0.54 0.83 0.97 0.62 0.34\n"
                + "0.3 0.64 0.71 0.07 0.03 0.76 0.25 0.34 0.97 0.93 0.48 0.57 0.98 0.33 0.4 0.18 0.01 0.81 0.38 0.87 0.95\n"
                + "0.25 0.7 0.07 0.4 0.67 0.84 0.12 0.43 0.61 0.7 0.89 0.88 0.48 0.14 0.32 0.98 0.15 0.87 0.34 0.81 0.37";
        ComplexNumber[] expected = toComplex(new Double[]{0.2182d, 0.3886d, 0.2337d, 0.5804d, -0.1867d, 0.3536d,
                -0.5597d, -0.4706d, -0.3946d, -0.4577d, 0.371d, -0.1959d, 1.1403d, 0.2808d, -0.8712d, -0.3355d,
                -0.1309d, -0.3008d, 0.6355d, 0.4716d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 7. Check is the first element is zero")
    @Test
    void test7() {
        // Given
        String testString = "2 2\n" + "0 1 1\n" + "1 0 1";
        ComplexNumber[] expected = toComplex(new Double[]{1d, 1d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 8")
    @Test
    void test8() {
        // Given
        String testString = "2 2\n" + "0 1 1\n" + "1 0 2";
        ComplexNumber[] expected = toComplex(new Double[]{2d, 1d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));

    }

    @DisplayName("Test 9")
    @Test
    void test9() {
        // Given
        String testString = "6 6\n" + "2 6 1 3 9 1 6\n" + "9 2 4 3 6 1 5\n" + "6 5 9 1 4 2 6\n" + "4 1 1 2 9 2 4\n"
                + "5 4 6 2 3 1 6\n" + "3 5 4 1 7 9 6";
        ComplexNumber[] expected = toComplex(new Double[]{-0.5175d, -0.1523d, 0.7669d, 2.0115d, 0.0958d, 0.2849d});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 10")
    @Test
    void test10() {
        // Given
        String testString = "6 6\n" + "0 6 1 3 9 1 6\n" + "9 0 4 3 6 1 5\n" + "6 5 0 1 4 2 6\n" + "4 1 1 0 9 2 4\n"
                + "5 4 6 2 0 1 6\n" + "3 5 4 1 7 0 6";
        ComplexNumber[] expected = toComplex(new Double[]{0.241, 0.5984, 0.2851, 0.1325, 0.1446, 0.4257,});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 11")
    @Test
    void test11() {
        // Given
        String testString = "6 6\n" + "1 6 1 1 9 1 6\n" + "0 1 4 3 2 1 5\n" + "0 0 0 1 4 2 6\n" + "0 0 0 2 9 2 4\n"
                + "0 0 0 2 3 1 6\n" + "0 0 5 1 7 9 6";
        ComplexNumber[] expected = toComplex(new Double[]{-65.8154, 13.0615, -4.4, 2.6154, -0.9231, 3.5385,});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 12")
    @Test
    void test12() {
        // Given
        String testString = "6 6\n" + "1 6 1 1 9 1 6\n" + "0 1 4 3 2 1 5\n" + "0 0 0 0 0 2 6\n" + "0 0 0 0 2 2 4\n"
                + "0 0 0 9 2 1 6\n" + "0 0 7 1 7 9 6";
        ComplexNumber[] expected = toComplex(new Double[]{-50.381, 10.6508, -2.0794, 0.5556, -1d, 3d,});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 13. No solutions")
    @Test
    void test13() {
        // Given
        String testString = "3 4\n" +
                "0 1 2 9\n" +
                "0 1 3 1\n" +
                "1 0 6 0\n" +
                "2 0 2 0";

        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(noSolutions, elimination.getSolution());
    }

    @DisplayName("Test 14. There are 4 rows, 3 columns, and a single solution")
    @Test
    void test14() {
        // Given
        String testString = "3 4\n" +
                "1 1 2 9\n" +
                "0 1 3 1\n" +
                "0 0 6 0\n" +
                "0 0 0 0";
        ComplexNumber[] expected = toComplex(new Double[]{
                8d,
                1d,
                0d,});
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 15. There are 4 rows, 3 columns, and no solutions")
    @Test
    void test15() {
        // Given
        String testString = "3 4\n" +
                "1 1 2 9\n" +
                "0 1 3 1\n" +
                "0 0 6 0\n" +
                "0 0 0 7";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(noSolutions, elimination.getSolution());
    }

    @DisplayName("Test 16. There are 4 rows, 3 columns, and infinite solutions")
    @Test
    void test16() {
        // Given
        String testString = "3 4\n" +
                "1 1 2 9\n" +
                "0 1 3 1\n" +
                "0 2 6 2\n" +
                "0 0 0 0";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(infiniteSolutions, elimination.getSolution());
    }

    @DisplayName("Test 17. There are 3 rows, 4 columns, and no solutions")
    @Test
    void test17() {
        // Given
        String testString = "4 3\n" +
                "1 1 2 9 7\n" +
                "0 1 3 1 2\n" +
                "0 2 6 2 9";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(noSolutions, elimination.getSolution());
    }

    @DisplayName("Test 18. There are 3 rows, 4 columns, and infinite solutions")
    @Test
    void test18() {
        // Given
        String testString = "4 3\n" +
                "1 1 2 9 7\n" +
                "0 1 3 1 2\n" +
                "0 2 6 3 9";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(infiniteSolutions, elimination.getSolution());
    }

    @DisplayName("Test 19. There are 3 rows, 4 columns, and no solutions")
    @Test
    void test19() {
        // Given
        String testString = "4 3\n" +
                "1 0 0 0 1\n" +
                "0 0 0 0 0\n" +
                "1 0 0 0 0";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(noSolutions, elimination.getSolution());
    }

    @DisplayName("Test 20. This is the first test with complex numbers.")
    @Test
    void test20() {
        // Given
        String testString = "2 2\n" +
                "i 0 1\n" +
                "0 i 1";
        ComplexNumber[] expected = new ComplexNumber[]{
                new ComplexNumber(0, -1),
                new ComplexNumber(0, -1)};
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertArrayEquals(expected, toComplex(elimination.getSolution()));
    }

    @DisplayName("Test 21.  This test is about complex numbers")
    @Test
    void test21() {
        // Given
        String testString = "2 2\n" +
                "i -i i\n" +
                "-i i i";
        // When
        elimination.read(testString);
        elimination.solve();
        // Then
        assertEquals(noSolutions, elimination.getSolution());
    }

    private ComplexNumber[] toComplex(Double[] array) {
        return Arrays.stream(array).map(e -> new ComplexNumber(e, 0)).toArray(ComplexNumber[]::new);
    }

    private ComplexNumber[] toComplex(String string) {
        return Arrays.stream(string.split("\n")).map(i -> {
            System.out.println(i);
            return i.strip();
        }).map(ComplexNumber::new).toArray(ComplexNumber[]::new);
    }

}
