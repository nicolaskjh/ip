package lebron.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParser {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static LocalDateTime parseDateTime(String date) {
        return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    public static String dateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    public static String dateTimeToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
    }

    public static String dateToDataString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static String dateTimeToDataString(LocalDateTime date) {
        return date.format(DATE_TIME_FORMATTER);
    }

    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
