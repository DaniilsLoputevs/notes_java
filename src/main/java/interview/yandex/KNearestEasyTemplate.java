package interview.yandex;

/*
Дан отсортированный массив целых чисел arr, индекс элемента index и целое число K.
Необходимо вернуть в любом порядке K чисел из массива, которые являются ближайшими
по значению к элементу arr[index].
arr = [1, 2, 3, 5, 8, 9, 11, 13, 14], index = 3, K = 3
rsl = [5, 3, 2]

* arr[].length >= K
* arr[].length >=1 && K >= 1
* arr[i] <= Integer.MAX_VALUE;
* элемент arr[index] всегда входит в итоговый лист.
* приоритет отдаётся элементу с меньшем значение.
** 5 - 2 = 3 (разница между 5 и 2)
** 8 - 5 = 3 (разница между 5 и 8)
** между 8 и 2 для 5 выбирает 2.
 */

import java.util.List;

public class KNearestEasyTemplate {
    
    public List<Integer> findClosestElements(int[] arr, int index, int k) {
        // write your code here...
        return null;
    }
    
}
