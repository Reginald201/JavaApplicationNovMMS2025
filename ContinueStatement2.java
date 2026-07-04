public class ContinueStatement2{

    public static void main(String[] args) {

        int i = 1;

        while (i <= 20) {

            if (i == 2 || i == 8 || i == 16 || i == 18 || i == 19) {
                i++;
                continue;
            }

            System.out.println(i);
            i++;
        }
    }
}