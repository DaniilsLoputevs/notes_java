package leetcode.array;

public class MergeSortedArray {
    
    class V2 {
        public static void main(String[] args) {
            class Node {
                int val;
            }
        }
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int ptL = m - 1;
            int ptR = n - 1;
            int ptW = nums1.length - 1;
            
            while (ptR >= 0) {
                nums1[ptW--] = (ptL >= 0 && nums1[ptL] > nums2[ptR])
                        ? nums1[ptL--]
                        : nums2[ptR--];
            }
        }
    }
    
    class V1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int pointerOne = m - 1, pointerTwo = n - 1, pointerWrite = nums1.length - 1;
            
            while (pointerTwo >= 0) {
                nums1[pointerWrite--] = (pointerOne >= 0 && nums1[pointerOne] > nums2[pointerTwo])
                        ? nums1[pointerOne--]
                        : nums2[pointerTwo--];
            }
            System.gc();
        }
    }
}
