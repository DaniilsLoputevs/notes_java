package yandex.course.tasks_3_1;

import java.io.IOException;
import java.util.Scanner;

public class B {
    public static void main(String[] args) throws IOException {
        var br = new Scanner(System.in);
        int n = br.nextInt();
        int k = br.nextInt();
        // Вычисляем числа факториалов для n, k и (n - k)
        int nFactorial = factorial(n + k - 1);
        int kFactorial = factorial(k);
        int nMinus1Factorial  = factorial(n - 1);
        
        // Вычисляем число сочетаний с повторениями C(n, k)
        int combinationsWithRepetition = nFactorial / (kFactorial * nMinus1Factorial);
        
        System.out.println(combinationsWithRepetition);
    }
    
    private static int factorial(int num) {
        int rsl = 1;
        for (int i = 2; i <= num; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
