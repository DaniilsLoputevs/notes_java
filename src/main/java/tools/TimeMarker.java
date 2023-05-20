package tools;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * This tool JUST WORK!!!
 *
 * @author Daniils Loputevs
 * @version 1.1 - 27.04.2023
 */
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
    
    public static void printBetweenMarks(String oneName, String twoName) {
        val one = findMarkByName(oneName);
        val two = findMarkByName(twoName);
        if (one == null || two == null) {
            System.out.printf("marks \"%s\" or \"%s\" doesn't found!%s", oneName, twoName, System.lineSeparator());
            return;
        }
        val rsl = TimeUnit.NANOSECONDS.toMillis(two.timeNano - one.timeNano);
        System.out.printf("Difference between TimeMarks(oneName=\"%s\" -> twoName=\"%s\") : %s MILLISECONDS %s",
                one.name, two.name, rsl, System.lineSeparator());
    }
    
    private static TimeMark findMarkByName(String name) {
        for (TimeMark mark : marks) if (mark.name.equals(name)) return mark;
        return null;
    }
    
    
    @RequiredArgsConstructor
    private static class TimeMark {
        private final String name;
        private final long timeNano;
    }
    
}
