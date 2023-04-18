package tools;

import lombok.val;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtil {

    public static final String
            // фронт date-picket присылает даты именно в этом формате. Старый
            DD_MM_YYYY = "dd-MM-yyyy",
            DD_MM_YYYY__HH_MM_SS = "dd-MM-yyyy HH:mm:ss",

    // фронт date-picket присылает даты именно в этом формате. Новый
    YYYY_MM_DD = "yyyy-MM-dd",
            YYYY_MM_DD__HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter
            YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern(YYYY_MM_DD),
            YYYY_MM_DD__HH_MM_SS_FORMATTER = DateTimeFormatter.ofPattern(YYYY_MM_DD__HH_MM_SS);


    public static boolean isInTimeRange(LocalDateTime timePoint, LocalDateTime earliestTimeRange, LocalDateTime latestTimeRange) {
        return timePoint.isAfter(earliestTimeRange) && timePoint.isBefore(latestTimeRange);
    }

    // для большего перевода одних блин дат в другие блин даты: https://www.logicbig.com/how-to/java-8-date-time-api/to-date-conversion.html

    public static Calendar toCalendar(LocalDateTime localDateTime) {
        return GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));
    }

    public static Calendar toCalendar(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        //assuming start of day
        calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        return calendar;
    }

    public static Calendar toCalendar(Date date) {
        val cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
    }

    public static LocalDateTime toLocalDateTime(String date, String time, String dateTimeFormat) {
        return LocalDateTime.parse(date + time, DateTimeFormatter.ofPattern(dateTimeFormat));
    }

    /* print helper */

    public static void print(String name, Calendar calendar) {
        print(name, calendar, "yyyy-MM-dd HH:mm:ss");
    }

    public static void print(String name, LocalDate localDate) {
        print(name, localDate, "yyyy-MM-dd");
    }

    public static void print(String name, LocalDateTime localDateTime) {
        print(name, localDateTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static void print(String name, Calendar calendar, String pattern) {
        val format = new SimpleDateFormat(pattern);
        System.out.println(name + " : " + format.format(calendar.getTime()));
    }

    public static void print(String name, LocalDate localDate, String pattern) {
        val format = DateTimeFormatter.ofPattern(pattern);
        System.out.println(name + " : " + localDate.format(format));
    }

    public static void print(String name, LocalDateTime localDateTime, String pattern) {
        val format = DateTimeFormatter.ofPattern(pattern);
        System.out.println(name + " : " + localDateTime.format(format));
    }

}
