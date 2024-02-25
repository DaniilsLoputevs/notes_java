package leetcode.structures;

import java.util.StringJoiner;

public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) {this.val = val;}
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    @Override public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + ((next == null) ? "null" : "Object("+ next.val+")"))
                .toString();
    }
    
    /* static part */
    
    public static String toStringAsList(ListNode node) {
        if (node.next == null)
            return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode next = node;
        for (; ; ) {
            sb.append(next.val);
            if (next.next == null)
                return sb.append(']').toString();
            else {
                next = next.next;
                sb.append(',').append(' ');
            }
        }
    }
}
