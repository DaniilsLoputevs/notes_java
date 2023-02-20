package interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Input:
 * 5
 * / \
 * 3   5
 * / \   \
 * 4   6   7
 * /
 * 4
 *
 * Output:
 * 5
 * 3 5
 * 4 6 7
 * 4
 */
internal class NeoCryptoKtTest {
    private val obj = NeoCrypto()
    private val root = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(4).apply {
                left = TreeNode(4)
            }
            right = TreeNode(6)
        }
        right = TreeNode(5).apply {
            right = TreeNode(7)
        }
    }
    private val LS = System.lineSeparator()
    private val rootString = "5 $LS" + "3 5 $LS" + "4 6 7 $LS" + "4 "

    @Test fun `tree root to string`() = assertEquals(rootString, obj.levels(root));
}