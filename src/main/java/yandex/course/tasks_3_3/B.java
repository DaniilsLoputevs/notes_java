package yandex.course.tasks_3_3;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <a href="https://new.contest.yandex.ru/48558/problem?id=215/2023_04_06/lX20wNIqZg">...</a>
 * Камни 2
 * Вы играете в игру <<Камни>>: игру для двух игроков с двумя наборами камней по
 * n и m штук. С каждым ходом один игрок может забрать следующие комбинации камней:
 *
 * Взять один камень из любого набора.
 * Взять два камня из какого-то одного набора
 * Взять два камня из одного и один из другого.
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 *
 * Вы и ваш оппонент играете оптимально.
 */
public class B {
    public static void main(String[] args) throws IOException {
//        var ints = Files.lines(Path.of("input.txt"))
        var ints = Stream.of("4 4")
//        var ints = Stream.of("17 72")
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(Integer::parseInt)
                .iterator();
        
        int n = ints.next() + 1, m = ints.next() + 1;
//        var scn = new Scanner(System.in);
//        int n = scn.nextInt() + 1, m = scn.nextInt() + 1;
//        if (n == 17 || n == 18) {
//            System.out.println(n);
//            System.out.println(m);
//        }
        System.out.println(winOrLoose(n, m));
    }
    
    /**
     * Default tech values:
     * -    0	1
     * 0	L	W
     * 1	W	L
     *
     * т.к. таблица +- семерична, её можно заполнять с один указателем по Ряду и Колонке
     * - сразу писать значение для Ряда и для Колонки.
     * Однако есть НО! Само поле может быть НЕ СЕМЕТРИЧНЫМ
     *
     * Описание для последнего цикла:
     * -        col-2 | col -1 | col
     * row-2     	      W	      W
     * row-1    W	              W
     * row      W	      W	      L    <- указатели стоят на этой ячейке
     * мы поставил L только если мы попал именно в такой расклад по Предыдущим ячейкам.
     */
    public static String winOrLoose(int n, int m) {
        var field = new char[n][m];
        field[0][0] = 'L'; // Default tech values:
        field[1][0] = 'W'; // -    0	1
        field[0][1] = 'W'; // 0	   L	W
        field[1][1] = 'L'; // 1	   W	L
        int max = Math.max(n, m);
        
        // пред заполняем 1-ую колонку & 1-ый ряд
        for (int index = 2; index < max; index++) {
            if (index < n) field[index][0] = (field[index - 1][0] == 'W' && field[index - 2][0] == 'W') ? 'L' : 'W';
            if (index < m) field[0][index] = (field[0][index - 1] == 'W' && field[0][index - 2] == 'W') ? 'L' : 'W';
        }
        // пред заполняем 2-ую колонку & 2-ой ряд
        for (int index = 2; index < max; index++) {
            if (index < n) field[index][1] = (field[index - 1][0] == 'L') ? 'L' : 'W';
            if (index < m) field[1][index] = (field[0][index - 1] == 'L') ? 'L' : 'W';
        }
        
        /* см. Описание для последнего цикла */
        for (int row = 2; row < n; row++) {
            for (int col = 2; col < m; col++) {
                field[row][col] = (field[row - 1][col] == 'W' && field[row - 2][col] == 'W' && field[row - 2][col - 1] == 'W'
                        && field[row][col - 1] == 'W' && field[row][col - 2] == 'W' && field[row - 1][col - 2] == 'W'
                )
                        ? 'L' : 'W';
            }
        }
        print2DArray(field);
        
        return (field[n - 1][m - 1] == 'W') ? "Win" : "Loose";
    }

//    public static String winOrLoose(int n, int m) {
//        var field = new char[n][m];
//        field[0][0] = 'L';
//        if (n >= 2) field[1][0] = 'W';
//        if (m >= 2) field[0][1] = 'W';
//        if (n >= 2 && m >= 2) field[1][1] = 'L';
//        int max = Math.max(n, m);
//
//        // пред заполняем 1-ую колонку & 1-ый ряд
//        for (int index = 2; index < max; index++) {
//            if (index < n) field[index][0] = (field[index - 2][0] == 'W') ? 'L' : 'W';
//            if (index < m) field[0][index] = (field[0][index - 2] == 'W') ? 'L' : 'W';
//        }
//        // пред заполняем 2-ую колонку & 2-ой ряд
//        for (int index = 2; index < max; index++) {
//            if (index < n) field[index][1] = 'W';
//            if (index < m) field[1][index] = 'W';
//        }
//
//        /* см. Описание для последнего цикла */
//        for (int row = 2; row < n; row++) {
//            for (int col = 2; col < m; col++) {
//                field[row][col] = (field[row - 1][col] == 'W' && field[row - 2][col] == 'W' && field[row - 2][col - 1] == 'W'
//                        && field[row][col - 1] == 'W' && field[row][col - 2] == 'W' && field[row - 1][col - 2] == 'W'
//                )
//                        ? 'L' : 'W';
//            }
//        }
//        if (n == 17 || n == 18) {
//            print2DArray(field);
//        }
//
//        return (field[n - 1][m - 1] == 'W') ? "Win" : "Loose";
//    }
    
    private static void print2DArray(char[][] field) {
        for (char[] row : field) {
            var sb = new StringBuilder();
            for (char cell : row) {
                sb.append(cell).append(" ");
            }
            System.out.println(sb);
        }
    }
}
