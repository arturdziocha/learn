package hyperskill.projects.linear.stage5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return real + imaginary < 0 ? "" : "+" + imaginary + "i";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(imaginary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(real);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(imaginary) != Double.doubleToLongBits(other.imaginary))
            return false;
        if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
            return false;
        return true;
    }

    public static ComplexNumber parse(String number) {
        String regex = "[-+]?(\\d+(\\.\\d*)?|\\.\\d+)";
        Pattern doublePattern = Pattern.compile(regex);
        Matcher matcher = doublePattern.matcher(number);
        double r = 0.0;
        double i = 0.0;
        if (matcher.lookingAt()) {
            r = Double.parseDouble(matcher.group());

            number = number.substring(matcher.end());
            matcher = doublePattern.matcher(number);
            if (matcher.lookingAt()) {
                i = Double.parseDouble(matcher.group());
            } else {
                i = 0.0;
            }
        }
        System.out.println("real=" + r + ", imaginary=" + i);
        String m = number.contains("-") ? "-" : "";
        double[] numbers = Arrays
                .stream(number.split("[+-]"))
                .mapToDouble(s -> s.isEmpty() ? Double.valueOf(0)
                        : s.contains("i") ? Double.valueOf(m + s.substring(0, s.length() - 1)) : Double.valueOf(s))
                .toArray();
        // System.out.println(Arrays.toString(numbers));
        return new ComplexNumber(numbers[0], numbers.length == 1 ? numbers[1] : 0.0);
    }
}