import java.util.Stack;

class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        solution.reverseList(new ListNode(new int[]{1, 2, 3, 4, 5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy, cur = head;

            while (cur != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = p.next;
                p.next = tmp;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}