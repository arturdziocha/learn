package hyperskill.projects.linear.stage5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexNumberTest {

    @Test
    @DisplayName("Parse should return Complex 0 0")
    void firstTest() {
        // Given
        String string = "0";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(0, 0), complexNumber);
    }

    @Test
    @DisplayName("Given real 1 should return Complex{real=1, imaginary=0}")
    void secondTest() {
        // Given
        String string = "1";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(1, 0), complexNumber);
    }

    @Test
    @DisplayName("Given real -1 should return Complex{real=-1, imaginary=0}")
    void thirdTest() {
        // Given
        String string = "-1";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(-1, 0), complexNumber);
    }

    @Test
    @DisplayName("Given 1.01 should return Complex{real=1.01, imaginary=0}")
    void fourTest() {
        // Given
        String string = "1.01";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(1.01, 0), complexNumber);
    }

    @Test
    @DisplayName("Given 1.01+3.24i  should return Complex{real=1.01, imaginary=3.24}")
    void fiveTest() {
        // Given
        String string = "1.01+3.24i";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(1.01, 3.24), complexNumber);
    }

    @Test
    @DisplayName("Given -1.01-3.24i  should return Complex{real=-1.01, imaginary=-3.24}")
    void sixTest() {
        // Given
        String string = "-1.01-3.24i";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(-1.01, -3.24), complexNumber);
    }

    @Test
    @DisplayName("Given -3.24i  should return Complex{real=0.0, imaginary=-3.24}")
    void sevenTest() {
        // Given
        String string = "-3.24i";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(0.0, -3.24), complexNumber);
    }

    @Test
    @DisplayName("Given 3.24i  should return Complex{real=0.0, imaginary=-3.24}")
    void eightTest() {
        // Given
        String string = "3.24i";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        Assertions.assertEquals(new ComplexNumber(0.0, 3.24), complexNumber);
    }

    @Test
    @DisplayName("Given String -1.01-3.24i to parse equals Complex.toString()")
    void nineTest() {
        // Given
        String string = "-1.01-3.24i";
        // When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        // Then
        assertEquals(string, complexNumber.toString());
    }

    @Test
    @DisplayName("Conjugate ComplexNumber")
    void tenTest() {
        //Given
        String string = "-1.01-3.24i";
        //When
        ComplexNumber number = ComplexNumber.parse(string);
        ComplexNumber conjugated = number.conjugate();
        assertEquals("-1.01+3.24i", conjugated.toString());
    }

    @Test
    @DisplayName("Multiply test")
    void multiplyTest() {
        //Given
        ComplexNumber first = ComplexNumber.parse("3+2i");
        ComplexNumber second = ComplexNumber.parse("1+7i");
        //When
        ComplexNumber multipled = first.multiply(second);
        //Then
        assertEquals(new ComplexNumber(-11, 23), multipled);
    }

    @Test
    @DisplayName("Divide test")
    void elevenTest() {
        //Given
        ComplexNumber first = ComplexNumber.parse("1");
        ComplexNumber second = ComplexNumber.parse("1");
        //When
        ComplexNumber divided = first.divide(second);
        //Then
        assertEquals(new ComplexNumber((double) 6/25, (double) 17/25), divided);
    }

}
