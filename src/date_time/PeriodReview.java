package date_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.Temporal;

public class PeriodReview {
    public static void main(String[] args) {
        Period period = Period.of(1990, 5, 23);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getUnits());

        LocalDate start = LocalDate.of(1995, 5, 23);
        LocalDate end = LocalDate.of(1995, 8, 25);
        Period between = Period.between(start, end);
        System.out.println(between);

        System.out.println(Period.parse("P2Y5M20D"));

        Period p = Period.of(1, 1, 1);
        Temporal temporal1 = p.addTo(LocalDate.of(2000, 6, 10));
        Temporal temporal2 = p.subtractFrom(LocalDate.of(2000, 6, 10));
        System.out.println(p);
        System.out.println(temporal1);
        System.out.println(temporal2);

        Period plus = p.plus(Period.of(2000, 6, 10));
        Period minus = p.minus(Period.of(2000, 6, 10));
        System.out.println(plus);
        System.out.println(minus);
    }
}
