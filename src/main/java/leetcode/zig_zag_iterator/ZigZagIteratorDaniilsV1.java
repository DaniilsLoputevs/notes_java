package leetcode.zig_zag_iterator;

import lombok.val;

import java.util.ArrayList;
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
 */
public class ZigZagIteratorDaniilsV1 implements ZigZagIterator {
    private Iterator<Integer> currIter;
    private final ArrayList<Iterator<Integer>> iters = new ArrayList<>();
    
    public ZigZagIteratorDaniilsV1(List<Integer>[] lists) {
        if (lists.length == 0) return;
        for (val l : lists) {
            iters.add(l.iterator());
        }
        currIter = iters.get(0);
    }
    
    public boolean hasNext() {
        return currIter != null && currIter.hasNext();
    }
    
    public Integer next() {
        val rsl = currIter.next();
        updateCurrIter();
        return rsl;
    }
    
    private void updateCurrIter() {
        Iterator<Integer> newIter;
        while (true) {
            int currIterIndex = iters.indexOf(currIter);
            newIter = iters.get((currIterIndex == iters.size() - 1) ? 0 : currIterIndex + 1);
            if (!currIter.hasNext()) {
                iters.remove(currIter);
                
                if (iters.isEmpty()) {
                    currIter = null;
                    return;
                }
            }
            if (newIter.hasNext()) break;
        }
        currIter = newIter;
    }
}
