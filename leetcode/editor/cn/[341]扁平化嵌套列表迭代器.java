import java.util.Iterator;
import java.util.List;

class FlattenNestedListIterator {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {

        public NestedIterator(List<NestedInteger> nestedList) {

        }

        @Override
        public Integer next() {
            return 0;

        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}