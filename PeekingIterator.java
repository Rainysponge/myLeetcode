package LC;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
    Deque<Integer> queue = new LinkedList<>();

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            queue.push(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int a = queue.poll();
        return a;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
