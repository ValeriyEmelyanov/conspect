package date_time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationReview {
    public static void main(String[] args) {
        Duration days = Duration.of(3, ChronoUnit.DAYS);
        Duration minutes = Duration.of(3, ChronoUnit.MINUTES);
        Duration seconds = Duration.of(3, ChronoUnit.SECONDS);
        Duration nanos = Duration.of(3, ChronoUnit.NANOS);
        System.out.println(days);    // PT72H
        System.out.println(minutes); // PT3M
        System.out.println(seconds); // PT3S
        System.out.println(nanos);   // PT0.000000003S

        LocalTime start = LocalTime.of(11, 45, 30);
        LocalTime end = LocalTime.of(12, 50, 30);
        Duration between = Duration.between(start, end);
        System.out.println(between);
    }
}
