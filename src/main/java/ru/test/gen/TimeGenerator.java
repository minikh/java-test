package ru.test.gen;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

class TimeGenerator {
    private final LocalDateTime from;
    private final Random random;
    private final long days;

    TimeGenerator() {
        random = new Random();
        LocalDateTime now = LocalDateTime.now();
        int year = now.minusYears(1).getYear();
        from = LocalDateTime.of(year, 1, 1, 0, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(year + 1, 1, 1, 0, 0, 0, 0);
        days = ChronoUnit.DAYS.between(from, to);
    }

    LocalDateTime generate() {
        return from
                .plusDays(random.nextInt((int) days))
                .plusHours(random.nextInt(24))
                .plusMinutes(random.nextInt(60))
                .plusSeconds(random.nextInt(60));
    }
}
