public class CommandLineArraySize{
    public static void main(String[] args) {
        int size = 10; // default

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Array size: " + size);
        for (int value : array) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }
}