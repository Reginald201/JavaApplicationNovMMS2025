// TrafficLight.java
// Enum type representing traffic-light colors, each with a duration.
public enum TrafficLight {
    RED(30),
    GREEN(25),
    YELLOW(5);

    private final int duration; // duration in seconds

    // enum constructor
    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s (duration: %d seconds)", name(), duration);
    }
}
