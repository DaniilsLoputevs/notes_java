package custom.streams;

import java.util.List;

public class StagesTest {
    
    public static void main(String[] args) {
        var stage0 = Stage.of("aaa", "ccc", "bbb", "11", "33", "22");
        var list1 = stage0
                .filter(e -> e.length() == 2)
                .sort(String::compareTo)
                .map(Integer::parseInt)
                .toList();
        System.out.println(list1);
//        List<String> list = new ArrayList<>("aaa");
        List<String> list = List.of("aaa");
        list.addAll(List.of("bbb"));
    }
}
