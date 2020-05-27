package hyperskill.projects.linear.stage5;

import java.text.DecimalFormat;

import javax.crypto.spec.IvParameterSpec;

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

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        String r = format.format(real);
        String im = format.format(imaginary);
        return "" + r + (imaginary < 0 ? im : "+" + im) + "i";
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

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.getReal(), imaginary + other.getImaginary());
    }

    public ComplexNumber substract(ComplexNumber other) {
        return new ComplexNumber(real - other.getReal(), imaginary - other.getImaginary());
    }

    public ComplexNumber multiply(ComplexNumber other) {
        if (imaginary == 0 || other.getImaginary() == 0) {
            return new ComplexNumber(real * other.real, 0.0);
        }
        return new ComplexNumber(real * other.real - imaginary * other.getImaginary(),
                real * other.imaginary + imaginary * other.real);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double c = other.getReal();
        double d = other.getImaginary();

        double zReal2 = 0.0;
        if (c != 0.0) {
            zReal2 = StrictMath.pow(c, 2);
        }
        double zimag2 = 0.0;
        if (d != 0.0) {
            zimag2 = StrictMath.pow(d, 2);
        }
        double ac = real * c;
        double bd = imaginary * d;
        double bc = imaginary * c;
        double ad = real * d;
        return new ComplexNumber((ac + bd) / (zReal2 + zimag2), (bc - ad) / (zReal2 + zimag2));
    }

    public boolean isAllZero() {
        return real == 0.0 && imaginary == 0.0;
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
            if (secondNegative) {
                values[1] = "-" + values[1];
            }
            re = Double.parseDouble(values[0]);
            im = Double.parseDouble(values[1].substring(0, values[1].length() - 1));
        }

        return new ComplexNumber(re, im);

    }

}