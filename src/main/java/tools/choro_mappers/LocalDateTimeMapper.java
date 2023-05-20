package tools.choro_mappers;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class LocalDateTimeMapper {
    public static final String
            DD_MM_YYYY__HH_MM_SS__PATTERN = "dd-MM-yyyy HH:mm:ss",
            YYYY_MM_DD__HH_MM_SS__PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter
            DD_MM_YYYY__HH_MM_SS = DateTimeFormatter.ofPattern(DD_MM_YYYY__HH_MM_SS__PATTERN),
            YYYY_MM_DD__HH_MM_SS = DateTimeFormatter.ofPattern(YYYY_MM_DD__HH_MM_SS__PATTERN),
            ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    
    /**
     * @param source string in "ISO date-time format". Example "2011-12-03T10:15:30".
     */
    public LocalDateTime from(String source) {
        return LocalDateTime.parse(source, ISO_LOCAL_DATE_TIME);
    }
    
    /**
     * For each method call created new {@link DateTimeFormatter}, to prevent creation of unnecessary object
     * recommend to use {@link  LocalDateTimeMapper#from(String, DateTimeFormatter)} but current way is useful for debug.
     *
     * @param pattern {@link DateTimeFormatter} see class doc for patterns symbols.
     */
    public LocalDateTime from(String source, String pattern) {
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(pattern));
    }
    
    public LocalDateTime from(String source, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(source, dateTimeFormatter);
    }
    
    /**
     * Combine {@param localDate} + "00:00:00"(hour:minutes:seconds)
     */
    public LocalDateTime from(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
    }
    
    /**
     * Combine {@code LocalDate.now()} + {@param localTime}
     */
    public LocalDateTime from(LocalTime localTime) {
        return LocalDateTime.of(LocalDate.now(), localTime);
    }
    
    public LocalDateTime from(LocalDate localDate, LocalTime localTime) {
        return LocalDateTime.of(localDate, localTime);
    }
    
    /**
     * Code example:
     * <pre>{@code
     *         LocalDateTimeMapper mapper = new LocalDateTimeMapper()
     *         println(LocalDateTime.now().equals(mapper.from(Instant.now()))) // true
     * }</pre>
     *
     * @see LocalDateTimeMapper#from(Instant, ZoneId)
     */
    public LocalDateTime from(Instant instant) {
        return this.from(instant, Clock.systemDefaultZone().getZone());
    }
    
    /**
     * {@link java.time.Instant} is the class encapsulating the time elapsed from the standard Java epoch(beginning of time in Java)
     * of 1970-01-01T00:00:00Z. Instant instances do have a time zone associated with them – UTC to be specific.
     * <b>So, an instance of Instant holds a value of date-time with a UTC time-line.</b>
     * <p>
     * {@link java.time.LocalDateTime} is that the time is indeed “local”, i.e. <b>it belongs to a local time-line with no time zone associated with it.</b>
     * <p>
     * That's mean {@param zone} is just hour offset for result LocalDateTime.<br>
     * For example, your "local" time zone is GMT+3<br>
     * - if you need get a LocalDateTime associated with your default TimeZone.<br>
     * Use this argument <b>for {@param zone} {@code Clock.systemDefaultZone().getZone();} Default way.</b><br>
     * - if you need get a LocalDateTime without any offset.<br>
     * Use this argument <b>for {@param zone} {@code Clock.systemUtc().getZone();}.</b><br>
     * <p>
     * Warning!<br>
     * {@link Instant#toString()} -> show data in format as "2011-12-03T10:15:30Z" and <b>it's belong to UTC/Zulus time-zone.</b><br>
     * {@link LocalDateTime#toString()} -> show data in format as "2007-12-03T10:15:30" and <b>it's belong to your "local" time-zone.</b><br>
     * <p>
     * For example, your "local" time zone is GMT+3<br>
     * <pre>{@code
     *    public static void main(String[] args) {
     *         Instant inst = Instant.now();
     *         LocalDateTimeMapper mapper = new LocalDateTimeMapper();
     *         LocalDateTime dlt1 = mapper.from(inst); // use default: Clock.systemDefaultZone().getZone()
     *         LocalDateTime dlt2 = mapper.from(inst, Clock.systemUTC().getZone());
     *         System.out.println(inst.toString()); // 2023-05-18T04:15:30Z - belong to UTC/Zulus time-zone
     *         System.out.println(dlt1.toString()); // 2023-05-18T07:15:30  - belong to GMT+3 time-zone
     *         System.out.println(dlt2.toString()); // 2023-05-18T04:15:30  - belong to UTC/Zulus time-zone
     *     }
     * }</pre>
     *
     * @param instant source for mapping
     * @param zone    just hours offset that append to result.
     */
    public LocalDateTime from(Instant instant, ZoneId zone) {
        return LocalDateTime.ofInstant(instant, zone);
    }
    
    public LocalDateTime from(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime();
    }
    
    /**
     * @see LocalDateTimeMapper#from(LocalTime)
     */
    public LocalDateTime from(OffsetTime offsetTime) {
        return this.from(offsetTime, false);
    }
    
    /**
     * @param addOffset - input "07:00+05:00"
     *                  true  -> return currentDate + "12:00" // 2023-05-18 12:00:00
     *                  false -> return currentDate + "07:00" // 2023-05-18 07:00:00
     */
    public LocalDateTime from(OffsetTime offsetTime, boolean addOffset) {
        return this.from(addOffset
                ? offsetTime.toLocalTime().plusSeconds(offsetTime.getOffset().getTotalSeconds())
                : offsetTime.toLocalTime());
    }
    
    public LocalDateTime from(ZonedDateTime zonedDateTime) {
        return this.from(zonedDateTime, false);
    }
    
    /**
     * @param addZoneOffset - input "07:00+05:00"
     *                      true  -> return currentDate + "12:00" // 2023-05-18 12:00:00
     *                      false -> return currentDate + "07:00" // 2023-05-18 07:00:00
     */
    public LocalDateTime from(ZonedDateTime zonedDateTime, boolean addZoneOffset) {
        return addZoneOffset
                ? zonedDateTime.toLocalDateTime().plusSeconds(zonedDateTime.getOffset().getTotalSeconds())
                : zonedDateTime.toLocalDateTime();
    }
    
    /**
     * @see LocalDateTimeMapper#from(Instant, ZoneId)
     */
    public LocalDateTime from(Calendar calendar) {
        return this.from(calendar.toInstant(), calendar.getTimeZone().toZoneId());
    }
    
    /**
     * @see LocalDateTimeMapper#from(Instant)
     */
    public LocalDateTime from(Date date) {
        return this.from(date.toInstant(), Clock.systemDefaultZone().getZone());
    }
    
    /**
     * @see LocalDateTimeMapper#from(Instant)
     */
    public LocalDateTime from(long milliseconds) {
        return this.from(Instant.ofEpochMilli(milliseconds));
    }
    
    /**
     * @see LocalDateTimeMapper#from(LocalDate)
     */
    public LocalDateTime from(java.sql.Date date) {
        return this.from(date.toLocalDate());
    }
    
    /**
     * @see LocalDateTimeMapper#from(LocalTime)
     */
    public LocalDateTime from(java.sql.Time time) {
        return this.from(time.toLocalTime());
    }
    
    /**
     * @see LocalDateTimeMapper#from(LocalDate, LocalTime)
     */
    public LocalDateTime from(java.sql.Date date, java.sql.Time time) {
        return this.from(date.toLocalDate(), time.toLocalTime());
    }
    
    public LocalDateTime from(java.sql.Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
    
}
