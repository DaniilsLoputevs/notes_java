package leetcode.structures;

import hu.webarticum.treeprinter.SimpleTreeNode;
import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;
import hu.webarticum.treeprinter.text.ConsoleText;
import hu.webarticum.treeprinter.text.PlainConsoleText;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int val) {this.val = val;}
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(Consumer<TreeNode> dsl) {
        dsl.accept(this);
    }
    
    @Override public String toString() {
        return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("left=" + ((left == null) ? "null" : "Object(" + left.val + ")") + ", "
                        + "right=" + ((right == null) ? "null" : "Object(" + right.val + ")"))
                .toString();
    }
    
    public static void printVisualizeTraditional(TreeNode root) {
        new TraditionalTreePrinter().print(new TreeNodeVisualizeAdapter(root));
    }
    
    static class TreeNodeVisualizeAdapter implements hu.webarticum.treeprinter.TreeNode {
        private final TreeNode origin;
        
        public TreeNodeVisualizeAdapter(TreeNode origin) {this.origin = origin;}
        
        @Override public ConsoleText content() {
            return new PlainConsoleText("" + origin.val);
        }
        
        @Override public List<hu.webarticum.treeprinter.TreeNode> children() {
            return List.of(
                    (this.origin.left != null) ? new TreeNodeVisualizeAdapter(this.origin.left) : new SimpleTreeNode("null"),
                    (this.origin.right != null) ? new TreeNodeVisualizeAdapter(this.origin.right) : new SimpleTreeNode("null")
            );
        }
    }
}
