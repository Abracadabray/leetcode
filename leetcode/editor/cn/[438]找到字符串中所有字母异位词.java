import java.util.*;

class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        List<Integer> list = solution.findAnagrams("cbaebabacd", "abc");
//        for (Integer i : list) {
//            System.out.print(i);
//            System.out.print(",");
//        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List result = new ArrayList();
            Map need = new HashMap();
            for (char ch : p.toCharArray()) {
                need.put(ch, need.get(ch) == null ? 1 : (int) need.get(ch) + 1);
            }

            int left = 0;
            int right = 0;
            char[] chars_s = s.toCharArray();
            Map windows = new HashMap();

            while (left <= s.length() - p.length()) {
                //判断[left,left+p.length]是否满足条件,right表示当前窗口元素
                boolean flag = true;
                while (right < left + p.length()) {
                    //当前元素是否在need中，不在的话，直接从right+1处开始再进行判断，同时要重置windows
                    if (!need.containsKey(chars_s[right])) {
                        left = right + 1;
                        right = left;
                        flag = false;
                        windows = new HashMap();//重置windows
                        break;
                    }
                    //更新windows中的值
                    windows.put(chars_s[right], windows.get(chars_s[right]) == null ? 1 : (int) windows.get(chars_s[right]) + 1);
                    right++;
                }

                //处理结果
                if (flag) {
                    if (need.equals(windows)) {
                        result.add(left);
                    }
//                    这个地方进行特殊处理，要不然执行的时候就会：Time Limit Exceeded
//                    windows = new HashMap();//重置windows
                    windows = remove(windows, chars_s, left);
                    left = left + 1;
                }
            }
            return result;
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


//    public List<Integer> findAnagrams(String s, String p) {
//        List result = new ArrayList();
//
//        Map need = new HashMap();
//        for (char ch : p.toCharArray()) {
//            need.put(ch, need.get(ch) == null ? 1 : (int) need.get(ch) + 1);
//        }
//
//        int left = 0;
//        int right = 0;
//        char[] chars_s = s.toCharArray();
//        Map windows = new HashMap();
//
//        while (left <= s.length() - p.length()) {
//            //当前index下标内容不在“p”中，直接取[index+1,index+1+p.length]进行判断
//            System.out.println();
//            System.out.println("当前窗口：left：" + left + ",right：" + right + "," + chars_s[left] + "," + chars_s[right]);
//
//            //判断[index,index+p.length]是否满足条件
//            int tmp = right;
//            boolean flag = true;
//            while (tmp < left + p.length()) {
//                if (!need.containsKey(chars_s[tmp])) {
//                    left = tmp + 1;
//                    right = left;
//                    flag = false;
//                    windows = new HashMap();//重置windows
//                    break;
//                }
//                windows.put(chars_s[tmp], windows.get(chars_s[tmp]) == null ? 1 : (int) windows.get(chars_s[tmp]) + 1);
//                tmp++;
//                right++;
//                System.out.println("====:,left:" + left + ",right:" + right + ",tmp:" + tmp);
//            }
//            System.out.println("处理之后windows：");
//            printMap(windows);
//            System.out.println("11:,left:" + left + ",right:" + right);
//
//            //处理结果
//            if (flag) {
//                if (need.equals(windows)) {
//                    result.add(left);
//                }
//                windows = remove(windows, chars_s, left);
//                left = left + 1;
////                    这个地方进行特殊处理，要不然执行的时候就会：Time Limit Exceeded
////                    windows = new HashMap();//重置windows
////                    index = index + 1;
////                    System.out.println("remove2之后的：");
////                    printMap(windows);
////                    System.out.println("flag:,left:" + left + ",right:" + right);
//            }
//        }
//        return result;
//    }
//
//
//    public Map remove(Map windows, char[] chars_s, int index) {
//        if ((int) windows.get(chars_s[index]) == 1) {
//            windows.remove(chars_s[index]);
//        } else {
//            windows.put(chars_s[index], (int) windows.get(chars_s[index]) - 1);
//        }
//        return windows;
//    }
//
//    public void printMap(Map map) {
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            Object o = iterator.next();
//            System.out.print(o + "," + map.get(o));
//            System.out.println();
//        }
//    }
}