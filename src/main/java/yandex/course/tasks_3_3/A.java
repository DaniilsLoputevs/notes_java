package yandex.course.tasks_3_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * <a href="https://new.contest.yandex.ru/48558/problem?id=215/2023_04_06/lX20wNIqZg">...</a>
 * Вы играете в игру <<Камни>>: игру для двух игроков с двумя наборами камней по
 * m штук.
 * С каждым ходом один игрок может взять один камень (из любого набора) или два камня (по одному из обоих).
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень.
 * Первый ход за вами.
 *
 * Вы и ваш оппонент играете оптимально.
 */
public class A {
    public static void main(String[] args) throws IOException {
        var ints = Files.lines(Path.of("input.txt"))
//        var ints = Stream.of("10 2")
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(Integer::parseInt)
                .iterator();
        
        int n = ints.next() + 1, m = ints.next() + 1;
        System.out.println(winOrLoose(n, m));
    }
    
    public static String winOrLoose(int n, int m) {
        var field = new char[n][m];
        for (int i = 0; i < field.length; i++) {
            field[i] = new char[m];
        }
        field[0] = null; // техническое значение
        // пред заполняем первую колонку
        for (int row = 1; row < n; row++) {
            field[row][0] = (field[row - 1][0] == 'W') ? 'L' : 'W';
        }
        // пред заполняем первый ряд
        for (int col = 1; col < m; col++) {
            field[0][col] = (field[0][col - 1] == 'W') ? 'L' : 'W';
        }
    
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                field[row][col] = (field[row - 1][col -1] == 'W'
                                && field[row - 1][col] == 'W'
                                && field[row][col - 1] == 'W')
                        ? 'L' : 'W';
            }
        }
    
        return (field[n - 1][m - 1] == 'W') ? "Win" : "Loose";
    }
}
