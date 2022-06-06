class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String commonStr = "";
            Boolean endFlag = false;
            for (int j = 0; j < strs.length; j++) {//有多少个字符串
                if (strs[j].equals("")) {
                    return commonStr;
                }
            }
            for (int i = 0; i <= 200; i++) {//字符串有多少个元素
                if (i >= strs[0].length()) {
                    break;
                }
                String str = String.valueOf(strs[0].charAt(i));
                for (int j = 0; j < strs.length; j++) {//有多少个字符串
                    if (strs[j].length() <= i) {
                        endFlag = true;
                        break;
                    }
                    String tmp = String.valueOf(strs[j].charAt(i));
                    if (!str.equals(tmp)) {
                        endFlag = true;
                        break;
                    }
                }
                if (endFlag) {
                    break;
                }
                commonStr = commonStr + str;
            }
            return commonStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}