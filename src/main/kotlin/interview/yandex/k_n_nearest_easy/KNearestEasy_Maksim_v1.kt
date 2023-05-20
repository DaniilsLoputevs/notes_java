package interview.yandex.k_n_nearest_easy

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


/**
Дан отсортированный массив целых чисел arr, индекс элемента index и целое число K.
Необходимо вернуть в любом порядке K чисел из массива, которые являются ближайшими
по значению к элементу arr[index].
arr = [1, 2, 3, 5, 8, 9, 11, 13, 14], index = 3, K = 3
rsl = [5, 3, 2]
 */

fun main() {
    val map = listOf(1, 2, 3, 5, 6, 7, 11, 13, 14)
    KNearestEasyTemplate().findClosestElements(map.toIntArray(), 3, 4).forEach { print("$it, ") }
}

class KNearestEasyTemplate {

   fun findClosestElements(arr: IntArray, index: Int, k: Int): List<Int> =
        arr.copyOfRange(max(0, index - k), min(arr.size, index + k))// 1, 2, 3, 5, 6, 7, 11, 13
            .associateBy { abs(it - arr[index]) to it }// 4 - 1, 3 - 2, 2 - 3, 0 - 5, 1 - 6, 2 - 7, 6 - 11, 7 - 13
            .toSortedMap(compareBy<Pair<Int, Int>> {it.first}.thenBy { it.second }) // 0 - 5, 1 - 6, 2 - 3, 2 - 7, 3 - 2, 4 - 1, ...
            .toList() // 0 - 5, 1 - 6, 2 - 3, 2 - 7, 3 - 2, 4 - 1, ...
            .take(k) // 0 - 5, 1 - 6, 2 - 3, 2 - 7
            .map { it.second } // 5, 6, 3, 7
}