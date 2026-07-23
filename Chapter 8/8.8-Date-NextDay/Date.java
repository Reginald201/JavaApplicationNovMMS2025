// Date.java
// Date class with full error checking on month, day and year,
// plus a nextDay method.
public class Date {
    private int month; // 1-12
    private int day;   // 1-31 based on month
    private int year;  // any year >= 1

    private static final int[] daysPerMonth =
        { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // constructor: confirm proper value for month, day and year
    public Date(int month, int day, int year) {
        // check if year is valid (year 1 or later)
        if (year < 1)
            throw new IllegalArgumentException("year (" + year + ") must be >= 1");

        // check if month in range
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException(
                "month (" + month + ") must be 1-12");

        // check if day in range for month
        if (day <= 0 ||
            (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day +
                ") out-of-range for the specified month and year");

        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !isLeapYear(year))
            throw new IllegalArgumentException("day (" + day +
                ") out-of-range for the specified month and year");

        this.month = month;
        this.day = day;
        this.year = year;
    }

    // determine whether the given year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    // return the number of days in "this" Date's month
    private int daysInMonth() {
        if (month == 2 && isLeapYear(year))
            return 29;
        return daysPerMonth[month];
    }

    // increments the day by one, rolling into the next month/year as needed
    public void nextDay() {
        if (day < daysInMonth()) {
            day++;
        } else { // last day of the month
            day = 1;
            if (month < 12) {
                month++;
            } else { // last day of the year
                month = 1;
                year++;
            }
        }
    }

    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
