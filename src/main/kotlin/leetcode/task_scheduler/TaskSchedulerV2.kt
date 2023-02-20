package leetcode

const val IDLE_CHAR = '-'
fun main() {
    TaskSchedulerV2().run {
        // 8 :: [A, B, -, A, B, -, A, B]
        // 6 :: [A, B, A, B, A, B]
        // 16 :: [A, B, C, A, D, E, A, F, G, A, -, -, A, -, -, A]
        println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
        println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0))
        println(leastInterval(charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2))
    }
}

class TaskSchedulerV2 {
    @LeedcodeAPI
    fun leastInterval(tasks: CharArray, n: Int): Int {
//        println(TaskIterator(tasks, n)) // for debug
        var size = 0
        for (t in TaskIterator(tasks, n)) size++
        return size
    }

}

class TaskIterator(tasks: CharArray, private val interval: Int) : Iterator<Char> {
    private val taskGroups = tasks.toTaskGroups().toMutableList()
    private var tasksGivenCounter = 0
    private var next = ' '


    private fun setNext() {
        var elemIndex = -1
        var maxTaskCount = 0
        for (i in taskGroups.indices) {
            val task = taskGroups[i]
            if (task.nextPossiblePosition > tasksGivenCounter) continue
            if (task.count > maxTaskCount) {
                maxTaskCount = task.count
                elemIndex = i
            }
        }
        // if all taskGroups in cooldown - give IDLE
        if (elemIndex == -1) next = IDLE_CHAR
        else taskGroups[elemIndex].apply {
            count--
            nextPossiblePosition = interval + tasksGivenCounter + 1
            if (count == 0) taskGroups.remove(this)
            next = char
        }
    }

    override fun hasNext(): Boolean = taskGroups.size > 0

    override fun next(): Char {
        setNext()
        tasksGivenCounter++
        return next
    }

    /** for debug only */
    private fun terminalToList(): MutableList<Char> {
        val rsl = mutableListOf<Char>()
        for (t in this) rsl.add(t)
        return rsl
    }
    /** for debug only */
    override fun toString(): String {
        val temp = terminalToList();
        return "($tasksGivenCounter = $ :: ${temp})"
    }
}

class TaskGroup(
    val char: Char,
    var count: Int = 0,
    var nextPossiblePosition: Int = 0
) {
    override fun toString(): String = "($char = $count :: $nextPossiblePosition)"
}

fun CharArray.toTaskGroups(): MutableCollection<TaskGroup> {
    val rsl = mutableMapOf<Char, TaskGroup>()
    forEach { it -> rsl.computeIfAbsent(it) { TaskGroup(it) }.count++ }
    return rsl.values
}