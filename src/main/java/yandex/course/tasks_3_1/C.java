package yandex.course.tasks_3_1;

import java.io.IOException;
import java.util.Scanner;


public class C {
    public static void main(String[] args) throws IOException {
        var br = new Scanner(System.in);
        int n = br.nextInt();
        int k = br.nextInt();
        // Вычисляем числа факториалов для n, k и (n - k)
        int nFactorial = factorial(n);
        int kFactorial = factorial(k);
        int nMinusKFactorial = factorial(n - k);
    }
    
    private static int factorial(int num) {
        int rsl = 1;
        for (int i = 2; i <= num; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
