package interview.yandex;

/*
Дан отсортированный массив целых чисел a , индекс элемента index и целое число K .
Необходимо вернуть в любом порядке K чисел из массива, которые являются ближайшими
 по значению к элементу arr[index].
   [1, 2, 3, 5, 8, 9, 11, 13, 14]  index = 3, K = 3
=> [5, 3, 2]


* arr[].length >= K
* arr[].length >=1 && K >= 1
* arr[i] <= Integer.MAX_VALUE;
* элемент arr[index] всегда входит в итоговый лист.
* приоритет отдаётся элементу с меньшем значение.
** 5 - 2 = 3 (разница между 5 и 2)
** 8 - 5 = 3 (разница между 5 и 8)
** между 8 и 2 для 5 выбирает 2.
 
 [1, 2, 3, 5, 8, 9, 11, 13, 14]  index = 3, K = 3
     1     ^  1
[1, 2, 3] 5 [ 8, 9, 11, 13, 14]

3 2

[1, 2, 5, 6, 7, 11, 13, 14]
    ^
5 6 7
Ответ:
[2, 3, 5]

 */

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class KNearestEasy {
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
        int valueLeft = arr[left];
        int valueRight = arr[right];
        
        while (rsl.size() < k) {
            if (left > -1) valueLeft = arr[left--];
            else valueLeft = Integer.MAX_VALUE;
            if (right < arr.length) valueRight = arr[right++];
            else valueLeft = Integer.MAX_VALUE;
            
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
