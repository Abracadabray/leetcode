import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("qxsncfwvbslazxuoxnedkukropehlwfbwxqycntdfgghecvdqbhcwtukkauwzzzvystcfohmupvastekunmqiidtjxriyqdyiyapohekxblrurbpgphoykjhjarhtwfduhvkpzumahdxagmivtxvgiepjvxetehnmczddurgdwdecrmzklxqubgfzfjslqizvheadvghrlnvcbxpnuhjxpqywzrkrbjokqpolxxflkapnzeatmltdbrackkwlvmwlbmxbjcmvebieilzwyszckzgulcihpgsssrtdvhaaligvvfrwaqyksegdjqmywfsoyotuxtwieefbjwxjpxvhcemnwzntgfjetdatyydecjgofdzudxbfbqsxpfsvmebijcbhcemfnuvtzupcrthujbuyiovvswdbagjdkxkyrftqbktvdcpogloqajlsgquiyfljcxjveengogbulsitexjeixwqpszoxkzzkiuooiweqxydqjywiiaqhyhwrgkosloetktjuponposfxrdhzdyibhesprjjczoyjhhgyxtnmlulextdatnecsyrlhangonsxxywutligguldpqgiemkymdjufycumwtjupfpdowjkjozzwjdivbvymrdlvzzstkmkpenfcyplnqkjzquutrsgiytdxsvsckftquzstqdihnrgfnbbevjovcutupnyburrpsjijmsqclyjzzk", "fxtusxonrfdrhxjamdkwm"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map windows = new HashMap();
            Map need = new HashMap();

            //特殊情况，直接返回
            if (s.contains(t)) {
                return t;
            }

            //初始化
            char[] ch_t = t.toCharArray();
            for (char ch : ch_t) {
                need.put(ch, need.containsKey(ch) ? (int) need.get(ch) + 1 : 1);
            }

            char[] ch_s = s.toCharArray();
            int left = 0, right = 0, min_left = 0, min_right = 0;

            while (right < s.length()) {
                //找到部分值
                if (need.containsKey(ch_s[right])) {
                    int num = windows.get(ch_s[right]) == null ? 1 : (int) windows.get(ch_s[right]) + 1;
                    windows.put(ch_s[right], num);
                } else if (windows.size() == 0) {
                    left++;
                }
                right++;

                //找到了
                while (valid(need, windows)) {
                    //更新值
                    if (right - left < min_right - min_left || (min_left == 0 && min_right == 0)) {
                        min_right = right;
                        min_left = left;
                    }

                    if ((int) windows.get(ch_s[left]) == 1) {
                        windows.remove(ch_s[left]);
                    } else {
                        windows.put(ch_s[left], (int) windows.get(ch_s[left]) - 1);
                    }

                    //找到第一个不满足的need条件的left
                    left++;
                    while (left < right && !need.containsKey(ch_s[left])) {
                        left++;
                    }
                    continue;
                }
            }
            return s.substring(min_left, min_right) == null ? "" : s.substring(min_left, min_right);
        }

        public void printMap(Map map) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object o = iterator.next();
                System.out.print(o + "," + map.get(o));
                System.out.println();
            }
        }

        public boolean valid(Map need, Map windows) {
            Iterator iterator = need.keySet().iterator();
            while (iterator.hasNext()) {
                Object o = iterator.next();
                if (!windows.containsKey(o) || (int) windows.get(o) < (int) need.get(o)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}