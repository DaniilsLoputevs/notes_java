package leetcode

class TwoSum {
    /**
     * Optimization: skip numbers bigger that target.
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val expectedIntAndIndex = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val n = nums[i]
            if (n == target) return intArrayOf(i)
            if (n > target) continue

            expectedIntAndIndex[n]
                ?.let { return intArrayOf(it, i) }
                ?: run { expectedIntAndIndex[target - n] = i }
        }
        return intArrayOf()
    }
}