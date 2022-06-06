import java.util.ArrayList;
import java.util.List;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            List arrayList = new ArrayList();
            int max = 0;
            Boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char tail = s.charAt(i);
                while (arrayList.contains(tail)) {
                    arrayList.remove(0); //将第一个元素移出
                    flag = false;
                }
                arrayList.add(s.charAt(i));
                if (max < arrayList.size()) {
                    max = arrayList.size();
                }
            }
            if (flag) {
                max = arrayList.size();
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}