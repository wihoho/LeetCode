import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/7/2016.
 */
public class NestedIterator {
    private List<Integer> nums;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        nums = new ArrayList<>();
        for(NestedInteger nestedInteger: nestedList) {
            add(nestedInteger);
        }
        iterator = nums.iterator();
    }

    private void add(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            nums.add(nestedInteger.getInteger());
        } else {
            for(NestedInteger nestedInteger1: nestedInteger.getList()) {
                add(nestedInteger1);
            }
        }
    }

    public Integer next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
