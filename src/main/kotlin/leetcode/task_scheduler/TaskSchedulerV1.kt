package leetcode


fun main() {
    val scheduler = TaskScheduler().run {
        leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2)
        leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0)
        leastInterval(charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2)
    }
}

fun CharArray.toTaskGroup(): MutableCollection<TaskGroupInfo> {
    val rsl = mutableMapOf<Char, TaskGroupInfo>()
    forEach { it -> rsl.computeIfAbsent(it) { TaskGroupInfo(it, 0, -1) }.count++ }
    return rsl.values
}

fun MutableCollection<TaskGroupInfo>.toTaskSchedule(taskInterval: Int): List<Char> {
    val rsl = mutableListOf<Char>()
    var currentTaskPosition = 0
    while (true) {
        for (taskGroup in this) {
            // skip by empty taskGroup
            if (taskGroup.count == 0) continue
            // skip by interval
            if (currentTaskPosition > taskInterval
                && (currentTaskPosition < (taskGroup.lastTaskPosition + taskInterval))
            ) continue

            taskGroup.run {
                rsl += char
                count--
                lastTaskPosition = currentTaskPosition++
            }
        }
        this.removeIf{it.count == 0} // clear empty TaskGroup
//        if (this.isAllTasGroupsEmpty()) break
        if (this.isEmpty()) break

        // check: need set IDLE or not
//        val earliestTaskPosition = this.getEarliestLastTaskPosition()
//        if (currentTaskPosition > taskInterval
//            && (this.getEarliestLastTaskPosition() + taskInterval) < currentTaskPosition) {
        if ( (this.getEarliestTaskPosition() + taskInterval) <= currentTaskPosition) {
            currentTaskPosition++
            rsl += IDLE_CHAR
        }
    }
    return rsl
}

fun MutableCollection<TaskGroupInfo>.isAllTasGroupsEmpty(): Boolean {
    forEach { if (it.count > 0) return false }; return true
}

fun MutableCollection<TaskGroupInfo>.getEarliestTaskPosition() = this.minOf { it.lastTaskPosition }


class TaskGroupInfo(
    val char: Char,
    var count: Int,
    var lastTaskPosition: Int
) {
    override fun toString(): String {
//        return "TaskGroupInfo(char=$char, count=$count, lastTaskPosition=$lastTaskPosition)"
        return "($char = $count :: $lastTaskPosition)"
    }
}


class TaskScheduler {
    @LeedcodeAPI
    fun leastInterval(tasks: CharArray, n: Int): Int {
        return tasks.toTaskGroup().toTaskSchedule(n).let {
            println(it)
            println(it.size)
            it.size
        }
    }

    private fun CharArray.toTaskTypeAndCount(): MutableMap<Char, Int> {
        val rsl = mutableMapOf<Char, Int>()
        forEach { rsl[it] = rsl.getOrDefault(it, 0).inc() }
        return rsl;
    }


    /**
     * n = 7
     *
     * A = 3 : 1
     * B = 0 : 2
     * C = 0 : 3
     * D = 0 :
     * E = 0
     *
     * A - B - C - D - E - IDLE - IDLE - IDLE
     */
//    private fun getNextTask(): Any? {
//        val list = ArrayList<TaskTypeAndCount>()
//        while (true) {
//            for (i in list.indices) {
//                val curr = list[i]
//                if (curr.skip) continue
//                if (curr.count == 0) curr.skip = true
//            }
//            if () break
//        }
//    }
//
//    internal class TaskTypeAndCount {
//        var c = 0.toChar()
//        var count = 0
//        var skip = false
//    }
}