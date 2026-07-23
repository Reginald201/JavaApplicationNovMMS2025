// Rectangle.java
// Rectangle class with length and width, each defaulting to 1.
public class Rectangle {
    private double length;
    private double width;

    // no-argument constructor: length and width default to 1
    public Rectangle() {
        this(1.0, 1.0);
    }

    // constructor: initializes length and width
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // set length, ensuring it's a floating-point number in (0.0, 20.0)
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0)
            this.length = length;
        else
            throw new IllegalArgumentException(
                "length must be greater than 0.0 and less than 20.0");
    }

    public double getLength() {
        return length;
    }

    // set width, ensuring it's a floating-point number in (0.0, 20.0)
    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0)
            this.width = width;
        else
            throw new IllegalArgumentException(
                "width must be greater than 0.0 and less than 20.0");
    }

    public double getWidth() {
        return width;
    }

    // calculate and return perimeter
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // calculate and return area
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[length=%.2f, width=%.2f]", length, width);
    }
}
