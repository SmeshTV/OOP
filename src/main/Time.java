package main;

public class Time {
    
    private int hour;
    private int minute;
    private int second;
    
    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be 0-23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be 0-59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be 0-59");
        }
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public String toUniversal() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    public String toStandard() {
        int displayHour = hour;
        String period = "AM";
        
        if (hour == 0) {
            displayHour = 12;
        } else if (hour == 12) {
            period = "PM";
        } else if (hour > 12) {
            displayHour = hour - 12;
            period = "PM";
        }
        
        return String.format("%02d:%02d:%02d %s", displayHour, minute, second, period);
    }
    
    public void add(Time other) {
        if (other == null) {
            return;
        }
        
        this.second += other.second;
        if (this.second >= 60) {
            this.minute += this.second / 60;
            this.second %= 60;
        }
        
        this.minute += other.minute;
        if (this.minute >= 60) {
            this.hour += this.minute / 60;
            this.minute %= 60;
        }
        
        this.hour += other.hour;
        this.hour %= 24;
    }
    
    public static void main(String[] args) {
        Time t = new Time(23, 5, 6);
        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
        
        Time t2 = new Time(4, 24, 33);
        t.add(t2);
        
        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
    }
}