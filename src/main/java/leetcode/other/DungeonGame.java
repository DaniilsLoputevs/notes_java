package leetcode.other;

import lombok.val;

import java.util.Arrays;

@Deprecated // todo test and finish impl
public class DungeonGame {
//        System.out.printf("row = %s | cell = %s\r\n", row, cell);
//        this.printDungeon(tempDungeon);

//        return (rsl <= -1) ? Math.abs(rsl) + 1
//                : (rsl >= +1) ? rsl
//                : rsl + 1; // if rsl == 0
    public static void main(String[] args) {
        val in = new int[][]{
//                {0}

//                {-3, 5}

//                {0, -3},
                
                {1,-2,3}, // 0 | -5 | -1 - значение для последний клетки во 2-ом Данжоне, через разные пути.
                {2,-2,-2} // expected on LeetCode: 2

//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}

//                {-2, -3,},
//                {-5, -10,},
//                {10, 30, }
        };
        //[-2, -5]
        //[-7, -15]
        //[3, 15]
        val rsl = new DungeonGame().calculateMinimumHP(in);
        System.out.println("rsl = " + rsl);
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cells = dungeon[0].length;
        
        int[][] tempDungeon = new int[rows][cells];
        tempDungeon[0][0] = dungeon[0][0];
        
        int maxLength = Math.max(rows, cells);
        for (int i = 1; i < maxLength; i++) {
            // set value to each cell in first column
            if (i < rows) tempDungeon[i][0] = dungeon[i][0] + tempDungeon[i - 1][0];
            // set value to each cell in first row
            if (i < cells) tempDungeon[0][i] = dungeon[0][i] + tempDungeon[0][i - 1];
        }
        for (int row = 1; row < dungeon.length; row++) {
            for (int cell = 1; cell < dungeon[row].length; cell++) {
                
                int dungeonCellHP = dungeon[row][cell];
                tempDungeon[row][cell] = this.closerToZeroByModule(
                        dungeonCellHP + tempDungeon[row - 1][cell],
                        dungeonCellHP + tempDungeon[row][cell - 1]
                );
            }
        }
        this.printDungeon(tempDungeon);
        
        int finalCellMinHP = tempDungeon[rows - 1][cells - 1];
        int firstCellValue = dungeon[0][0];
        // F = finalCellMinHP; V = firstCellValue;
        // P = POSITIVE; N = NEGATIVE;
        // ========================================
        // F   V
        // P & P - use F and ignore Value
        // P & N - use Value (invert + 1)
        // N & P - use F (invert + 1)
        // N & N - use (furthest from ZERO to NEGATIVE || the most negative number)
        int rsl = (finalCellMinHP >= 0 && firstCellValue >= 0) ? finalCellMinHP
                : (finalCellMinHP >= 0 && firstCellValue <= 0) ? firstCellValue
                : (finalCellMinHP <= 0 && firstCellValue >= 0) ? finalCellMinHP
                : (finalCellMinHP <= 0 && firstCellValue <= 0) ? Math.min(finalCellMinHP, firstCellValue)
                : 0; // both are ZERO
        
        return (rsl <= -1) ? Math.abs(rsl) + 1
                : 1; // if result is POSITIVE
    }
    
    /**
     * If different between module of {@code first} and module of {@code second}
     * is POSITIVE => module of {@code first} is Bigger that {@code second} and need to return {@code second}
     * because it's Smaller(closer to ZERO).
     * <pre>{@code
     * @param int first = -50;
     * @param int second = 35;
     *            15 =      50         -      35
     * int different = Math.abs(first) - Math.abs(second);
     * }<pre/>
     * if {@code different} POSITIVE => return {@code second}
     * if {@code different} NEGATIVE => return {@code first}
     * if {@code different} ZERO => return {@code second} -- in real both parameters are EQUAL.
     */
    private int closerToZeroByModule(int first, int second) {
        return (Math.abs(first) - Math.abs(second) >= 0) ? second : first;
    }
    
    public void printDungeon(int[][] dungeon) {
        for (int[] row : dungeon) System.out.println(Arrays.toString(row));
    }
    
}
