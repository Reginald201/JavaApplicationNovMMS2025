public class TurtleGraphics{
    private static final int SIZE = 20;
    private static final int[][] floor = new int[SIZE][SIZE];

    // Direction vectors: 0 = right, 1 = down, 2 = left, 3 = up
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) {
        // Example "program": draws a 12-by-12 square, ends with pen up.
        int[] commands = {
                2,
                5, 12,
                3,
                5, 12,
                3,
                5, 12,
                3,
                5, 12,
                1,
                6,
                9
        };

        int row = SIZE / 2, col = SIZE / 2;
        int direction = 0; // start facing right
        boolean penDown = false;

        int i = 0;
        while (i < commands.length) {
            int command = commands[i];

            switch (command) {
                case 1: // pen up
                    penDown = false;
                    i++;
                    break;
                case 2: // pen down
                    penDown = true;
                    i++;
                    break;
                case 3: // turn right 90 degrees
                    direction = (direction + 1) % 4;
                    i++;
                    break;
                case 4: // turn left 90 degrees
                    direction = (direction + 3) % 4;
                    i++;
                    break;
                case 5: // move forward "distance" spaces
                    int distance = commands[++i];
                    for (int step = 0; step < distance; step++) {
                        if (penDown && row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
                            floor[row][col] = 1;
                        }
                        row += DR[direction];
                        col += DC[direction];
                    }
                    i++;
                    break;
                case 6: // display the floor
                    display();
                    i++;
                    break;
                case 9: // end of commands
                    return;
                default:
                    i++;
            }
        }
    }

    private static void display() {
        for (int[] rowArr : floor) {
            for (int cell : rowArr) {
                System.out.print(cell == 1 ? '*' : ' ');
            }
            System.out.println();
        }
    }
}