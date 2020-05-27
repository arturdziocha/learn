package hyperskill.projects.linear.stage5;

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
        return "" + ((double) 0 == real ? "" : real)
                + ((double) 0 == imaginary ? "" : (imaginary < 0 ? imaginary : "+" + imaginary) + "i");
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