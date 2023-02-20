package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TwoSumKtTest {
    private val obj = TwoSum()
    @Test fun `have 4 elems, target 9, return (0, 1)`() = assertEquals("[0, 1]", test(9, 2, 7, 11, 15))
    @Test fun `have 3 elems, target 6, return (1, 2)`() = assertEquals("[1, 2]", test(6, 3, 2, 4))
    @Test fun `have 2 elems, target 6, return (0, 1)`() = assertEquals("[0, 1]", test(6, 3, 3))

    private fun test(target: Int, vararg ints: Int): String = obj.twoSum(ints, target).contentToString()
}