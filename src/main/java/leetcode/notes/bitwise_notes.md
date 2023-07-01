# Content
- [Switch char case 'a' -> 'A'](#switch-char-case--a-----a)
- [Divide/Multiply by 2](#dividemultiply-by-2)
- [Check is Number Even or Odd](#check-is-number-even-or-odd)



### Switch char case 'a' -> 'A'
```java
    class Example {
        private static void show() {
            char a = 'a'; // unicode: 97
            char A = 'A'; // unicode: 65
            System.out.println("a" + (char) (a & 95 & 0xFF)); // aA
            System.out.println("A" + (char) (A | 32 & 0xFF)); // Aa
        }
}
```
### Divide/Multiply by 2
**Important! divide for Positive and Negative base working in different way!**
<br> 8 = (17 / 2)
<br> -9 = (-17 / 2)
```java
public class DivAndMultiply {
    public static void show() {
        int odd = 17;
        int even = 20;
        int oddNegative = -17;
        int evenNegative = -20;
        
        /* Multiply by 2 - x 2 */
        System.out.println(odd << 1); // 34
        System.out.println(even << 1); // 40
        System.out.println(oddNegative << 1); // -34
        System.out.println(evenNegative << 1); // -40
        System.out.println();
        
        /* Divide by 2 - / 2 */
        System.out.println(odd >> 1); // 8 = (17 / 2)
        System.out.println(even >> 1); // 20
        System.out.println(oddNegative >> 1); // -9 = (-17 / 2)
        System.out.println(evenNegative >> 1); // -10
        System.out.println(odd / 2);
        System.out.println();
    }
}
```
### Check is Number Even or Odd
```java
public class CheckIsOddOrEven {
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
```