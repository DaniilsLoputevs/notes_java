package leetcode.temp;

/**
 * Есть дерево:
 *     5
 *    / \
 *   3   5
 *  / \   \
 * 4   6   7
 * /
 * 4
 * Его нужно распечатать в таком формате:
 * 5
 * -- 3
 * ---- 4
 * ------ 4
 * ---- 6
 * -- 5
 * ---- 7
 *
 * На задачу 30 мин
 * можно использовать sout или делать return String;
 * Код запускать нельзя.
 */
class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class PrintTree {

}
