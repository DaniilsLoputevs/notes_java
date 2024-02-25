package yandex.course.tasks_3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp *= i;
        }
        System.out.println(temp);
    }
}

