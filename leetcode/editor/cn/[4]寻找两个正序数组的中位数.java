import java.util.*;
import java.util.stream.Collectors;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int count = nums1.length + nums2.length;


            if (nums1.length > nums2.length) {
                List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
                for (int i = 0; i < nums2.length; i++) {

                }


            }


            return 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}