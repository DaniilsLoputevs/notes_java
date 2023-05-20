package interview.yandex

import interview.yandex.zeros_to_end.ZerosToEndDaniilsV1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.opentest4j.AssertionFailedError


private val expect_one = intArrayOf(1, 2, 3, 4, 0, 0)
private val input_one = intArrayOf(1, 2, 0, 3, 0, 4)

interface ZerosToEndTest {
    @Test fun `one test`() = test(expect_one, input_one)

    class DaniilsV1 : ZerosToEndTest {
        override fun provide(nums: IntArray) = ZerosToEndDaniilsV1().zeroesToEnd(nums)
    }


    fun provide(nums: IntArray)
    fun test(expectedNums: IntArray, nums: IntArray) {
        val originalNums = nums.copyOf()
        this.provide(nums) // modify input array
        try {
            assertArrayEquals(expectedNums, nums) // equals by content ordering
        } catch (e: AssertionFailedError) {
            println(
                """
                    Input:    ${originalNums.contentToString()} 
                    Expected: ${expectedNums.contentToString()}
                    Actual:   ${nums.contentToString()}
                """.trimIndent()
            )
            throw e
        }
    }
}