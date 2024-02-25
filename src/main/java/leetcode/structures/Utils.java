package leetcode.structures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Utils {
    
    public static int[] arr(int... ints) {
        return ints;
    }
    
    public static int[] generateIntArr(int fromInclude, int toInclude) {
        var n = new AtomicInteger(fromInclude);
        return Stream.generate(n::getAndIncrement)
                .takeWhile(it -> it <= toInclude)
                .mapToInt(Integer::intValue).toArray();
    }
}
