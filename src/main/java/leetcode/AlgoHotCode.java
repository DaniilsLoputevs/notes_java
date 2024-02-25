package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static leetcode.structures.Utils.arr;

public class AlgoHotCode {
    // Approach:
    // Using binary search and a sliding window, find the midpoint where,
    // the integers between midpoint and midpoint + k is the k closest integers to x.
    
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // The sliding window is between 'mid' and 'mid' + k.
        int left = 0, right = arr.length - k;
        while (left < right) {
            int midpoint = left + (right - left) / 2; // same as (left + right) / 2
            
            // With midpoint on the left, we use x - arr[midpoint], while arr[midpoint + k] - x because it is on the right.
            // This is important!
            // Rather than using Math.abs(), we need the direction keep the x within the sliding window.
            // If the window is too far left, we shift the window to the right.
            if (x - arr[midpoint] > arr[midpoint + k] - x) {
                left = midpoint + 1;
            }
            // If the window is too far right, we shift the window to the left.
            else {
                right = midpoint;
            }
        }
        
        // Input all the k closest integers into the result.
        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    public int search(int[] nums, int target) {
        int start = 0, startVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                start = i;
                startVal = nums[i];
                break;
            }
        }
        
        int l = -1, r = -1;
        
        switch (Integer.compare(nums[nums.length - 1], target)) {
            case -1 -> { // startVal < target
                l = 0;
                r = start -1 ;
            }
            case 1 -> { // startVal > target
                l = start;
                r = nums.length - 1;
            }
            case 0 -> {return nums.length - 1; }
        }
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int temp = nums[mid];
            if (temp == target) return mid;
            if (temp < target) l = mid + 1;
            if (temp > target) r = mid - 1;
        }
        return -1;
    }
    private static void findSmallRun() {
        var nums1 = arr(-30, -20, -10, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
//        var rsl = findClosestElements(nums1, 3, 11);
//        var rsl = findClosestElements(nums1, 3, 100);
//        var rsl = findClosestElements(nums1, 3, 110);
//        System.out.println(findClosestElements(nums1, 3, 100));
//        System.out.println(findClosestElements(nums1, 3, 110));
        System.out.println(findClosestElements(nums1, 3, 90));
      
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int targetIndex = -1;
        loop: while(l <= r) {
            int mid = l + (r - l) / 2;
            switch (Integer.compare(nums[mid], target)) {
                case 1 -> { // mid > target
                    r = mid - 1;
                }
                case -1 -> { // mid < target
                    l = mid + 1;
                }
                case 0 -> {
                    targetIndex = mid;
                    // in case that java switch expression break work for switch-case block
                    // and don't work for parent loop block - use label for stop while loop is fine.
                    break loop;
                }
            }
        }
        
        // element not found
        if (targetIndex == -1) return new int[] {-1, -1};
        l = r = targetIndex;
        var rsl = new int[] {l, r};
        int valueL = nums[l];
        int valueR =  nums[r];
        while (valueL == target || valueR == target) {
            valueL = (l == 0) ? Integer.MIN_VALUE : nums[l];
            valueR = (r == nums.length) ? Integer.MAX_VALUE : nums[r];
            if (valueL == target) {
                rsl[0] = l;
                l--;
            }
            if (valueR == target) {
                rsl[1] = r;
                r++;
            }
        }
        return rsl;
    }
    public static int[] change(int money, int price) {
        int[] coins = {10, 5, 2, 1};
        int[] rsl = new int[100];
        int size = 0;
        money -=  price; // убрал переменную exp, заменил на money = money - price;
        for (int coin : coins) {
            while (money >= coin) {
                money -= coin;
                rsl[size++] = coin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
//}
    
    class AbstractJourney {
        static class Abstract {}
    
        public static Abstract getConcrete() {
            return new Abstract() {};
        }
    
        public static void main(String[] args) {
            Abstract obj1 = new Abstract(){};
            Abstract obj2 = new Abstract(){};
            boolean b1 = compareClass(obj1, obj2);
            boolean b2 = compareClass(getConcrete(), obj2);
            boolean b3 = compareClass(getConcrete(), getConcrete());
            boolean b4 = compareClass(obj1, getConcrete());
            boolean b5 = compareClass(obj1, obj1);
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            
            System.out.println(getConcrete().getClass().getName());
            System.out.println(getConcrete().getClass().getName());
            System.out.println(obj1.getClass().getName());
            System.out.println(obj2.getClass().getName());
        }
    
        public static boolean compareClass(Object o1, Object o2) {
            return o1.getClass() == o2.getClass();
        }
    }
   static class DTO {
        public static int newId() {
            return new Random().nextInt();
        }
   }
    public static void main(String[] args) throws IOException {
        
        
        List<String > list = new ArrayList<String>();
//        var o = list.of(1,2);
        
        var dto = new DTO();
        int newId = dto.newId();
        
        
        AbstractJourney.main(null);
////        Каким образом можно проверить наличие аннотации над методом? (несколько вариантов ответа)
//        var o = Object.class.getDeclaredMethod("finalize").getAnnotation(Deprecated.class) != null;
//        Object.class.getDeclaredMethod("finalize").isAnnotationPresent(Deprecated.class);
////        Deprecated.isAppliedTo(Object.class.getDeclaredMethod("finalize"));
//        Object.class.getDeclaredMethod("finalize") instanceof Deprecated;
////        Array.newInstance()
    
//        var o = Optional.ofNullable("").flatMap(__ -> Optional.of(new Integer(1)));
//        Runtime.getRuntime().halt();
//        LocalDateTime.now().atZone()
        
//        var str = "";
//        str += "";
//        var a1 = new ArrayList<String >() {};
//        var a2 = new ArrayList<String >() {};
//        System.out.println(a1.getClass().getName());
//        System.out.println(a2.getClass().getName());
        
        
        var obj = new AlgoHotCode();
        System.out.println(Arrays.toString(obj.change(100, 13)));
//        var ints = obj.searchRange(arr(1), 1);
//        var ints = obj.searchRange(arr(5, 7, 7, 8, 8, 10), 6);
//        var ints = obj.searchRange(arr(), 0);
        var ints = obj.searchRange(arr(1,1 ,2), 1);
        System.out.println(Arrays.toString(ints));
//        int l = 0, r = 1, temp = 10;
//        l = r = temp;
//        System.out.println(l);
//        System.out.println(r);
//        System.out.println(temp);
        
        
//        new AlgoHotCode().fun(4);
//        new AlgoHotCode().search(arr(4,5,6,7,0,1,2), 0);
//        findSmallRun();
    }
    
}
