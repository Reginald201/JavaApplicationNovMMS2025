// MyLine.java
// Represents a colored line segment that can draw itself.
// Uses a separate static import for each static member of class Math
// that's used in this example (sqrt and pow), per Exercise 8.9.
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class MyLine {
    private int x1, y1, x2, y2;
    private Color color;

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    // length of the line, computed with the statically-imported sqrt and pow
    public double length() {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }
}
