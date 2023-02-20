package interview

data class TreeNode(
    val value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null,
)

class NeoCrypto {
    fun levels(root: TreeNode): String {
        /* write code here */
        val queue = mutableListOf(Pair(0, root))
        var prevLevel = 0
        val printLine = StringBuilder()
        while (queue.isNotEmpty()) {
            val (level, node) = queue.removeFirst()

            node.left?.let { queue.add(Pair(level + 1, it)) }
            node.right?.let { queue.add(Pair(level + 1, it)) }

            if (level > prevLevel) printLine.append(System.lineSeparator())
            printLine.append(node.value).append(" ")
            prevLevel = level
        }
        return printLine.toString()
    }
}



