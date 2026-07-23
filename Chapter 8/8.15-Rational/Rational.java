// Rational.java
// Performs arithmetic with fractions, always storing them in reduced form.
public class Rational {
    private int numerator;
    private int denominator;

    // no-argument constructor: defaults to 0/1
    public Rational() {
        this(0, 1);
    }

    // constructor: stores the fraction in reduced form
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be 0");
        }

        // keep the sign in the numerator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int gcd = gcd(Math.abs(numerator), denominator);
        gcd = (gcd == 0) ? 1 : gcd;

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    // a) add two Rational numbers, static method
    public static Rational add(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    // b) subtract two Rational numbers, static method
    public static Rational subtract(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    // c) multiply two Rational numbers, static method
    public static Rational multiply(Rational r1, Rational r2) {
        return new Rational(r1.numerator * r2.numerator,
            r1.denominator * r2.denominator);
    }

    // d) divide two Rational numbers, static method
    public static Rational divide(Rational r1, Rational r2) {
        if (r2.numerator == 0) {
            throw new ArithmeticException("cannot divide by a zero-valued Rational");
        }
        return new Rational(r1.numerator * r2.denominator,
            r1.denominator * r2.numerator);
    }

    // e) String representation as a/b
    public String toFractionString() {
        return numerator + "/" + denominator;
    }

    // f) String representation in floating-point format with given precision
    public String toFloatingString(int precision) {
        return String.format("%." + precision + "f",
            (double) numerator / denominator);
    }

    // default floating-point representation, 4 digits of precision
    public String toFloatingString() {
        return toFloatingString(4);
    }

    @Override
    public String toString() {
        return toFractionString();
    }
}
