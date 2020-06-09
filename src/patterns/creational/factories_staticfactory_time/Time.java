package patterns.creational.factories_staticfactory_time;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public static Time noon() {
        Time time = new Time();
        time.hour = 12;
        return time;
    }

    public static Time midnight() {
        return new Time();
    }

    public static Time ofSeconds(long seconds) {
        Time time = new Time();
        time.hour = (int) seconds / 3600 % 24;
        time.minute = (int) seconds / 60 % 60;
        time.second = (int) seconds % 60;
        return time;
    }

    public static Time of(int hour, int minute, int second) {
        if (hour < 0 || hour > 23
                || minute < 0 || minute > 59
                || second < 0 || second > 59) {
            return null;
        }
        Time time = new Time();
        time.hour = hour;
        time.minute = minute;
        time.second = second;
        return time;
    }
}
