class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] tempNums1 = new int[nums1.length];
            int i = 0;
            int j = 0;
            int count = 0;
            while (m != 0 || n != 0) {
                if (m != 0 && (n == 0 || nums1[i] <= nums2[j])) {
                    tempNums1[count] = nums1[i];
                    m--;
                    i++;
                } else {
                    tempNums1[count] = nums2[j];
                    n--;
                    j++;
                }
                count++;
            }
            for (int k = 0; k < tempNums1.length; k++) {
                nums1[k] = tempNums1[k];
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}