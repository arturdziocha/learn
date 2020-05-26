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

    @Override
    public String toString() {
        return "" + ((double) 0 == real ? "" : real) + ((double) 0 == imaginary ? "" : imaginary + "i");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber that = (ComplexNumber) o;

        if (Double.compare(that.real, real) != 0) return false;
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
        String e;
        if (firstNegative) {
            e = number.substring(1);
        } else {
            e = number;
        }
        double[] values = Arrays.stream(e.split("[+-]")).mapToDouble(Double::valueOf).toArray();

        System.out.println(firstNegative ? "-" : "" + number + " " + Arrays.toString(values));
        return new ComplexNumber(values[0], 0);

    }
}
/*
double[] numbers = Arrays
                .stream(number.split("[+-]"))
                .mapToDouble(s -> s.isEmpty() ? Double.valueOf(0)
                        : s.contains("i") ? Double.valueOf(m + s.substring(0, s.length() - 1)) : Double.valueOf(s))
                .toArray();
        // System.out.println(Arrays.toString(numbers));
        return new ComplexNumber(numbers[0], numbers.length == 1 ? numbers[1] : 0.0);
 */

/*
boolean firstPositive = true;
boolean secondPositive = true;
if (s.charAt(0) == '-')     // See if first expr is negative
    firstPositive = false;
if (s.substring(1).contains("-"))
    secondPositive = false;
String[] split = s.split("[+-]");
if (split[0].equals("")) {  // Handle expr beginning with `-`
    split[0] = split[1];
    split[1] = split[2];
}
double realPart = 0;
double imgPart = 0;
if (split[0].contains("i")) // Assumes input is not empty
    imgPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0].substring(0,split[0].length - 1));
else
    realPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0]);
if (split.length > 1) {     // Parse second part of expr if it exists
    if (split[1].contains("i"))
        imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0,split[1].length - 1));
    else
        realPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1]);
}
// Use realPart and imgPart ...
System.out.println(realPart + (imgPart < 0 ? "" : "+") + imgPart + "i");
 */