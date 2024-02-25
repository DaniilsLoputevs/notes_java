package leetcode.structures;

import lombok.Getter;

import java.util.List;

public class ListNodeFacade {
    @Getter
    private ListNode head;
    private ListNode tail;
    
    public ListNodeFacade(List<Integer> nums) {
        ListNode head = null;
        for (int i = nums.size() - 1; i >= 0; i--) {
            head = new ListNode(nums.get(i), head);
            if (this.tail == null) this.tail = head;
        }
        this.head = head;
    }
    
    public ListNode getFirstByValue(int num) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == num) return temp;
            temp = temp.next;
        }
        return null;
    }
    
    @Override public String toString() {
        return this.toStringAsList();
    }
    
    public String toStringAsList() {
        return ListNode.toStringAsList(this.head);
    }
    
    
}
