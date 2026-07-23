// Date.java
// Date class supporting multiple output formats and overloaded constructors.
public class Date {
    private int month; // 1-12
    private int day;   // 1-31 based on month
    private int year;  // any year >= 1

    private static final int[] daysPerMonth =
        { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static final String[] monthNames = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Constructor 1: receives month, day, year as three integers (MM/DD/YYYY)
    public Date(int month, int day, int year) {
        if (year < 1)
            throw new IllegalArgumentException("year (" + year + ") must be >= 1");
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");

        int maxDay = (month == 2 && isLeapYear(year)) ? 29 : daysPerMonth[month];
        if (day <= 0 || day > maxDay)
            throw new IllegalArgumentException("day (" + day +
                ") out-of-range for the specified month and year");

        this.month = month;
        this.day = day;
        this.year = year;
    }

    // Constructor 2: receives a month name (String) and two integers
    // (day, year) -- e.g. new Date("June", 14, 1992)
    public Date(String monthName, int day, int year) {
        this(monthNameToNumber(monthName), day, year);
    }

    // Constructor 3: receives the day number in the year and the year
    // -- e.g. new Date(165, 1992)
    public Date(int dayOfYear, int year) {
        if (year < 1)
            throw new IllegalArgumentException("year (" + year + ") must be >= 1");

        int daysRemaining = dayOfYear;
        int m = 1;

        while (m <= 12) {
            int daysThisMonth = (m == 2 && isLeapYear(year)) ? 29 : daysPerMonth[m];
            if (daysRemaining <= daysThisMonth) {
                break;
            }
            daysRemaining -= daysThisMonth;
            m++;
        }

        if (m > 12 || dayOfYear <= 0) {
            throw new IllegalArgumentException(
                "dayOfYear (" + dayOfYear + ") out-of-range for year " + year);
        }

        this.month = m;
        this.day = daysRemaining;
        this.year = year;
    }

    private static int monthNameToNumber(String monthName) {
        for (int i = 1; i <= 12; i++) {
            if (monthNames[i].equals(monthName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unknown month name: " + monthName);
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    // returns the day number within the year (DDD)
    private int dayOfYear() {
        int total = day;
        for (int m = 1; m < month; m++) {
            total += (m == 2 && isLeapYear(year)) ? 29 : daysPerMonth[m];
        }
        return total;
    }

    // a) i. MM/DD/YYYY
    public String toMMDDYYYY() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    // a) ii. Month DD, YYYY (e.g. "June 14, 1992")
    public String toMonthDDYYYY() {
        return String.format("%s %d, %d", monthNames[month], day, year);
    }

    // a) iii. DDD YYYY (day of year, then year)
    public String toDDDYYYY() {
        return String.format("%03d %d", dayOfYear(), year);
    }

    @Override
    public String toString() {
        return toMMDDYYYY();
    }
}
