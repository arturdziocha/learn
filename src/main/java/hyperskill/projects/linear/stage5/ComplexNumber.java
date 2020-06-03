package hyperskill.projects.linear.stage5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ComplexNumber {
    public static final double EPSILON = 0.001;
    private double real;
    private double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(String s)  throws NumberFormatException{
        final String[] strs = split(s);
        if (strs[1].contains("i")) {
            strs[1] = strs[1].replace("i", "1");
        }
        if (strs[1].equals("-")) {
            strs[1] = "-1";
        }
        if (strs[1].equals("+")) {
            strs[1] = "1";
        }
        real = Double.parseDouble(strs[0]);
        imaginary = Double.parseDouble(strs[1]);
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

    private String[] split(String s) throws NumberFormatException {
        if (s.equals("i")) {
            return new String[] { "0", "1" };
        }
        if (s.equals("-i")) {
            return new String[] { "0", "-1" };
        }
        String realString = "0";
        String imagString = "0";
        int i = 1;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                realString = s.substring(0, i);
                imagString = s.substring(i, s.length() - 1);
                if (s.charAt(s.length() - 1) != 'i') {
                    throw new NumberFormatException("can't parse complex");
                }
                break;
            }
            if ('i' == s.charAt(i)) {
                if (i != s.length() - 1) {
                    throw new NumberFormatException("can't parse complex");
                }
                imagString = s.substring(0, i);
                break;
            }
        }
        if (i == s.length()) {
            realString = s;
        }
        if (imagString.length() == 0) {
            imagString = "1";
        }
        return new String[] { realString, imagString };
    }

    @Override
    public String toString() {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        final DecimalFormat realFormat = new DecimalFormat("0.####", symbols);
        final DecimalFormat imagFormat = new DecimalFormat("0.####i", symbols);
        if (Math.abs(imaginary) < EPSILON) {
            return realFormat.format(real);
        }
        if (Math.abs(real) < EPSILON) {
            return imagFormat.format(imaginary);
        }
        imagFormat.setPositivePrefix("+");
        return String.format("%s%s", realFormat.format(real), imagFormat.format(imaginary));
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
    /*
     * public static ComplexNumber parse(String s) { if(s.equals("i")) { return
     * new ComplexNumber(0, 1); } if(s.equals("-i")) { return new
     * ComplexNumber(0, -1); } boolean firstNegative = s.charAt(0) == '-';
     * boolean secondNegative = s.substring(1).contains("-"); double re = 0.0;
     * double im = 0.0; String[] values; if (firstNegative) { values =
     * s.substring(1).split("[+-]"); } else { values = s.split("[+-]"); } if
     * (values.length == 1) { if (values[0].contains("i")) { if
     * (values[0].charAt(0) == 'i') { values[0] = "1" + values[0]; } if
     * (firstNegative) { values[0] = "-" + values[0]; } im =
     * Double.parseDouble(values[0].substring(0, values[0].length() - 1)); }
     * else { if (firstNegative) { values[0] = "-" + values[0]; } re =
     * Double.parseDouble(values[0]); } } else { if (firstNegative) { values[0]
     * = "-" + values[0]; } if (values[1].charAt(0) == 'i') { values[1] = "1" +
     * values[1]; } if (secondNegative) { values[1] = "-" + values[1]; } re =
     * Double.parseDouble(values[0]); im =
     * Double.parseDouble(values[1].substring(0, values[1].length() - 1)); }
     * ComplexNumber complexNumber = new ComplexNumber(re, im); return
     * complexNumber; }
     */
}