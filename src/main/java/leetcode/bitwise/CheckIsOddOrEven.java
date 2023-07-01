package leetcode.bitwise;

public class CheckIsOddOrEven {
    public static void main(String[] args) {
        show();
    }
    public static void show() {
        int odd = 17;
        int even = 20;
        int oddNegative = -17;
        int evenNegative = -20;
        System.out.println((odd & 1) == 0);          // false
        System.out.println((oddNegative & 1) == 0);  // false
        System.out.println((even & 1) == 0);         // true
        System.out.println((evenNegative & 1) == 0); // true
    }
}
