import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        String str = "aab";
        solution.permutation(str);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            Set<String> reslut = new HashSet<>();
            char[] arr = s.toCharArray();
            boolean[] visited = new boolean[arr.length];
            dfs(arr, visited, "", reslut);
            Iterator iterator = reslut.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            return reslut.toArray(new String[0]);
        }

        /**
         * @param arr  数组
         * @param s    遍历数组
         * @param list 列表
         */
        public void dfs(char[] arr, boolean[] visited, String s, Set<String> list) {
            if (s.length() == arr.length) {
                list.add(s);
            }
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(arr, visited, s + arr[i], list);
                visited[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}