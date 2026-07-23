// DrawPanel.java
// Rewritten to use a separate static import declaration for each static
// member of class Math used in the example (min and max, used to keep
// generated coordinates comfortably inside the panel bounds).
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class DrawPanel extends JPanel {
    private SecureRandom randomNumbers = new SecureRandom();
    private MyLine[] lines; // array of lines

    // constructor, creates a panel with random shapes
    public DrawPanel() {
        setBackground(Color.WHITE);
        lines = new MyLine[5 + randomNumbers.nextInt(5)];

        // create lines
        for (int count = 0; count < lines.length; count++) {
            // generate random coordinates, clamped to a safe range with
            // the statically-imported min/max
            int x1 = max(0, min(299, randomNumbers.nextInt(300)));
            int y1 = max(0, min(299, randomNumbers.nextInt(300)));
            int x2 = max(0, min(299, randomNumbers.nextInt(300)));
            int y2 = max(0, min(299, randomNumbers.nextInt(300)));

            // generate a random color
            Color color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));

            // add the line to the list of lines to be displayed
            lines[count] = new MyLine(x1, y1, x2, y2, color);
        }
    }

    // for each shape in the array, draw the individual shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyLine line : lines)
            line.draw(g);
    }
} // end class DrawPanel
