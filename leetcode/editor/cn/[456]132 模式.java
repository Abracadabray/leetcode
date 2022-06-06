import java.util.Stack;

//中间值最大，左边值最小，右边值第二大    求有条件的峰值
class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
        solution.find132pattern(new int[]{3, 5, 0, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            /**
             * 查找数据ABC，C是B右边最大的数据，找到一个A，A只要比B小就满足条件
             * 1、定义栈的结构，为空则入栈，如果入栈数据比栈顶大，则弹出，并将其设置为C；
             * 2、在余下的数组中，找到一个满足条件的A即可；
             */
            Stack<Integer> stack = new Stack();
            if (nums.length < 3) {
                return false;
            }

            int last = Integer.MIN_VALUE; //直接初始化为最小的，定义为2的位置

            //倒序开始查找，因为132种找1的位置（最小值），比找2的位置好找一些
            for (int i = nums.length - 1; i >= 0; i--) {
                //如果当前值小于last，则表示满足条件
                if (nums[i] < last) {
                    return true;
                }
                //如果当前值小于栈顶，则比较当前值是否满足条件，满足条件则返回，不满足条件中 // 相当于比较了3 > 2
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    last = stack.pop();
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}