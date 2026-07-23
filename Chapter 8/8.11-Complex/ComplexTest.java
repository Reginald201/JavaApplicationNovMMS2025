// ComplexTest.java
public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.0, 4.0);
        Complex c2 = new Complex(1.5, -2.5);
        Complex c3 = new Complex();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 (default) = " + c3);

        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);

        System.out.println("\nc1 + c2 = " + sum);
        System.out.println("c1 - c2 = " + difference);
    }
}
