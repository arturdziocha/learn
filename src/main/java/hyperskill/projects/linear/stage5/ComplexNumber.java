package hyperskill.projects.linear.stage5;

import java.util.Arrays;

public class ComplexNumber {
    private double real;
    private double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.getReal(), imaginary + other.getImaginary());
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.getReal(), imaginary - other.getImaginary());
    }

    /**
     * @param other Other number
     * @return new ComplexNumber
     *         https://www.mathsisfun.com/numbers/complex-numbers.html
     */
    public ComplexNumber multiply(ComplexNumber other) {

        return new ComplexNumber(real * other.getReal() - imaginary * other.getImaginary(),
                real * other.getImaginary() + imaginary * other.getReal());
    }

    /**
     * @param other Other number
     * @return new ComplexNumber
     *         https://www.mathsisfun.com/numbers/complex-numbers.html
     */
    public ComplexNumber divide(ComplexNumber other) {
        ComplexNumber conjugated = other.conjugate();
        double aReal = real * conjugated.getReal() + (imaginary * conjugated.imaginary) * -1;
        double aImaginary = real * conjugated.getImaginary() + imaginary * conjugated.getReal();
        double bReal = other.getReal() * conjugated.getReal() + (other.imaginary * conjugated.getImaginary()) * -1;

        return new ComplexNumber(aReal / bReal, aImaginary / bReal);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    public boolean isAllZero() {
        return real == 0.0 && imaginary == 0.0;
    }

    @Override
    public String toString() {
        // DecimalFormat format = new DecimalFormat("#.###");
        // DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        // sym.setDecimalSeparator('.');
        // format.setDecimalFormatSymbols(sym);
        // String r = format.format(real);
        // String im = format.format(imaginary);

        // return "" + (imaginary == 0.0 ? real : real == 0.0 ? imaginary + "i"
        // : "");
        return "" + (real == 0.0 ? "" : real)
                + (imaginary == 0.0 ? "" : imaginary > 0.0 ? "+" + imaginary + "i" : imaginary + "i");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ComplexNumber that = (ComplexNumber) o;

        if (Double.compare(that.real, real) != 0)
            return false;
        return Double.compare(that.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imaginary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static ComplexNumber parse(String number) {

        boolean firstNegative = number.charAt(0) == '-';
        boolean secondNegative = number.substring(1).contains("-");
        double re = 0.0;
        double im = 0.0;
        String[] values;
        if (firstNegative) {
            values = number.substring(1).split("[+-]");
        } else {
            values = number.split("[+-]");
        }

        if (values.length == 1) {
            if (values[0].contains("i")) {
                if (values[0].charAt(0) == 'i') {
                    values[0] = "1" + values[0];
                }
                if (firstNegative) {
                    values[0] = "-" + values[0];
                }

                im = Double.parseDouble(values[0].substring(0, values[0].length() - 1));
            } else {
                if (firstNegative) {
                    values[0] = "-" + values[0];
                }
                re = Double.parseDouble(values[0]);
            }

        } else {
            if (firstNegative) {
                values[0] = "-" + values[0];
            }
            if (values[1].charAt(0) == 'i') {
                values[1] = "1" + values[1];
            }
            if (secondNegative) {
                values[1] = "-" + values[1];
            }
            re = Double.parseDouble(values[0]);
            im = Double.parseDouble(values[1].substring(0, values[1].length() - 1));
        }
        ComplexNumber complexNumber = new ComplexNumber(re, im);
        return complexNumber;

    }

}