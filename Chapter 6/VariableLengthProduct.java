public class VariableLengthProduct{
    public static long product(int... values) {
        long result = 1;
        for (int value : values) {
            result *= value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("product() = " + product());
        System.out.println("product(5) = " + product(5));
        System.out.println("product(2, 3) = " + product(2, 3));
        System.out.println("product(1, 2, 3, 4) = " + product(1, 2, 3, 4));
        System.out.println("product(2, 2, 2, 2, 2, 2) = " + product(2, 2, 2, 2, 2, 2));
    }
}