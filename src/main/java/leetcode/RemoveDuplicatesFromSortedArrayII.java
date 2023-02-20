package leetcode;

import lombok.val;

import java.util.Arrays;

@Deprecated // todo test and finish impl
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
//        val array = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 3};
        val array = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4};
        val rsl = new Solution().removeDuplicates(array);
        System.out.printf("rsl: %s || array: %s\r\n", rsl, Arrays.toString(array));
    }
}

class Solution {
    private static final int EMPTY = -1000_000;
    
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int size = nums.length;
        int countingElement = nums[0];
        int elementCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (countingElement != curr) {
                countingElement = curr;
                elementCount = 1;
                continue;
            }
            elementCount++;
            if (elementCount == 3) {
                // moving logic
                size--;
                elementCount--;
                int serialElemIndex = i;
                for (int y = i + 1; y < nums.length; y++) {
                    int cursor = nums[y];
                    serialElemIndex = y;
                    if (cursor == EMPTY) {
                        nums[y - 1] = EMPTY;
                        break;
                    }
                    nums[y - 1] = cursor;
                }
                nums[serialElemIndex] = EMPTY;
                i--;
            }
        }
        return size;
    }
}

