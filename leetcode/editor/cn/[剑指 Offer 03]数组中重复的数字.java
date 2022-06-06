import java.util.HashSet;
import java.util.Set;

class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        solution.findRepeatNumber(new int[]{10000});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return nums[i];
                } else {
                    set.add(nums[i]);
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}