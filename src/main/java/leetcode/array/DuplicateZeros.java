package leetcode.array;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        var arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
//        new DuplicateZeros().duplicateZeros(arr);
        new Solution().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    // Input: arr = [1,0,2,3,0,4,5,0]
    // Output:      [1,0,0,2,3,0,0,4]
    public void duplicateZeros(int[] arr) {
        // [1,0,2,3,0,4,5,0]
        // [1,0,0,2,3,0,0,4]
        
        //                z
        int ptZero = 0;
        
        while (ptZero < arr.length - 2) { // the guarantee - we have at least 2 elements
            if (arr[ptZero] != 0) {
                ptZero++;
                continue;
            }
            int pt1 = arr.length - 2;
            int pt2 = pt1 + 1;
            while(pt1 > ptZero) {
                arr[pt2] = arr[pt1];
                arr[pt1] = 0;
                pt1--;
                pt2 = pt1 + 1;
            }
            ptZero += 2;
            
        }
        
    }
    static class Solution {
        public void duplicateZeros(int[] arr) {
            int nZe =0;
            for(int num : arr) {
                if(num==0) nZe++;
            }
            int i = arr.length-1;
            int j = arr.length+nZe-1;
            while(i!=j) {
                insert(arr,i,j);
                j--;
                if(arr[i]==0) {
                    insert(arr,i,j);
                    j--;
                }
                i--;
            }
        }
        // Input: arr = [1,0,2,3,0,4,5,0]
        // Output:      [1,0,0,2,3,0,0,4]
        void insert(int[] arr, int i, int j) {
            if(j<arr.length) {
                arr[j] = arr[i];
            }
        }
    }
}
