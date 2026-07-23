// HugeIntegerTest.java
public class HugeIntegerTest {
    public static void main(String[] args) {
        HugeInteger h1 = new HugeInteger("123456789012345678901234567890");
        HugeInteger h2 = new HugeInteger("987654321");
        HugeInteger zero = new HugeInteger("0");

        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);

        System.out.println("\nh1 + h2 = " + h1.add(h2));
        System.out.println("h1 - h2 = " + h1.subtract(h2));

        System.out.printf("%nh1.isEqualTo(h2): %b%n", h1.isEqualTo(h2));
        System.out.printf("h1.isGreaterThan(h2): %b%n", h1.isGreaterThan(h2));
        System.out.printf("h1.isLessThan(h2): %b%n", h1.isLessThan(h2));
        System.out.printf("h2.isLessThanOrEqualTo(h2): %b%n", h2.isLessThanOrEqualTo(h2));
        System.out.printf("zero.isZero(): %b%n", zero.isZero());
        System.out.printf("h1.isZero(): %b%n", h1.isZero());
    }
}
