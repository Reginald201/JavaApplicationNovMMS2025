// Time2.java
// Time2 class with the time stored internally as the number of seconds
// since midnight. Public interface is unchanged, so no client code
// needs to change.
public class Time2 {
    private int totalSeconds; // 0 - 86399 (seconds since midnight)

    // No-argument constructor: initializes each instance variable to zero
    public Time2() {
        this(0, 0, 0);
    }

    // Constructor with hour supplied, minute and second defaulted to 0
    public Time2(int hour) {
        this(hour, 0, 0);
    }

    // Constructor with hour and minute supplied, second defaulted to 0
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }

    // Constructor with hour, minute, and second supplied
    public Time2(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    // Constructor with another Time2 object supplied
    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    // Set Methods
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        totalSeconds = hour * 3600 + minute * 60 + second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        setTime(hour, getMinute(), getSecond());
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        setTime(getHour(), minute, getSecond());
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
        setTime(getHour(), getMinute(), second);
    }

    // Get Methods -- derived from totalSeconds
    public int getHour() {
        return totalSeconds / 3600;
    }

    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }

    public int getSecond() {
        return totalSeconds % 60;
    }

    // Convert to Universal Time String
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // Convert to Standard Time String
    public String toString() {
        return String.format("%d:%02d:%02d %s",
            ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
            getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}
