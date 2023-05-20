package leetcode

import leetcode.zig_zag_iterator.ZigZagIterator
import leetcode.zig_zag_iterator.ZigZagIteratorDaniilsV1
import leetcode.zig_zag_iterator.ZigZagIteratorMaksV1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private val v1 = listOf(1, 2, 3, 4, 5)
private val v2 = listOf(6, 7, 8, 9, 10)
private val e1 = listOf(1, 2)
private val e2 = listOf(3, 4, 5, 6)
private val e3 = listOf(7, 8, 9, 10)
private val empty = listOf<Int>()

private val expect_twoList = listOf(1, 6, 2, 7, 3, 8, 4, 9, 5, 10)
private val expect_threeLists = listOf(1, 3, 7, 2, 4, 8, 5, 9, 6, 10)

interface ZigZagIteratorTestK {
    @Test fun twoLists() = assertEquals(expect_twoList, test(v1, v2))
    @Test fun threeLists() = assertEquals(expect_threeLists, test(e1, e2, e3))
    @Test fun emptyList() = assertEquals(listOf<Int>(), test(empty))


    class DaniilsV1 : ZigZagIteratorTestK {
        override fun provide(data: Array<List<Int>>) = ZigZagIteratorDaniilsV1(data)
    }

    class MaksV1 : ZigZagIteratorTestK {
        override fun provide(data: Array<List<Int>>) = ZigZagIteratorMaksV1(data)
    }

    fun provide(data: Array<List<Int>>): ZigZagIterator
    private fun test(vararg data: List<Int>): MutableList<Int> {
        val list = ArrayList<Int>()
        this.provide(data as Array<List<Int>>).forEachRemaining { e: Int -> list.add(e) }
        return list
    }
}
