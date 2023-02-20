package interview.yandex;

import java.util.ArrayList;
import java.util.List;

public class KNearestEasyTemplateSolved {
    // [1, 2, 5, 6, 7, 11, 13, 14]
    //              ^
    public List<Integer> findClosestElements(int[] arr, int index, int k) {
        var rsl = new ArrayList<Integer>();
        int target = arr[index];
        
        if (index == 0) {
            if (arr.length == 1) return rsl;
            for (int i = 1; i < k - 1; i++) {
                rsl.add(arr[i]);
            }
            return rsl;
        } else if (index == arr.length - 1) {
            for (int i = arr.length - 1; rsl.size() != k; i--) {
                rsl.add(arr[i]);
            }
            return rsl;
        }
        
        int left = index - 1;
        int right = index + 1;
//        int valueLeft = arr[left];
//        int valueRight = arr[right];
        Integer valueLeft;
        Integer valueRight;
        
        while (rsl.size() < k) {
            if (left > -1) valueLeft = arr[left--];
//            else valueLeft = Integer.MAX_VALUE;
            else valueLeft = null;
            if (right < arr.length) valueRight = arr[right++];
//            else valueLeft = Integer.MAX_VALUE;
            else valueRight = null;
            
            int differentLeft = target - valueLeft;
            int differentRight = valueRight - target;
            
            if (differentLeft <= differentRight) {
                rsl.add(valueLeft);
            } else {
                rsl.add(valueRight);
            }
        }
        return rsl;
    }
}
