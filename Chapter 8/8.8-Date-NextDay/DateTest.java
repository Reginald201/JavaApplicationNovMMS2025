// DateTest.java
// Tests method nextDay, including rollover into the next month and next year.
public class DateTest {
    public static void main(String[] args) {
        // a) incrementing into the next month
        System.out.println("Testing month increment:");
        Date d1 = new Date(1, 28, 2026);
        for (int i = 0; i < 5; i++) {
            System.out.println(d1);
            d1.nextDay();
        }

        // b) incrementing into the next year
        System.out.println("\nTesting year increment:");
        Date d2 = new Date(12, 29, 2026);
        for (int i = 0; i < 5; i++) {
            System.out.println(d2);
            d2.nextDay();
        }

        // leap year edge case
        System.out.println("\nTesting leap-year Feb 28 -> Feb 29:");
        Date d3 = new Date(2, 27, 2028); // 2028 is a leap year
        for (int i = 0; i < 4; i++) {
            System.out.println(d3);
            d3.nextDay();
        }

        // invalid date test
        try {
            new Date(2, 29, 2026); // 2026 is not a leap year
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught expected exception: " + e.getMessage());
        }
    }
}
