package interview.natasha_Remotza;

import leetcode.structures.ListNode;
import leetcode.structures.ListNodeFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Вызов консольных утилит и парсинг с них информации для вывода
 * 2. Интеграция с внешним API. Информация с которого может понадобиться для нескольких систем, при этом развернутая система может иногда не иметь доступа к сети интернет.
 * 3. Функцоинал для удаленного обновления как бэкенд, так и фронтэнд части, а также возможности изменения конфигурации системы.
 * 4. Механизм лицензирования с возможностью включения/выклюения различных фичей. (при этом так же как и в п.2 доступ к сети интернет может отсутствовать)
 */
public class HotCode {

    
    
    
    class Node {
        public int val;
        public Node next;
    }
    
    
    /*
    time : O(?)
    space: O(?)
    */
    private static void turtleAndRabbit(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow);
        System.out.println(fast);
        System.out.println();
    }
    
    private static void turtleAndRabbitRUN() {
        turtleAndRabbit(new ListNodeFacade(List.of(1)).getHead()); // 1 & 1
        turtleAndRabbit(new ListNodeFacade(List.of(1, 2)).getHead()); // 2 & null
        turtleAndRabbit(new ListNodeFacade(List.of(1, 2, 3)).getHead()); // 2 & 3
        turtleAndRabbit(new ListNodeFacade(List.of(1, 2, 3, 4)).getHead()); // 3 & null
        turtleAndRabbit(new ListNodeFacade(List.of(1, 2, 3, 4, 5)).getHead()); // 3 & 5
        turtleAndRabbit(new ListNodeFacade(List.of(1, 2, 3, 4, 5, 6)).getHead()); // 4 & null
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }
    
    public void removeHelper(String s, List<String> output, int iStart, int jStart,
                             char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i.
                        // jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output,
                                i, j, openParen, closedParen);
                    }
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')', '(');
        else
            output.add(reversed);
    }
    
    public int characterReplacement(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){   // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
    }
    class A {
        protected String say() {
            return "aaa";
        }
    }
    class B extends A {
        public String say() {
            return "asd";
        }
    }
    static class PersonService {
        public Object create() throws IOException {
            return new ArrayList<Integer>(){{
                add(1);
            }};
        }
    }
//    static class H extends PersonService {
//        @Override public Object create() throws Throwable {
//            return super.create();
//        }
//    }
//    static class Exce<T> extends Exception {
//
//}
    
    public static String throwException(boolean flag){
        String result = null;
        try {
            if (flag) throw new RuntimeException();
            result = "Done";
        } finally {
            System.out.println(result.length());
        }
    
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args) + args.length);
//        Вариант 1:
//        Pattern pattern = new Pattern("ma.*");
//        Matcher matcher = new Matcher(pattern);
//        matcher.matches ("matchMe");
//        Вариант 2:
        Pattern pattern = Pattern.compile("ma.*");
        Matcher matcher = pattern.matcher("matchMe");
        matcher.matches ();
//        Вариант 3:
         Pattern.matches("ma.*","matchMe");
//        Вариант 4:
//        Pattern pattern = new Pattern("ma.*");
//        Matcher matcher = pattern.matcher("matchMe");
        boolean result = matcher.matches();
//        throwException(true);
        throwException(false);
        
        
        
        new Thread().setUncaughtExceptionHandler((t, e) -> {
            System.err.println("Uncaught exception in thread " + t.getName() + ": " + e.getMessage());
            // Здесь можно выполнить дополнительные действия с исключением
        });
        new Thread().start();
//        var rsl = new PersonService().create().getClass().getName();
//        System.out.println(rsl);
        
    
        int huge = Integer.MAX_VALUE + Integer.MAX_VALUE;
        System.out.println(huge);
        
        
        interface A {
        
        }
        Class<? extends String> v = "".getClass();
//        AtomicInteger value = new AtomicInteger(5);
//        System.out.println(value.compareAndSet (4, 5));
        
        new PriorityQueue<Integer>();
        var obj = new HotCode();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
//        var rsl = obj.characterReplacement("AABABBA", 1);
//        System.out.println(rsl);

//        new HotCode().intersect(nums1, nums2);
//        new LinkedList<>().pollLast();
//        new HotCode().removeInvalidParentheses("()())()");

//        Parent obj = new Child();
//        List<String> l = obj.create();
//        HashMap p;
////        p.values()
////        Arrays.sort(new char[]);
//        new HashMap<String, String >().values().toArray();
////        ArrayHashMap<String, String> map = new HashMap<>();
////        var r = Arrays.asList(map.values().toArray());
////        new ArrayList<>(map.values());
//        Queue<String> que = new LinkedList<>();
//        var o = String.join("/", que);
//        que.offer("a");
//        que.offer("b");
//        System.out.println(que);
////        Arrays.fill(new int[26], new int[26]);
////        Random r = new Random().nextInt();
//        List.<Integer>of().remove(1);
////        Math.random()
//
    
    }
    
    private static void proxyExample() {
        var writer = new Ebator();
        var censor = new Censer(writer);
        var hardCensor = new HardCenser(writer);
        System.out.println("что сказал писатель по словам редакции: " + censor.writeNewBestSeller());
        System.out.println("что сказал писатель на самом деле: " + writer.writeNewBestSeller());
        System.out.println("что написали в СМИ: " + hardCensor.writeNewBestSeller());
    }
    
    interface Writer {
        String writeNewBestSeller();
    }
    
    static class Ebator implements Writer {
        
        @Override public String writeNewBestSeller() {
            return "Пошли на хуй, не буду я больше высасывать сюжеты из пальца!!!";
        }
    }
    
    static class Censer implements Writer {
        private final Writer original;
        
        Censer(Writer original) {this.original = original;}
        
        @Override public String writeNewBestSeller() {
            return original.writeNewBestSeller().replace("хуй", "***");
        }
    }
    
    static class HardCenser implements Writer {
        private final Writer original;
        
        HardCenser(Writer original) {this.original = original;}
        
        @Override public String writeNewBestSeller() {
            var str = original.writeNewBestSeller();
            return (str.contains("хуй"))
                    ? "рукопись немного задерживается потому что, я хочу сделать её максимально качественной"
                    : str;
        }
    }
}
