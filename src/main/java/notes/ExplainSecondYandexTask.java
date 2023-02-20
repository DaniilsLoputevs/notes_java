package notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExplainSecondYandexTask {
    public static void main(String[] args) {

//        char[] ca = new char[26];
//        var s =  new String[] {"eat", "tea"};
        var inputArray = new String[]{"eat", "tea", "bat"};
        Map<String, List<String>> map = new HashMap<>();
        int logIterationIndex = 0;
        for (String s : inputArray) {
            char[] ca = new char[26]; // index == порядковый номер в алфавите,
                                        // значение(в виде int) это кол-во повторение данного char
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            //                                    a  b         e         t
            // keyStr для "eat" ==  // eat = char[1, 0, 0, 0 , 1, 0 .... 1, 0 ...]
            // keyStr для "tea" ==  // eat = char[1, 0, 0, 0 , 1, 0 .... 1, 0 ...]
            // keyStr для "bat" ==  // eat = char[1, 1, 0, 0 , 0, 0 .... 1, 0 ...]
            
            // сама строка получается не человеко-читабельной, но hashcode из неё всё так же работает.
            System.out.printf("%s || %s || %s \r\n", logIterationIndex++, keyStr, keyStr.hashCode());
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        var rsl = new ArrayList<>(map.values());
        System.out.println(rsl);

//        char[] ca = new char[26];
//        for (String s : inputArray) {
//            for (char c : s.toCharArray()) ca[c - 'a']++;
//            String keyStr = String.valueOf(ca);
//            System.out.printf("%s || %s \r\n", keyStr, keyStr.hashCode());
//        }
    }
}
