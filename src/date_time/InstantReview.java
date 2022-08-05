package date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class InstantReview {
    public static void main(String[] args) {
        Instant epoch = Instant.EPOCH;
        System.out.println(epoch); // 1970-01-01T00:00:00Z

        long posValue = 86400; // 24 * 60 * 60
        long negValue = -86400;
        Instant plusDay = Instant.ofEpochSecond(posValue);
        Instant minusDay = Instant.ofEpochSecond(negValue);
        System.out.println(plusDay);
        System.out.println(Instant.ofEpochSecond(posValue + 1L));
        System.out.println(minusDay);

        System.out.println((plusDay.atZone(ZoneId.of("GMT+3"))));
        System.out.println((plusDay.atZone(ZoneId.systemDefault())));

        System.out.println(ZoneId.systemDefault().getId());
        System.out.println(ZoneId.systemDefault().getRules());
        System.out.println(ZoneId.of("GMT+3").equals(ZoneId.systemDefault())); // false

        Instant theDate = Instant.parse("2009-02-14T03:31:30Z");
        System.out.println(theDate);

        Instant instant = Instant.now();
        System.out.println(instant);

        // These two methods (minus and plus) have limitations concerning supported unit types.
        // They accept units that are smaller than days (inclusive).

        System.out.println(instant.minus(Period.ofDays(1)));
        System.out.println(instant.minus(Duration.ofDays(1)));
        System.out.println(instant.minus(1, ChronoUnit.DAYS));

        System.out.println(instant.plus(Period.ofDays(1)));
        System.out.println(instant.plus(Duration.ofDays(1)));
        System.out.println(instant.plus(1, ChronoUnit.DAYS));
    }
}
