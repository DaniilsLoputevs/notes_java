package tools.choro_mappers

import org.junit.jupiter.api.Test
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*


class Experiments {
    private val mapper = LocalDateTimeMapper()

    @Test fun runLocalDateTime_Instant3() {
//        val date = LocalDateTime.of(1970, 1, 1, 0, 0)
        val date = LocalDateTime.of(2023, 5, 18, 7, 0)

        val mills = date.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli()
        println("Initial Epoch (TimeInMillis): " + mills)
        val inst = Instant.ofEpochMilli(mills)
        println("inst = $inst")
        println("rsl = ${mapper.from(inst)}")


        val o = (53*5*18*7*1*1*1_000).also { println(it) }
        val s = System.currentTimeMillis().also { println(it) }
    }

    @Test fun runLocalDateTime_Instant2() {

        val now = LocalDateTime.now()
//        val off1 = OffsetDateTime.of(now, ZoneOffset.ofHours(3))
//        val off2 = OffsetDateTime.now()
//        println(now)
//        println(off1)
//        println(off2)
//        println(off1.toLocalDate())
//        println(off1.toLocalTime())
//        println(off1.toLocalDateTime())
//        println(LocalDateTime.of(off1.toLocalDate(), off1.toLocalTime()))


//        val date = Date()
//        println(System.currentTimeMillis() - date.time)
//        LocalTime.now()
//        LocalDate.now()
//        SimpleDateFormat()
////        val sdf = SimpleDateFormat.getDateTimeInstance().format()
//        println(date.toString())
//        println(date.toGMTString())
//        println(date.toLocaleString())

        println(LocalDateTime.now())
        println(GregorianCalendar().toString())
        println(Instant.now())
        println(Date())

        println(mapper.from(Instant.now()))
        println(mapper.from(GregorianCalendar()))



        val zoneOffset = ZoneOffset.ofHours(3)
        val fmt = DateTimeFormatter.ofPattern("HH:mm:ss")
        val dateTime = LocalDateTime.now()
//
        val timeUtc: OffsetDateTime = dateTime.atOffset(ZoneOffset.UTC) //18:11:06 UTC
        val offsetTime : OffsetDateTime = timeUtc.withOffsetSameInstant(zoneOffset) //21:11:06 +03:00
        System.out.println("dateWithOffset: " + fmt.format(offsetTime)) //21:11:06
        System.out.println("dateWithOffset: " + offsetTime.toLocalDateTime()) //21:11:06

    }

    @Test fun runLocalDateTime_Instant() {
        val l = Clock.systemDefaultZone().also { println(it) }
        val k = ZoneId.systemDefault().also { println(it) }
        val base = LocalDateTime.now()
        println(base)

//        base.toLocalDate().also { println(it) }
//        base.toLocalTime().also { println(it) }
//        Calendar.getInstance().toInstant().also { println(it) }

        val p1 = base.query(LocalDate::from)
        val p2 = base.query(LocalTime::from)
        val p3 = tryAnyException({ base.query(Instant::from) }, { null })
        val p4 = tryAnyException({ base.query(OffsetDateTime::from) }, { null })
        val p5 = tryAnyException({ base.query(OffsetTime::from) }, { null })
        val p6 = tryAnyException({ base.query(ZonedDateTime::from) }, { null })
        println("LocalDate      = $p1")
        println("LocalTime      = $p2")
        println("Instant        = $p3")
        println("OffsetTime     = $p4")
        println("OffsetTime     = $p5")
        println("ZonedDateTime  = $p6")


        val instUtc = Instant.now(Clock.systemUTC()).also { println(it.epochSecond) }
//        val instUtc = Instant.now(Clock.systemUTC()).also { println(it.toString()) }
        val u = Instant.now().atZone(ZoneId.of("GMT+5"))
//            .withHour(hour)
//            .withMinute(minute)
//            .withSecond(second)
//            .withNano(nano)
            .toInstant()
        val instDefault = Instant.now(Clock.systemDefaultZone()).also { println(it.epochSecond) }
//        val instGTM5 = Instant.now().atZone(ZoneId.of("GMT+5")).also { println(it) }
        val instD10 =
            Instant.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(10))).also { println(it.epochSecond) }

        println()
        val r1 = LocalDateTime.ofInstant(instUtc, Clock.systemUTC().zone).also { println(it) }
        val r2 = LocalDateTime.ofInstant(instDefault, Clock.systemDefaultZone().zone).also { println(it) }
        val r3 = LocalDateTime.ofInstant(instD10, Clock.systemDefaultZone().zone).also { println(it) }

        println()
        val r0 = LocalDateTime.ofInstant(instUtc, Clock.systemDefaultZone().zone).also { println(it) }
        val rZ = LocalDateTime.ofInstant(instUtc, ZoneId.of("Z")).also { println(it) }
        val rd1 = LocalDateTime.ofInstant(instD10, Clock.systemDefaultZone().zone).also { println(it) }
        val rd2 = LocalDateTime.ofInstant(instD10, ZoneId.of("Z")).also { println(it) }

        ZonedDateTime.now().toLocalTime()
    }


}

fun <R> tryAnyException(block: () -> R, doIfException: (Throwable) -> R) =
    try {
        block()
    } catch (t: Throwable) {
        doIfException(t)
    }