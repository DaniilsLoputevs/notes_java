package leetcode.tree

import leetcode.structures.TreeNode
import org.junit.jupiter.api.Test

class IsValidBSTTest {
    @Test fun `test1`() {
        val root = treeNode(5) {
            left = treeNode(4)
            right = treeNode(6) {
                left = treeNode(3)
                right = treeNode(7)
            }
        }
        TreeNode.printVisualizeTraditional(root)
        IsValidBST().isValidBST(root).apply(::println)
    }

    @Test fun `test2`() {
        val root = treeNode(50) {
            left = treeNode(40) {
                left = treeNode(20) {
                    left = treeNode(10)
                    right = treeNode(25)
                }
                right = treeNode(45) {
                    left = treeNode(48)
                }
            }
            right = treeNode(60) {
                left = treeNode(30) {
                    left = treeNode(15)
//                    right = treeNode(-1)
                }
                right = treeNode(70) {
//                    left = treeNode(-1)
                    right = treeNode(80)
                }
            }
        }
        TreeNode.printVisualizeTraditional(root)
//        deleteAllNegative(root)
//        TreeNode.printVisualizeTraditional(root)
        IsValidBST().isValidBST(root).apply(::println)
    }

    fun treeNode(value: Int = 0, dsl: TreeNode.() -> Unit = {}): TreeNode = TreeNode(value).apply(dsl)

//    fun deleteAllNegative(root : TreeNode) {
//        val q = LinkedList<TreeNode>()
//        q.offer(root.left)
//        q.offer(root.right)
//        var prev : TreeNode = root
//        val curr = q.poll()
//
//        while (!q.isEmpty()) {
//            if (curr.`val` < 0) {
//                if (curr === prev.left) prev.left = null
//                if (curr === prev.right) prev.right = null
//            }
//            prev = curr
//        }
//    }
}