package yandex.course.tasks_3_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Бронирование переговорки
 * Задано
 * n интервалов. Требуется найти максимальное количество взаимно непересекающихся интервалов.
 * Два интервала пересекаются, если они имеют хотя бы одну общую точку.
 * В первой строке задано одно число n (1 - 100)
 * В следующих n строках заданы интервалы n
 */
// time : O(n log n)
// space: O(1) || O(n) - используя только подсчёт или Собирая отрезки
public class A {
    
    public static void main(String[] args) throws IOException {
//        var lines = Files.lines(Path.of("src","main","resources","yandex","course","tasks_3_2","input.txt"))
        var lines = Files.lines(Path.of("input.txt"))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(Integer::parseInt)
                .iterator();
        var in = new int[lines.next()][];
        int write = 0;
        while (lines.hasNext()) {
            in[write++] = new int[]{lines.next(), lines.next()};
        }
        System.out.println(countNonOverlappingIntervals(in));
    }
    
    // space: O(n)
    private static int countNonOverlappingIntervals(int[][] ranges) {
        var rsl = new ArrayList<int[]>();
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[1]));
        int[] compare = ranges[0];
        rsl.add(compare);
        for (int i = 1; i < ranges.length; i++) {
            int[] curr = ranges[i];
            /*
            Что бы, проверить что интервал не Пересекается, нужно проверить 2 кейса:
            1 - curr.start && curr.end находятся ДО compare.start   | curr.start < compare.start && curr.end < compare.start
            2 - curr.start && curr.end находятся ПОЛСЕ compare.end  | curr.start > compare.end && curr.end > compare.end
            Все остальные комбинации - это уже пересечения!
            Из-за сортировки, у нас есть преимущество: каждый curr.end >= compare.end, что даёт нам 2 вещи:
            - 1-ый кейс можно не проверять т.к. мы начинаем с самого ЛЕВОГО/МАЛОГО Конца и Левее нас ничего не будет.
            - 2-ой кейс, можно проверять только первое условие т.к. мы точно знаем, что каждый curr.end будет ПРАВЕЕ чем мы.
            */
            if (curr[0] > compare[1]) {
                rsl.add(curr);
                compare = curr;
            }
        }
        return rsl.size();
    }
    
    // space: O(1)
    private static int countNonOverlappingIntervalsOnlyCount(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[1]));
        int[] compare = ranges[0];
        int rsl = 1;
        for (int i = 1; i < ranges.length; i++) {
            int[] curr = ranges[i];
            if (compare[1] < curr[0]) {
                rsl++;
                compare = curr;
            }
        }
        return rsl;
    }
    
}
