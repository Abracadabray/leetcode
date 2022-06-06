class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        int[] nums = {3, 4, 3, 2, 1};
        solution.findPeakElement(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] > nums[1]) {
                return 0;
            }
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }

            int left = 0;
            int right = nums.length - 1;
            while (true) {
                int middle = (left + right) / 2;
                System.out.println(middle);
                if (left > right) {
                    return -1;
                }
                if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                    return middle;
                }
                if (nums[middle - 1] >= nums[middle + 1]) {
                    right = middle;
                } else {
                    left = middle;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}