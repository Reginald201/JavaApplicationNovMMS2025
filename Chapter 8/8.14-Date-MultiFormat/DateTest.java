// DateTest.java
public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date(6, 14, 1992);          // MM, DD, YYYY
        Date d2 = new Date("June", 14, 1992);      // month name, DD, YYYY
        Date d3 = new Date(166, 1992);              // day-of-year, YYYY

        System.out.println("d1 (int,int,int constructor):");
        System.out.println("  MM/DD/YYYY : " + d1.toMMDDYYYY());
        System.out.println("  Month DD, YYYY : " + d1.toMonthDDYYYY());
        System.out.println("  DDD YYYY : " + d1.toDDDYYYY());

        System.out.println("\nd2 (String,int,int constructor):");
        System.out.println("  MM/DD/YYYY : " + d2.toMMDDYYYY());
        System.out.println("  Month DD, YYYY : " + d2.toMonthDDYYYY());
        System.out.println("  DDD YYYY : " + d2.toDDDYYYY());

        System.out.println("\nd3 (int,int day-of-year constructor):");
        System.out.println("  MM/DD/YYYY : " + d3.toMMDDYYYY());
        System.out.println("  Month DD, YYYY : " + d3.toMonthDDYYYY());
        System.out.println("  DDD YYYY : " + d3.toDDDYYYY());
    }
}
