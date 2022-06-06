import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() > s2.length()) {
                return false;
            }

            Map need = new HashMap();
            for (char ch : s1.toCharArray()) {
                need.put(ch, need.get(ch) == null ? 1 : (int) need.get(ch) + 1);
            }

            Map windows = new HashMap();
            int left = 0;
            int right = 0;
            char[] chars_s2 = s2.toCharArray();
            while (left <= s2.length() - s1.length()) {
                System.out.println("当前窗口：left：" + left + ",right：" + right + "," + chars_s2[left] + "," + chars_s2[right]);
                boolean flag = true;
                while (right < left + s1.length()) {
                    System.out.println(right);
                    if (!need.containsKey(chars_s2[right])) {
                        left = right + 1;
                        right = left;
                        flag = false;
                        windows = new HashMap();
                        break;
                    }
                    //更新windows中的值
                    windows.put(chars_s2[right], windows.get(chars_s2[right]) == null ? 1 : (int) windows.get(chars_s2[right]) + 1);
                    right++;
                }

                //窗口个数达到指定个数
                if (flag) {
                    if (need.equals(windows)) {
                        return true;
                    }
                    System.out.println("-------------------");
                    windows = remove(windows, chars_s2, left);
                    left = left + 1;
                    System.out.println("windows:");
                    printMap(windows);
                    System.out.println("left:" + left);
                }
            }
            return false;
        }


        public Map remove(Map windows, char[] chars_s, int index) {
            if ((int) windows.get(chars_s[index]) == 1) {
                windows.remove(chars_s[index]);
            } else {
                windows.put(chars_s[index], (int) windows.get(chars_s[index]) - 1);
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