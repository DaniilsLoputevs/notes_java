package leetcode;

public class Temp {
    
    
    public static void main(String[] args) {
        
        int errCode = 404;
        String yield = "asdasd";
//        String msg = switch(errCode) {
//            case 404: yield "Not found!";
//            case 500: yield "Internal server error!";
//            default: yield "Other";
//        };
//        System.out.println(msg);
        
        
        Object o = "hi";
        if (o instanceof String) System.out.println(o);
    
    
        // было
        if (o instanceof String)
        System.out.println(o);
        System.out.println(o);
        
        // стало
        if (o instanceof String)
            System.out.println(o);
        System.out.println(o);
        
        
        var arr = new Object[]{1, "2", 3, "4", 5};
        int rsl = 0;
        for (var elem : arr)
            rsl += (elem instanceof Integer)
                    ? (Integer) elem
                    : (elem instanceof String) ? Integer.parseInt((String) elem)
                    : 0;
        System.out.println(rsl);

//
//        int[] nums1;
//        int m;
//        int[] nums2;
//        int n;
//
//        nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        m = 3;
//        nums2 = new int[]{2, 5, 6};
//        n = 3;
//
//        nums1 = new int[]{1, 6, 8, 0, 0, 0};
//        m = 3;
//        nums2 = new int[]{2, 3, 7};
//        n = 3;
//
//        new Temp().mergeExample(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerOne = m - 1, pointerTwo = n - 1, pointerWrite = nums1.length - 1;
        
        while (pointerTwo >= 0) {
            nums1[pointerWrite--] = (pointerOne >= 0 && nums1[pointerOne] > nums2[pointerTwo])
                    ? nums1[pointerOne--]
                    : nums2[pointerTwo--];
        }
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
