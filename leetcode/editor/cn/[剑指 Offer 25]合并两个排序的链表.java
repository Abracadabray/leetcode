class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode currNode = dummyNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currNode.next = l1;
                    l1 = l1.next;
                } else {
                    currNode.next = l2;
                    l2 = l2.next;
                }
                currNode = currNode.next;
            }
            if (l1 == null) {
                currNode.next = l2;
            }
            if (l2 == null) {
                currNode.next = l1;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}