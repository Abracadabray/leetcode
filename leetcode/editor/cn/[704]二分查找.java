class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    return middle;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
                System.out.println(left + "   " + right + "   " + middle);
            }

            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}