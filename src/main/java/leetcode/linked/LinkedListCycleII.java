package leetcode.linked;

import leetcode.structures.ListNode;
import leetcode.structures.ListNodeFacade;

import java.util.List;

public class LinkedListCycleII {
    
    // https://leetcode.com/problems/linked-list-cycle-ii/solutions/3274329/clean-codes-full-explanation-floyd-s-cycle-finding-algorithm-c-java-python3/
    public ListNode detectCycle(ListNode head) {
        // Initialize two pointers, slow and fast, to the head of the linked list.
        ListNode slow = head;
        ListNode fast = head;
    
        // Move the slow pointer one step and the fast pointer two steps at a time through the linked list,
        // until they either meet or the fast pointer reaches the end of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // If the pointers meet, there is a cycle in the linked list.
                // Reset the slow pointer to the head of the linked list, and move both pointers one step at a time
                // until they meet again. The node where they meet is the starting point of the cycle.
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    
        // If the fast pointer reaches the end of the list without meeting the slow pointer,
        // there is no cycle in the linked list. Return null.
        return null;
    }
    
    public static void main(String[] args) {
        var facade = new ListNodeFacade(List.of(1,2,3,4,5,6,7,8,9,10));
        facade.getFirstByValue(10).next = facade.getFirstByValue(8);
        var rsl = new LinkedListCycleII().detectCycle(facade.getHead());
        System.out.println(rsl);
    }
}
