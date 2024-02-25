package leetcode.array;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/description/">LC task description</a>
 * @see SubarraySumEqualsKTest
 */
public class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
    /*
    k = 3
    sum - k ->   0 2 3 6
    value   ->   3 2 1 3
    sum     -> 0 3 5 6 9
    times   -> 1 1   1
     */
}
