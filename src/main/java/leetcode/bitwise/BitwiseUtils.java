package leetcode.bitwise;

public final class BitwiseUtils {
    public static String asBinaryStr(int n) {
        return Integer.toBinaryString(n);
    }
    public static String asBinaryStr(long n) {
        return Long.toBinaryString(n);
    }
    
    public static void printAsBinaryStr(String name, int n) {
        System.out.printf(name + " = %s = %s%n", n, Long.toBinaryString(n));
    }
}
