// Time2Test.java
// Demonstrates that the seconds-since-midnight internal representation
// produces identical client-visible behavior.
public class Time2Test {
    public static void main(String[] args) {
        Time2 t1 = new Time2();
        Time2 t2 = new Time2(13);
        Time2 t3 = new Time2(13, 27);
        Time2 t4 = new Time2(13, 27, 6);
        Time2 t5 = new Time2(t4);

        System.out.printf("t1: %s%n", t1);
        System.out.printf("t2: %s%n", t2);
        System.out.printf("t3: %s%n", t3);
        System.out.printf("t4: %s%n", t4);
        System.out.printf("t5: %s%n", t5);

        System.out.println("\nUniversal times:");
        System.out.println(t4.toUniversalString());

        t1.setTime(0, 0, 0);
        System.out.println("\nAfter reset, t1: " + t1);
    }
}
