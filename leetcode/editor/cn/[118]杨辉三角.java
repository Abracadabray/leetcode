import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            int[][] result = new int[numRows][numRows];
            for (int i = 0; i < numRows; i++) {
                result[i][0] = 1;
                result[i][i] = 1;
            }
            for (int i = 2; i < numRows; i++) {
                for (int j = 1; j < i; j++) {
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                }
            }

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < result.length; i++) {
                List<Integer> list1 = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    list1.add(result[i][j]);
                }
                list.add(list1);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}