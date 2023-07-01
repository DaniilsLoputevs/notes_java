package interview.yandex

import interview.yandex.zeros_to_end.ZerosToEndDaniilsV1
import interview.yandex.zeros_to_end.ZerosToEndDaniilsV2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.opentest4j.AssertionFailedError


private val expect_one = intArrayOf(1, 2, 3, 4, 0, 0)
private val input_one = intArrayOf(1, 2, 0, 3, 0, 4)

private val expect_one_1 = intArrayOf(1, 2, 3, 4, 0, 0)
private val input_one_1 = intArrayOf(0, 1, 0, 2, 3, 4)

interface ZerosToEndTest {
    @Test fun `test1`() = test(expect_one, input_one)
    @Test fun `test2`() = test(expect_one_1, input_one_1)

    class DaniilsV1 : ZerosToEndTest {
        override fun provide(nums: IntArray) = ZerosToEndDaniilsV1().zeroesToEnd(nums)
    }
    class DaniilsV2 : ZerosToEndTest {
        override fun provide(nums: IntArray) = ZerosToEndDaniilsV2().zeroesToEnd(nums)
    }


    fun provide(nums: IntArray)
    fun test(expectedNums: IntArray, nums: IntArray) {
        val originalNums = nums.copyOf()
        this.provide(originalNums) // modify input array
        try {
            assertArrayEquals(expectedNums, originalNums) // equals by content ordering
        } catch (e: AssertionFailedError) {
            println(
                """
                    Input:    ${nums.contentToString()} 
                    Expected: ${expectedNums.contentToString()}
                    Actual:   ${originalNums.contentToString()}
                """.trimIndent()
            )
            throw e
        }
    }
}