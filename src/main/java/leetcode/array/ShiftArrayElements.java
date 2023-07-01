package leetcode.array;

import java.util.Arrays;

// Custom task
public class ShiftArrayElements {
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4, 5};
//        new ShiftArrayElements().shiftRight(arr);
        new ShiftArrayElements().shiftRight(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * [1,2,3,4,5]
     * [0,1,2,3,4]
     *
     * @param arr always have at least 1 element.
     */
    public void shiftRight(int[] arr) {
        if (arr.length <= 1) return;
        int pt1 = arr.length - 2;
        int pt2 = pt1 + 1;
        
        while (pt1 >= 0) {
            arr[pt2] = arr[pt1];
            arr[pt1] = 0;
            pt1--;
            pt2 = pt1 + 1;
            
        }
    }
    
    /**
     * startIndex = 2
     * in:  [1,2,3,4,5]
     * out: [1,2,0,3,4]
     * @param arr always have at least 1 element.
     */
    public void shiftRight(int[] arr, int startIndex) {
        if (arr.length <= 1) return;
        int pt1 = arr.length - 2;
        int pt2 = pt1 + 1;
        
        while (pt1 >= startIndex) {
            arr[pt2] = arr[pt1];
            arr[pt1] = 0;
            pt1--;
            pt2 = pt1 + 1;
            
        }
    }
    
}
