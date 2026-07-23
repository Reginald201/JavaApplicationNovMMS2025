// DateAndTimeTest.java
// Tests incrementing the time to the next day.
public class DateAndTimeTest {
    public static void main(String[] args) {
        DateAndTime dt = new DateAndTime(12, 31, 2026, 23, 59, 59);

        System.out.println("Before: " + dt.toUniversalString());
        dt.tick(); // rolls into next day
        System.out.println("After tick (next day): " + dt.toUniversalString());

        DateAndTime dt2 = new DateAndTime(3, 31, 2026, 23, 30, 0);
        System.out.println("\nBefore: " + dt2.toUniversalString());
        dt2.incrementHour(); // rolls into next day (and next month)
        System.out.println("After incrementHour (next day): " + dt2.toUniversalString());
    }
}
