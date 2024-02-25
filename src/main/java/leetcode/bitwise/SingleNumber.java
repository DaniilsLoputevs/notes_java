package leetcode.bitwise;

/**
 * <a href="https://leetcode.com/problems/single-number/description">...</a>
 */
public class SingleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {
            int result=0;
            for(int i=0; i<nums.length; i++) {
                result = result^nums[i];
            }
            return result;
        }
    }
}
// 3 =    11
// 7 =   111
/*
100
  1
   ^
101
 */
