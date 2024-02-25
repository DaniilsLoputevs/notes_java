package interview.natasha_Remotza;

import hu.webarticum.treeprinter.SimpleTreeNode;
import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class TreeVisualization {
    public static void printTreeTopDown(TreeNode root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(root.data);
            
            printTreeTopDown(root.left, indent, false);
            printTreeTopDown(root.right, indent, true);
        }
    }
    
    private static void vizTree() {
        SimpleTreeNode root = new SimpleTreeNode("1");
        var two = new SimpleTreeNode("2");
        var thr = new SimpleTreeNode("3");
        root.addChild(two);
        root.addChild(thr);
        two.addChild(new SimpleTreeNode("4"));
        two.addChild(new SimpleTreeNode("5"));
        thr.addChild(new SimpleTreeNode("6"));
        thr.addChild(new SimpleTreeNode("7"));
    
        new TraditionalTreePrinter().print(root);
        
    }
    public static void main(String[] args) {
        vizTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTreeTopDown(root, "", true);
    }
}

