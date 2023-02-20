package leetcode.zig_zag_iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Zigzag Iterator
 * Given K List of integers.
 * 0 = [1, 2]
 * 1 = [3, 4, 5, 6]
 * 2 = [7, 8, 9, 10]
 * Need to return Iterator that walking in this way:
 * [1, 3, 7, 2, 4, 8, 5, 9, 6, 10]
 *
 * https://ttzztt.gitbooks.io/lc/content/zigzag-iterator.html
 */
class ZigZagIteratorTemplate implements ZigZagIterator {
    public ZigZagIteratorTemplate(List<Integer>[] lists) {
        // write your code here...
    }
    
    public boolean hasNext() {
        // write your code here...
        return false;
    }
    
    public Integer next() {
        // write your code here...
        return -1;
    }
}

public interface ZigZagIterator extends Iterator<Integer> {}
