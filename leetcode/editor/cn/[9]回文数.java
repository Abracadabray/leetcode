class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x >= 0 && x < 10) {
                return true;
            }
            if (x < 0 || x % 10 == 0) {
                return false;
            }
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x = x / 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}