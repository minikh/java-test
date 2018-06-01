package ru.test.gen;

import java.time.format.DateTimeFormatter;

public class OperationsDateTimeFormatter {
    public static final DateTimeFormatter DATE_FORMATTER;
    public static final DateTimeFormatter TIME_FORMATTER;
    public static final DateTimeFormatter DATE_TIME_FORMATTER;

    static {
        DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        TIME_FORMATTER = DateTimeFormatter.ofPattern("kk:mm:ss");
        DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy:MM:dd kk:mm:ss");
    }
}
