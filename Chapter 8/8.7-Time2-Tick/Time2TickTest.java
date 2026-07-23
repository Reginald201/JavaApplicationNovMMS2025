// Time2TickTest.java
// Tests tick, incrementMinute and incrementHour, including edge cases.
public class Time2TickTest {
    public static void main(String[] args) {
        // a) incrementing into the next minute
        Time2 t1 = new Time2(11, 59, 59);
        System.out.println("Testing tick into next minute:");
        System.out.println("Before: " + t1.toUniversalString());
        t1.tick();
        System.out.println("After:  " + t1.toUniversalString());

        // b) incrementing into the next hour
        Time2 t2 = new Time2(11, 59, 59);
        System.out.println("\nTesting tick into next hour:");
        System.out.println("Before: " + t2.toUniversalString());
        t2.tick();
        System.out.println("After:  " + t2.toUniversalString());

        // c) incrementing into the next day (11:59:59 PM -> 12:00:00 AM)
        Time2 t3 = new Time2(23, 59, 59);
        System.out.println("\nTesting tick into next day:");
        System.out.println("Before: " + t3.toUniversalString());
        t3.tick();
        System.out.println("After:  " + t3.toUniversalString());

        // incrementMinute rollover
        Time2 t4 = new Time2(5, 59, 30);
        System.out.println("\nTesting incrementMinute rollover:");
        System.out.println("Before: " + t4.toUniversalString());
        t4.incrementMinute();
        System.out.println("After:  " + t4.toUniversalString());

        // incrementHour rollover
        Time2 t5 = new Time2(23, 15, 0);
        System.out.println("\nTesting incrementHour rollover:");
        System.out.println("Before: " + t5.toUniversalString());
        t5.incrementHour();
        System.out.println("After:  " + t5.toUniversalString());
    }
}
