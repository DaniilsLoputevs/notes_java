package tools.choro_mappers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*


/**
 * String ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * LocaleDateTime ----------------------------------
 * LocaleDate ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * LocaleTime ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * Instant ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * OffsetDateTime ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * OffsetTime ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * ZonedDateTime ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * Calendar ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * Date ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * Long(milliseconds) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *
 * Date      (SQL) (extends from java.util.Date)
 * Time      (SQL) (extends from java.util.Date)
 * Timestamp (SQL) (extends from java.util.Date)
 * todo - offset & zoned classes convert with option(process OR ignore (offset || zone) info)
 */
class LocalDateTimeMapperTest {
    private val mapper = LocalDateTimeMapper()
    private val formatter: DateTimeFormatter = LocalDateTimeMapper.YYYY_MM_DD__HH_MM_SS

    private val zoneId = ZoneId.of("GMT+5")
    private val zoneOffset = ZoneOffset.of("+05:00")
    private val systemZoneOffset = ZoneOffset.of(Clock.systemDefaultZone().zone.rules.getOffset(Instant.now()).id)

    private val resultString = LocalDateTime.parse("2023-05-18 07:00:00", formatter)
    private val resultLocalDate = LocalDateTime.parse("2023-05-18 00:00:00", formatter)
    private val resultLocalTime = LocalDateTime.now().withHour(7).withMinute(0).withSecond(0).withNano(0)
    private val resultInstantDefault = resultString.plusSeconds(systemZoneOffset.totalSeconds.toLong())
    private val resultInstantOffset = resultString.plusSeconds(zoneOffset.totalSeconds.toLong())
    private val resultLocalTimeAddOffset = resultLocalTime.plusSeconds(zoneOffset.totalSeconds.toLong())
    private val resultZonedDateTimeAddOffset = resultString.plusSeconds(zoneOffset.totalSeconds.toLong())


    private val inLocalDate: LocalDate = LocalDate.of(2023, 5, 18)
    private val inLocalTime: LocalTime = LocalTime.of(7, 0, 0)
    private val inInstant: Instant = Instant.parse("2023-05-18T07:00:00.00Z") // belong UTC/Zulus time-zone
    private val inCalendar: Calendar =
        GregorianCalendar.from(ZonedDateTime.of(resultString, ZoneId.systemDefault())) // belong UTC/Zulus time-zone
    private val inDate: Date = inCalendar.time // belong UTC/Zulus time-zone

    private val inOffsetDateTime: OffsetDateTime = OffsetDateTime.of(resultString, zoneOffset)
    private val inOffsetTime: OffsetTime = OffsetTime.of(inLocalTime, zoneOffset)
    private val inZonedDateTime: ZonedDateTime = ZonedDateTime.of(resultString, zoneId)
    private val inMills: Long = resultString.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli()



    @Test fun stringDefaultISO() = assertEquals(resultString, mapper.from("2023-05-18T07:00:00"))
    @Test fun stringPattern() = assertEquals(resultString, mapper.from("2023-05-18 07", "yyyy-MM-dd HH"))
    @Test fun stringFormatter() = assertEquals(resultString, mapper.from("2023-05-18 07:00:00", formatter))

    @Test fun localDate() = assertEquals(resultLocalDate, mapper.from(inLocalDate))
    @Test fun localTime() = assertEquals(resultLocalTime, mapper.from(inLocalTime))
    @Test fun localDateAndTime() = assertEquals(resultString, mapper.from(inLocalDate, inLocalTime))

    @Test fun instantDefault() = assertEquals(resultInstantDefault, mapper.from(inInstant))
    @Test fun instantOffset() = assertEquals(resultInstantOffset, mapper.from(inInstant, zoneId))

    /* Offset & Zoned classes just return Original LocalDateTime - extra info doesn't affect on this situation */
    @Test fun offsetDateTime() = assertEquals(resultString, mapper.from(inOffsetDateTime))

    @Test fun offsetTime() = assertEquals(resultLocalTime, mapper.from(inOffsetTime))
    @Test fun offsetTimeAddOffset() = assertEquals(resultLocalTimeAddOffset, mapper.from(inOffsetTime, true))
    @Test fun zonedDateTime() = assertEquals(resultString, mapper.from(inZonedDateTime))
    @Test fun zonedDateTimeAddOffset() = assertEquals(resultZonedDateTimeAddOffset, mapper.from(inZonedDateTime, true))

    @Test fun calendar() = assertEquals(resultString, mapper.from(inCalendar))
    @Test fun date() = assertEquals(resultString, mapper.from(inDate))

    @Test fun milliseconds() = assertEquals(resultInstantDefault, mapper.from(inMills))


}
