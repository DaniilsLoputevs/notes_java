package leetcode.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraySumEqualsKTest {
    private val obj = SubarraySumEqualsK()

    @Test fun `zeros`() = assertEquals(3, obj.subarraySum(intArrayOf(1, -1, 0), 0))
    @Test fun `ones`() = assertEquals(1, obj.subarraySum(intArrayOf(-1, -1, 1), 0))
    @Test fun `ones1`() = assertEquals(2, obj.subarraySum(intArrayOf(1, 1, 1, 0, 1, 1), 4))
    @Test fun `123`() = assertEquals(2, obj.subarraySum(intArrayOf(1, 2, 3), 3))
    @Test fun `10_1`() = assertEquals(2, obj.subarraySum(intArrayOf(1, 0, -1), 0))
    @Test fun `1_10`() = assertEquals(3, obj.subarraySum(intArrayOf(1, -1, 0), 0))
}