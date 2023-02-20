package notes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    //for ArrayList = 10
    //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    //for TreeSet = 33
    //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    public static void main(String[] args) {
//        var in = List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
//        var in = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        var in = List.of(0, 1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
        var in = List.of(5, 4, 3, 2, 1, 0, 10, 9, 8, 7, 6);
        var comparator = (Comparator<Integer>) (one, two) -> {
            count++;
            System.out.println(one + " -- " + two);
            return Integer.compare(one, two);
        };
        
        
        var listOne = new ArrayList<>(in);
        var stream = listOne.stream();
//        var s = stream.sorted(comparator).collect(Collectors.toList());
//        count = 0;
        listOne.sort(comparator);
        System.out.println("for ArrayList = " + count);
        System.out.println(listOne);
//        count = 0;
//
//        System.out.println("for stream = " + count);
//        System.out.println(s);
//        count = 0;
        
//        var setTwo = new TreeSet<>(comparator);
//        setTwo.addAll(in);
//        System.out.println("for TreeSet = " + count);
//        System.out.println(setTwo);
//        count = 0;

     }
    
    private static int count = 0;
}
