package com.yourcompany.apod.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateUtil {

    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ISO_LOCAL_DATE;

    private DateUtil() {
    }

    public static String format(LocalDate date) {
        return date.format(ISO_DATE);
    }

    public static LocalDate parse(String date) {
        try {
            return LocalDate.parse(date, ISO_DATE);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd, got: " + date, ex);
        }
    }
}
