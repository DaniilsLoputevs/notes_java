package leetcode.task_scheduler

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

fun main() {
    TaskSchedulerV3().run {
        // 8 :: [A, B, -, A, B, -, A, B]
        // 6 :: [A, B, A, B, A, B]
        // 16 :: [A, B, C, A, D, E, A, F, G, A, -, -, A, -, -, A]
        println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
        println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0))
        println(leastInterval(charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2))
        println(leastInterval(charArrayOf('A', 'A', 'A', 'A',  ), 2))
    }
}

class TaskSchedulerV3 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val pq = PriorityQueue<Int>(Comparator { a, b -> b - a })
        val map = IntArray(26)

        for (t in tasks) map[t - 'A']++
        for (i in 0..25) {
            if (map[i] > 0) pq.offer(map[i])
        }

        var res = 0
        while (!pq.isEmpty()) {
            var cnt = 0
            val tmp = ArrayList<Int>()

            for (i in 0..n) {
                if (!pq.isEmpty()) {
                    val task = pq.poll()
                    if (task - 1 > 0) tmp.add(task - 1)
                    cnt++
                }
            }
            for (t in tmp) pq.offer(t)
            res += if (pq.isEmpty()) cnt else n + 1
        }

        return res
    }
}