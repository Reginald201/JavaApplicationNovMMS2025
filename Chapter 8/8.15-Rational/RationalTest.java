// RationalTest.java
public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(2, 4);   // should reduce to 1/2
        Rational r2 = new Rational(1, 3);
        Rational r3 = new Rational();        // default 0/1

        System.out.println("r1 (2/4 reduced) = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 (default) = " + r3);

        Rational sum = Rational.add(r1, r2);
        Rational difference = Rational.subtract(r1, r2);
        Rational product = Rational.multiply(r1, r2);
        Rational quotient = Rational.divide(r1, r2);

        System.out.println("\nr1 + r2 = " + sum + " = " + sum.toFloatingString(4));
        System.out.println("r1 - r2 = " + difference + " = " + difference.toFloatingString(4));
        System.out.println("r1 * r2 = " + product + " = " + product.toFloatingString(4));
        System.out.println("r1 / r2 = " + quotient + " = " + quotient.toFloatingString(4));

        System.out.println("\nr1 as floating point (2 digits): " + r1.toFloatingString(2));
    }
}
