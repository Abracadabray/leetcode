import java.util.ArrayList;
import java.util.List;

//如果使用暴力破解，需要N次循环才行，这样成本太大，根本写不出来啊
class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> stringList : result) {
            for (String str : stringList) {
                System.out.println(str);
            }
            System.out.println("=======================================");
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();//结果
            int[][] isFree = new int[n][n]; //记录当前位置是否可以放皇后
            char[][] chs = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    isFree[i][j] = 0;
                    chs[i][j] = '.';
                }
            }
            backTracing(chs, 0, n, result, isFree);
            return result;
        }

        public void backTracing(char[][] chs, int row, int n, List<List<String>> res, int[][] isFree) {
            //每行都摆满皇后时，则产生了一种解法
            if (row == n) {
                res.add(chsToList(chs));
                return;
            }
            //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
            //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
            for (int col = 0; col < chs[0].length; col++) {
                if (isFree[row][col] == 0) {
                    int[][] temp = new int[n][n];//临时保存该值，后面便于回溯,这个位置不可以直接等于int[][] temp = isFree;要改成强引用
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            temp[i][j] = isFree[i][j];
                        }
                    }
                    chs[row][col] = 'Q';
                    isFree = dealFree(n, isFree, row, col); //处理当前皇后的isFree对应的值

                    //递归
                    backTracing(chs, row + 1, n, res, isFree);
                    //回溯
                    isFree = temp;
                    chs[row][col] = '.';
                }
            }
        }

        public List<String> chsToList(char[][] chs) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < chs.length; i++) {
                list.add(new String(chs[i]));
            }
            return list;
        }

        //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
        //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
        public boolean isValid(char[][] chs, int x, int y) {
            for (int i = 0; i <= x; i++) {
                for (int j = 0; j < chs[0].length; j++) {
                    if (chs[i][j] == 'Q' && (j == y || Math.abs(x - i) == Math.abs(y - j))) {
                        return false;
                    }
                }
            }
            return true;
        }

        public int[][] dealFree(int n, int[][] isFree, int row, int col) {
            for (int i = 0; i < n; i++) { //行
                for (int j = 0; j < n; j++) { //列
                    float x = i - row;
                    float y = j - col;
                    if (i == row || j == col || x / y == 1 || y / x == -1) {
                        isFree[i][j] = 1;
                    }
//                    if (i == row || j == col || Math.abs(i - row) == Math.abs(j - col)) {
//                        isFree[i][j] = 1;
//                    }
                }
            }
            return isFree;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}