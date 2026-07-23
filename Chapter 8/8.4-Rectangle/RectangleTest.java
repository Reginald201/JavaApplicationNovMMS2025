// RectangleTest.java
// Tests class Rectangle.
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5.0, 3.5);

        System.out.println("r1: " + r1);
        System.out.printf("Perimeter: %.2f, Area: %.2f%n%n",
            r1.getPerimeter(), r1.getArea());

        System.out.println("r2: " + r2);
        System.out.printf("Perimeter: %.2f, Area: %.2f%n%n",
            r2.getPerimeter(), r2.getArea());

        try {
            r2.setLength(-4.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            r2.setWidth(25.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
