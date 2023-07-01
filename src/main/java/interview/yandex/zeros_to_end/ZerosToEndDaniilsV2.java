package interview.yandex.zeros_to_end;


public class ZerosToEndDaniilsV2 implements ZerosToEnd {
    
    // time: O(n)  O(n-1)
    // space: O(1)
    @Override public void zeroesToEnd(int[] nums) {
        int pt1 = 0;
        int pt2 = pt1 + 1;
    
        while (pt2 < nums.length) {
            if (nums[pt1] != 0) {
                pt1++;
                pt2 = pt1 + 1;
                continue;
            }
            int pt2Value = nums[pt2];
            if(pt2Value != 0) {
                nums[pt1] = pt2Value;
                nums[pt2] = 0;
                pt1++;
                pt2 = pt1 + 1;
            } else {
                pt2++;
            }
        }
    }
}

