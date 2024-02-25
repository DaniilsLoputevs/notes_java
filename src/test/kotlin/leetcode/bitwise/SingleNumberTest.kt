package leetcode.bitwise


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {
    private val obj = SingleNumber.Solution()

    @Test fun `41212`() = assertEquals(4, obj.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    @Test fun `aaa`() = assertEquals(3, obj.singleNumber(intArrayOf(3, 7, 1, 7, 1)))
}