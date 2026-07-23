// DateAndTime.java
// Combines the modified Time2 class (Exercise 8.7) and the modified
// Date class (Exercise 8.8). incrementHour calls Date's nextDay when
// the time rolls over into the next day.
public class DateAndTime {
    private Date date;
    private Time2 time;

    public DateAndTime(int month, int day, int year,
                        int hour, int minute, int second) {
        date = new Date(month, day, year);
        time = new Time2(hour, minute, second);
    }

    // increments the hour; if it rolls over back to 0, the date advances
    public void incrementHour() {
        boolean rollsToNextDay = (time.getHour() == 23);
        time.incrementHour();
        if (rollsToNextDay) {
            date.nextDay();
        }
    }

    public void incrementMinute() {
        boolean hourRollsOver = (time.getMinute() == 59);
        time.incrementMinute();
        if (hourRollsOver && time.getHour() == 0 && time.getMinute() == 0) {
            date.nextDay();
        }
    }

    public void tick() {
        boolean minuteRollsOver = (time.getSecond() == 59);
        boolean hourRollsOver = minuteRollsOver && (time.getMinute() == 59);
        time.tick();
        if (hourRollsOver && time.getHour() == 0 &&
            time.getMinute() == 0 && time.getSecond() == 0) {
            date.nextDay();
        }
    }

    // output the date in addition to the time
    public String toUniversalString() {
        return date.toString() + " " + time.toUniversalString();
    }

    public String toString() {
        return date.toString() + " " + time.toString();
    }
}
