package leetcode.array;

// time:  O(n)
// space: O(1)
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0];
        if (nums.length == 1) return max;
        int currMax = max;
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == 1) {
                currMax++;
            } else {
                max = Math.max(max, currMax);
                currMax = 0;
            }
        }
        max = Math.max(max, currMax);
        return max;
    }
}
