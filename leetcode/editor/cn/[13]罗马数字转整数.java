import java.util.HashMap;

class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            HashMap hashMap = new HashMap();
            hashMap.put("I", 1);
            hashMap.put("V", 5);
            hashMap.put("X", 10);
            hashMap.put("L", 50);
            hashMap.put("C", 100);
            hashMap.put("D", 500);
            hashMap.put("M", 1000);
            hashMap.put("IV", 4);
            hashMap.put("IX", 9);
            hashMap.put("XL", 40);
            hashMap.put("XC", 90);
            hashMap.put("CD", 400);
            hashMap.put("CM", 900);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                String str1 = String.valueOf(s.charAt(i));
                String str2 = String.valueOf(s.charAt(i));
                if (("I".equals(str1) || "X".equals(str1) || "C".equals(str1)) && i < s.length() - 1) {
                    str1 = str1 + s.charAt(i + 1);
                    if (hashMap.containsKey(str1)) {
                        count = count + (int) hashMap.get(str1);
                        i++;
                        continue;
                    }
                }
                count = count + (int) hashMap.get(str2);
            }
            return count;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}