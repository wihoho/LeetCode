import java.util.Iterator;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 6/5/2016.
 */

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer currentValue;
    boolean peekFlag;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekFlag) return currentValue;
        else {
            currentValue = iterator.next();
            peekFlag = true;
            return currentValue;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekFlag) {
            peekFlag = false;
            return currentValue;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return peekFlag || iterator.hasNext();
    }
}
