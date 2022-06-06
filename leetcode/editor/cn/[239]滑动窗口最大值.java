import java.util.*;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = solution.maxSlidingWindow(arr, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            int left = 0, right = 0, i = 0;
            Map windows = new HashMap<>(); //记录当前窗口中的数据，<值,出现的次数>

            List<Integer> sort_nums = new ArrayList<>(nums.length);

            //计算第一个滑动窗口的最大值
            while (right < left + k) {
                sort_nums.add(nums[right]);
                windows.put(nums[right], windows.get(nums[right]) == null ? 1 : (int) windows.get(nums[right]) + 1);
                right++;
            }
            Collections.sort(sort_nums); //排序
            result[i] = sort_nums.get(sort_nums.size() - 1);
            i++;

            //依次滑动滑动窗口，计算最大值
            while (left <= nums.length - k && right < nums.length) {
                sort_nums.add(nums[right]);
                Collections.sort(sort_nums); //排序
                windows = remove(windows, nums, left); //删除最尾部的元素
                windows.put(nums[right], windows.get(nums[right]) == null ? 1 : (int) windows.get(nums[right]) + 1);

                int index = sort_nums.size() - 1;
                //得到当前窗口中的最大值
                while (!windows.containsKey(sort_nums.get(index))) {
                    index--;
                }
                result[i] = sort_nums.get(index);
                i++;
                left++;
                right++;
            }
            return result;
        }


        public Map remove(Map windows, int[] nums, int index) {
            if ((int) windows.get(nums[index]) == 1) {
                windows.remove(nums[index]);
            } else {
                windows.put(nums[index], (int) windows.get(nums[index]) - 1);
            }
            return windows;
        }

        public void printMap(Map map) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object o = iterator.next();
                System.out.print(o + "," + map.get(o));
                System.out.println();
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}