package leetcode.temp;

import leetcode.structures.ListNode;

import java.util.*;
import java.util.stream.Stream;

public class Temp {
    @Override public int hashCode() {
        return super.hashCode();
    }
    
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "3"};
        List<String> list = Arrays.asList(arr); // FixedSizeArrayList
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        arr[1] = "-111";
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        List<String> list1 = new ArrayList<>(list);
        list.set(1, "__");
        System.out.println(list);
        System.out.println(list1);
        

        
        
        
        
        
        
        
        
        // (arg) -> {return void}    - Consumer
        // (arg) -> {return ...}     - Function
        // () -> {return ...}        - Supplier
        // (arg) -> {return boolean} - Predicate
        
        Comparator<Integer> c1 = (a, b) -> Integer.compare(a,b);
        Comparator<Integer> c2 = (a, b) -> Integer.compare(a,b);
        c1.reversed();
        c1.thenComparing(c2);
        Stream.of()
//                .parallel()
                .sorted()
//                .filter()
                .findAny();
    }
    
    
    // n = total count of Nodes.
    // time : O(k + n)
    // space: O(2k + n)  O(n)
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            var heap = new PriorityQueue<ListNode>(lists.length, Comparator.<ListNode>comparingInt(node -> node.val));
            ListNode head = null;
            ListNode current = null;
            
            for (var node : lists) {
                if (node == null) continue;
                heap.offer(node);
            }
            
            while (!heap.isEmpty()) {
                var currMinNode = heap.poll();
                if (currMinNode.next != null) {
                    heap.offer(currMinNode.next);
                }
                if (head == null) {
                    head = currMinNode;
                    current = head;
                } else {
                    current.next = currMinNode;
                    current = current.next;
                }
            }
            return head;
        }
//
        
        
        public static void main(String[] args) {
            // 1,3,4,6
            // 1,2,5,7
            // -4,0,4,7
            var lists = new ListNode[]{
                    new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(6)))),
                    new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(7)))),
                    new ListNode(-4, new ListNode(0, new ListNode(4, new ListNode(7)))),
            };
            var tmp = new Solution().mergeKLists(lists);
            var rsl = new ArrayList<Integer>();
            var iter = new Solution.ListNodeIterator(tmp);
            while (iter.hasNext()) {
                rsl.add(iter.next());
            }
            
            System.out.println(rsl);
        }
        
        static class ListNodeIterator {
            ListNode node;
            
            public ListNodeIterator(ListNode node) {
                this.node = node;
            }
            
            public boolean hasNext() {
                return this.node != null;
            }
            
            public int next() {
                int value = node.val;
                this.node = node.next;
                return value;
            }
        }
    }
    
    
    public static class Out {
        private String name = "Out";
        private Out.In in = new In();
        
        public class In {
            private String id = "111";
        }
        
        static class InStatic {
            private String id = "222";
        }
    }
    
    private void showInnerClass() {
        System.out.println(new Out().in);
        System.out.println((Out.In) new Out().in);
//            System.out.println((Out.In)new Out.In()); // compile err: 'leetcode.temp.Temp.Out' is not an enclosing class
        
        System.out.println(new Out().name);     // 1
//        System.out.println(new Out.In());       // 2
        System.out.println(new Out.InStatic()); // 3
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var que = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                que.offer(List.of(nums1[i], nums2[j]));
            }
        }
        que.sort(
                Comparator.comparingInt(numPair -> numPair.get(0) + numPair.get(1)));
        return que.subList(0, k);
    }
    
    public void mergeExample(int[] nums1, int m, int[] nums2, int n) {
        //variables to work as pointers
        int i = m - 1; // will point at m-1 index of nums1 array
        int j = n - 1; // will point at n-1 index of nums2 array
        int k = nums1.length - 1; //will point at the last position of the nums1 array
        
        // Now traversing the nums2 array
        while (j >= 0) {
            // If element at i index of nums1 > element at j index of nums2
            // then it is largest among two arrays and will be stored at k position of nums1
            // using i>=0 to make sure we have elements to compare in nums1 array
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--; //updating pointer for further comparisons
            } else {
                // element at j index of nums2 array is greater than the element at i index of nums1 array
                // or there is no element left to compare with the nums1 array
                // and we just have to push the elements of nums2 array in the nums1 array.
                nums1[k] = nums2[j];
                k--;
                j--; //updating pointer for further comparisons
            }
        }
    }
}
