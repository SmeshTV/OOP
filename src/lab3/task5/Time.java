package lab3.task5;

public class Time implements Comparable<Time> {

    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Time other) {
        if (this.hours != other.hours) {
            return this.hours - other.hours;
        }
        return this.minutes - other.minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }
}