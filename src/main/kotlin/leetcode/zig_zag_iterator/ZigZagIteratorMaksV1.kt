package leetcode.zig_zag_iterator

//Input:
//v1 = [1,2]
//v2 = [3,4,5,6]
//
//
//Output: [1,3,2,4,5,6]
//
//
//Explanation: By calling  next repeatedly until hasNext returns false, the order of elements returned by next
//should be: [1,3,2,4,5,6].

//fun main() {
//    val v1 = listOf(1, 2)
//    val v2 = listOf(3, 4, 5, 6)
//    val iterators = mutableListOf(v1.iterator(), v2.iterator())
//    ZigZagIteratorMaksV1(iterators).forEach { print("$it ") }
//
//    println("")
//    println("===")
//
//    val v3 = listOf(1, 2)
//    val v4 = listOf(3, 4, 5, 6)
//    val v5: List<Int> = listOf(7, 8, 9)
//    val iterators2 = mutableListOf(v3.iterator(), v4.iterator(), v5.iterator())
//    ZigZagIteratorMaksV1(iterators2).forEach { print("$it ") }
//}

class ZigZagIteratorMaksV1(lists: Array<List<Int>>) : ZigZagIterator {
    private var argIterators : List<Iterator<Int>> = lists.map { it.iterator() }


    private val iterators: MutableList<Iterator<Int>> = argIterators.filter { it.hasNext() }.toMutableList()
    private var pos = 0

    override fun hasNext(): Boolean = iterators.isNotEmpty()

    override fun next(): Int {
        if (pos >= iterators.size) pos = 0
        val result = iterators[pos].next()
        if (iterators[pos].hasNext()) pos++ else iterators.removeAt(pos)
        return result
    }

    // declared for working with Java code - not use in real
    override fun remove() = TODO("Not yet implemented")
}