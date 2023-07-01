package leetcode.bitwise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CharConvertCase {
    /**
     * https://stackoverflow.com/questions/31285805/how-to-convert-cases-with-bit-manipulation
     * https://stackoverflow.com/questions/17912640/byte-and-char-conversion-in-java
     */
    
    
    public static void main(String[] args) {
//        var array = new int[] {1,2,3};
//        for(int i = -1; ++i < array.length;) {
//            System.out.println(array[i]);
//        }
        var l = new ArrayList<>(List.of(1, 3, 2, 5, 4));
        l.sort(Comparator.comparingInt(it -> it));
//        Comparator<Integer> c = Comparator.comparingInt(it -> it).reversed()
        System.out.println(l);
        
        var que = new PriorityQueue<List<Integer>>(
                Comparator.comparingInt(numPair -> numPair.get(0) + numPair.get(1))
        );
        
        printBi("positive", 127L);
        printBi("negative", -127L);
        
        
        char a = 'a'; // 97
        char A = 'A'; // 65
        System.out.println((int) a);
        System.out.println((int) A);
        System.out.println();
        
        System.out.println(a - 32);
        System.out.println(A + 32);
        System.out.println();
        
        System.out.println(95 & a);
        System.out.println(32 | A);
        
        System.out.println(a & 95);
        System.out.println(A | 32);
        System.out.println("a" + (char) (a & 95 & 0xFF)); // aA
        System.out.println("A" + (char) (A | 32 & 0xFF)); // Aa
        
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(33));
        System.out.println(Integer.toBinaryString(101));
        // 1100101 = 64 + 32 + 4 + 1
        System.out.println();
        long num = Integer.MAX_VALUE;
//        long num = 100;
//        System.out.println(Long.toBinaryString(num ^ 2));
//        System.out.println(Long.toBinaryString(num ^ 3));
//        System.out.println(Long.toBinaryString(num ^ 8));
        long pow = (long) Math.pow(2, 33);
//        int pow = 65536; // 2^16 // (int)Math.pow(2, 16);
        printBi("num", num);
        printBi("pow", pow);
        String markedBi = Long.toBinaryString(num ^ pow);
        long markedValue = Long.parseLong(markedBi, 2);
        System.out.println(markedBi);
        System.out.println(markedValue);
        
        printBi("rsl", markedValue ^ pow);
//        System.out.println(markedValue ^ pow);
        System.out.println();
        int n = 1500;
        int p = 65536;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n ^ p));
        System.out.println(Integer.toBinaryString((n ^ p) ^ p));
        System.out.println(n);
        System.out.println(n = (n ^ p));
        System.out.println(n ^ p);
    }
    
    class Example {
        private static void show() {
            char a = 'a'; // unicode: 97
            char A = 'A'; // unicode: 65
            System.out.println("a" + (char) (a & 95 & 0xFF)); // aA
            System.out.println("A" + (char) (A | 32 & 0xFF)); // Aa
        }
    }
    
    public static void printBi(String name, Long n) {
        System.out.printf(name + " = %s = %s%n", n, Long.toBinaryString(n));
    }
    
    
}
