package leetcode.bitwise;

public class DivAndMultiply {
    
    public static void main(String[] args) {
        show();
    }
    public static void show() {
        int odd = 17;
        int even = 20;
        int oddNegative = -17;
        int evenNegative = -20;
//        double doubleOddNegative = -17.5D; // Compile error: Operator '>>' cannot be applied to 'double', 'int'
        
        /* Multiply by 2 - x 2 */
        System.out.println(odd << 1); // 34
        System.out.println(even << 1); // 40
        System.out.println(oddNegative << 1); // -34
        System.out.println(evenNegative << 1); // -40
//        System.out.println(doubleOddNegative << 1); // Compile error: Operator '>>' cannot be applied to 'double', 'int'
        System.out.println();
        
        /* Divide by 2 - / 2 */
        System.out.println(odd >> 1); // 8 = (17 / 2)
        System.out.println(even >> 1); // 20
        System.out.println(oddNegative >> 1); // -9 = (-17 / 2)
        System.out.println(evenNegative >> 1); // -10
//        System.out.println(doubleOddNegative >> 1); // Compile error: Operator '>>' cannot be applied to 'double', 'int'
        System.out.println(odd / 2);
        System.out.println();
    }
}
