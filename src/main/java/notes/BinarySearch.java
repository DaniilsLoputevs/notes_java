package notes;

import java.util.Arrays;

import static leetcode.structures.Utils.arr;
import static leetcode.structures.Utils.generateIntArr;

public class BinarySearch {
    
    public boolean contains(int[] nums, int target) {
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
    
    public boolean containsReverseOrder(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target)
                l = mid + 1;
            else
                r = mid - 1;
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        var x = Arrays.toString(generateIntArr(1, 100));
        System.out.println(x);
        var obj = new BinarySearch();
        System.out.println(obj.contains(arr(1, 2, 3, 4, 5, 6, 7, 8, 9), 7));
        System.out.println(obj.contains(arr(-9, -8, -7, -6, -5, -4, -3, -2, -1), -7));
        System.out.println(obj.contains(arr(1, 2, 3, 4, 5, 6, 7, 8, 9), 11));
        System.out.println(obj.containsReverseOrder(arr(-1, -2, -3, -4, -5, -6, -7, -8, -9), -7));
    }
}
