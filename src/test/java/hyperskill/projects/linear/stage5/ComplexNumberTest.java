package hyperskill.projects.linear.stage5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComplexNumberTest {

    @Test
    @DisplayName("Parse should return Complex 0 0")
    void firstTest() {
        //Given
        String string = "0";
        //When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        //Then
        Assertions.assertEquals(complexNumber, new ComplexNumber(0, 0));
    }
    @Test
    @DisplayName("Given real 1 should return Complex{real=1, imaginary=0}")
    void secondTest() {
        //Given
        String string = "1";
        //When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        //Then
        Assertions.assertEquals(complexNumber, new ComplexNumber(1, 0));
    }
    @Test
    @DisplayName("Given real -1 should return Complex{real=-1, imaginary=0}")
    void thirdTest() {
        //Given
        String string = "-1";
        //When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        //Then
        Assertions.assertEquals(new ComplexNumber(-1, 0), complexNumber);
    }
    @Test
    @DisplayName("Given real 1.01 should return Complex{real=-1.01, imaginary=0}")
    void fourTest() {
        //Given
        String string = "1.01";
        //When
        ComplexNumber complexNumber = ComplexNumber.parse(string);
        //Then
        Assertions.assertEquals(complexNumber, new ComplexNumber(1.01, 0));
    }

}
