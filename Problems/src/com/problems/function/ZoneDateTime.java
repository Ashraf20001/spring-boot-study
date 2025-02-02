package com.problems.function;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class ZoneDateTime {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ZoneId zoneIdOfTokyo = ZoneId.of("America/New_York");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("LocalDate with zone id"+" "+localDateTime1.atZone(zoneIdOfTokyo));
        ZonedDateTime zonedDateTime = now.withZoneSameInstant(zoneIdOfTokyo);

        System.out.println(now.format(dateTimeFormatter) + " with zone id "+now.getZone());

        System.out.println(zonedDateTime.format(dateTimeFormatter)+" with zone id "+zonedDateTime.getZone());

        LocalDate now1 = LocalDate.now();
        LocalDate now2 = LocalDate.of(1998, Month.FEBRUARY, 8);

        // Period

        Period between = Period.between(now2, now1);
        System.out.println(between.getYears()+" years " + between.getMonths() +" months and " + between.getDays()+" days");

        // Duration
        LocalDateTime localDateTime = LocalDateTime.now();
        Duration duration = Duration.ofHours(5);
        LocalDateTime plus = localDateTime.plus(duration);
        System.out.println(Duration.between(plus,localDateTime));

        // Temporal Adjuster

        System.out.println(now1.with(
                TemporalAdjusters.firstDayOfMonth()
        )+" First day of this month");

        System.out.println(now1.with(
                TemporalAdjusters.next(DayOfWeek.MONDAY)
        )+" Next monday date");

        System.out.println(now1.with(
                TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)
        )+" This month last friday");
    }
}
