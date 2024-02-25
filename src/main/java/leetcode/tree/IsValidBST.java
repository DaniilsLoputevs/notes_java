package leetcode.tree;

import leetcode.structures.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            log(root, pre);
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
    private void log(TreeNode root, TreeNode pre) {
        var rootVal = (root == null) ? "null" : root.val;
        var prevVal = (pre == null) ? "null" : pre.val;
        System.out.println("root=" + rootVal + " || pre="+ prevVal);
    }
}
