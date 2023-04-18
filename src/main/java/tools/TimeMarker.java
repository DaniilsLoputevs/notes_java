package tools;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class TimeMarker {
    private static final List<TimeMark> marks = new ArrayList<>();

    public static void addMark(String name) {
        marks.add(new TimeMark(name, System.nanoTime()));
    }

    public static void printMarks() {
        printMarks(TimeUnit.MILLISECONDS);
    }

    public static void printMarks(TimeUnit timeUnit) {
        val rsl = new StringJoiner(System.lineSeparator())
                .add("TimeMark: -Name-  -time from last mark-  -display units-");
        boolean isFirsts = true;
        TimeMark prevMark = null;
        for (val mark : marks) {
            if (isFirsts) {
                rsl.add(String.format("TimeMark: \"%s\"", mark.name));
                isFirsts = false;
            } else {
                val duration = mark.timeNano - prevMark.timeNano;
                val time = (timeUnit == TimeUnit.NANOSECONDS) ? duration
                        : (timeUnit == TimeUnit.MICROSECONDS) ? TimeUnit.NANOSECONDS.toMicros(duration)
                        : (timeUnit == TimeUnit.MILLISECONDS) ? TimeUnit.NANOSECONDS.toMillis(duration)
                        : (timeUnit == TimeUnit.SECONDS) ? TimeUnit.NANOSECONDS.toSeconds(duration)
                        : (timeUnit == TimeUnit.MINUTES) ? TimeUnit.NANOSECONDS.toMinutes(duration)
                        : (timeUnit == TimeUnit.HOURS) ? TimeUnit.NANOSECONDS.toHours(duration)
                        : TimeUnit.NANOSECONDS.toDays(duration);
                rsl.add(String.format("TimeMark: \"%s\" %s, %s", mark.name, time, timeUnit.name()));
            }
            prevMark = mark;
        }
        System.out.println(rsl);
    }


    @RequiredArgsConstructor
    private static class TimeMark {
        private final String name;
        private final long timeNano;
    }


}
