// Complex.java
// Represents and performs arithmetic with complex numbers.
public class Complex {
    private double realPart;
    private double imaginaryPart;

    // no-argument constructor: defaults to 0 + 0i
    public Complex() {
        this(0.0, 0.0);
    }

    // constructor initializes an object when it's declared
    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // add two Complex numbers
    public Complex add(Complex other) {
        return new Complex(this.realPart + other.realPart,
            this.imaginaryPart + other.imaginaryPart);
    }

    // subtract two Complex numbers
    public Complex subtract(Complex other) {
        return new Complex(this.realPart - other.realPart,
            this.imaginaryPart - other.imaginaryPart);
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    // print Complex numbers in the form (realPart, imaginaryPart)
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", realPart, imaginaryPart);
    }
}
