class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        solution.lastRemaining(5, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            /**
             * 1、每次要删的数字，都是n数组中的，第m%(n-k)个数字，其中k表示已经删了的数字；
             * 2、需要一个标识表示该数字是否已经被删了；
             */
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = 1;
            }
            int k = n - 1;
            while (k != n - 3) {
                int count = m % (n - k);
                System.out.println(count);
                for (int i = 0; i < n; i++) {
                    System.out.println("count:" + count);
                    if (count == 0) {
                        nums[i] = 0;
                        k--;
                        break;
                    }
                    System.out.println(nums[i]);
                    if (nums[i] == 1 && count != 0) {
                        count--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}