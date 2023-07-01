package leetcode.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestPair {
    
    public static void main(String[] args) {
        var nums1 = new int[] {0,1,2,3,4};
        var nums2 = new int[] {5,6,7,8,9, 10};
        var k = 77;
        var rsl = new Solution().kSmallestPairs(nums1, nums2, k);
        System.out.println("result collection size = " + rsl.size());
        System.out.println("for loop iteration count = " + Solution.forIterationCount);
        System.out.println("while loop iteration count = " +Solution.whileIterationCount);
    }
    static class Solution {
        static int forIterationCount = 0;
        static int whileIterationCount = 0;
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            
            List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
            PriorityQueue<int[]> pq = new PriorityQueue<>(nums1.length, (a, b) -> a[0] - b[0]);
            // Priority queue to store pairs with smallest sums, sorted by the sum
            
            // Push the initial pairs into the priority queue
            for (int x : nums1) {
                forIterationCount++;
                pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
            }
            
            // Pop the k smallest pairs from the priority queue
            while (k > 0 && !pq.isEmpty()) {
                whileIterationCount++;
                int[] pair = pq.poll();
                int sum = pair[0]; // Get the smallest sum
                int pos = pair[1]; // Get the index of the second element in nums2
                
                List<Integer> currentPair = new ArrayList<>();
                currentPair.add(sum - nums2[pos]);
                currentPair.add(nums2[pos]);
                resV.add(currentPair); // Add the pair to the result list
                
                // If there are more elements in nums2, push the next pair into the priority queue
                if (pos + 1 < nums2.length) {
                    pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
                }
                
                k--; // Decrement k
            }
            
            return resV; // Return the k smallest pairs
        }
    }
    
    
// time: O(n)

// NOT WORK : TIME LIMIT
// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         var que = new LinkedList<List<Integer>>();
//         for(int i = 0; i < nums1.length; i++) {
//             for(int j = 0; j < nums2.length; j++) {
//                 que.offer(List.of(nums1[i], nums2[j]));
//             }
//         }
//         que.sort(
//             (numPair1, numPair2) -> Integer.compare(
//                 numPair1.get(0) + numPair1.get(1),
//                 numPair2.get(0) + numPair2.get(1)
//             ));
//         return (que.size() > k) ? que.subList(0, k) : que;
//     }
// }
}
