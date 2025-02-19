package lebron.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a DateParser to parse and format Date and DateTime input strings into
 * LocalDate and LocalDateTime objects and reformat into response and data strings
 */
public class DateParser {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /**
     * Returns a LocalDate object from parsing the input Date string
     *
     * @param date Date string to be formatted
     * @return LocalDate object parsed from input string
     */
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    /**
     * Returns a LocalDateTime object from parsing the input DateTime string
     *
     * @param date DateTime string to be formatted
     * @return LocalDateTime object parsed from input string
     */
    public static LocalDateTime parseDateTime(String date) {
        return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    /**
     * Returns a formatted Date string from the LocalDate object
     *
     * @param date LocalDate object to be formatted
     * @return Formatted Date string
     */
    public static String dateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    /**
     * Returns a formatted DateTime string from the LocalDateTime object
     *
     * @param date LocalDateTime object to be formatted
     * @return Formatted DateTime string
     */
    public static String dateTimeToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
    }

    /**
     * Returns a formatted Date string from the LocalDate object to be stored
     *
     * @param date LocalDate object to be formatted
     * @return Formatted Date data string
     */
    public static String dateToDataString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    /**
     * Returns a formatted DateTime data string from the LocalDateTime object to be stored
     *
     * @param date LocalDateTime object to be formatted
     * @return Formatted DateTime data string
     */
    public static String dateTimeToDataString(LocalDateTime date) {
        return date.format(DATE_TIME_FORMATTER);
    }
}
