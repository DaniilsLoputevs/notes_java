package notes.generic;

import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

public class GenericImpl {
    public static void main(String[] args) {
        val list = new MyList(String.class);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        
        val str = (String) list.get(0);
        System.out.println(str);
    }
    
    static class MyList implements Iterable {
        private Object[] data = new Object[20];
        private int size = 0;
        private Class _runtimeDataTypeFromGeneric;
        
        public MyList(Class dataType) {
            this._runtimeDataTypeFromGeneric = dataType;
        }
        
        public void add(Object obj) {
            if (!_runtimeDataTypeFromGeneric.isInstance(obj)) throw new ClassCastException();
            data[size++] = obj;
        }
        
        private Object get(int i) {
            return data[i];
        }
        
        @NotNull @Override public Iterator iterator() {
            return Arrays.stream(data).iterator();
        }
    }
//    class GenericRuntimeInfo {
//        private final Class
//    }
    
    
    public int singleNonDuplicate(int[] nums) {
        int rsl = -1, low = 0, high = nums.length - 1;
        
        while (low <= high) {
            //   88           87    76
            int mid = low + (high - low) / 2;
            int mathIndex = mid + 1;
            int value = nums[mid];
            if (mid == 0 || mid == nums.length - 1) return nums[mid];
            int leftValue = nums[mid - 1];
            int rightValue = nums[mid + 1];
            if (leftValue != value && rightValue != value) return nums[mid];
            
            if (mathIndex % 2 == 0 && nums[mid] == leftValue) {
                low = mid + 1;
            } else if (mathIndex % 2 != 0 && nums[mid] == rightValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return rsl;
    }
}
