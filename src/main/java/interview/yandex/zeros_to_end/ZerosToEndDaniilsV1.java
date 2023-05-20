package interview.yandex.zeros_to_end;


public class ZerosToEndDaniilsV1 implements ZerosToEnd {
    
    // [1, 2, 0, 3, 0, 4] -> [1, 2, 3, 4, 0, 0]
    //        ^  ^
    //        1  2
    @Override public void zeroesToEnd(int[] nums) {
        int readPointer = 0, writePointer = 1;
        for (; readPointer < nums.length; readPointer++) {
            int readValue = nums[readPointer];
            if (readValue != 0) {
                readPointer++;
                continue;
            }
            
            if (writePointer < readPointer) writePointer = readPointer +1;
            for (; writePointer < nums.length; writePointer++) {
                int writeValue = nums[writePointer];
                if (writeValue != 0) {
                    nums[readPointer] = writeValue;
                    nums[writePointer] = 0;
                    break;
                }
            }
        }
    }
}

