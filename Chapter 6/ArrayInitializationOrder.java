
public class ArrayInitializationOrder{
    public static void main(String[] args) {
        int[][] sales = new int[3][5];
        int order = 1;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                sales[row][col] = order; // label with the order it's zeroed
                order++;
            }
        }

        System.out.println("Order in which each element is set to zero:\n");
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%3d", sales[row][col]);
            }
            System.out.println();
        }
    }
}