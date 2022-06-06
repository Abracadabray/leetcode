class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode listNode = solution.reverseBetween(new ListNode(new int[]{1, 2, 3}), 2, 3);
        System.out.println(listNode.toString());
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode p = dummy, cur = head;
            int num = 1;
            //处理第一段
            while (num < left) {
                p.next = cur;
                p = p.next;
                cur = cur.next;
                num++;
            }
            p.next = null;
            System.out.println(p.toString());
            System.out.println(cur.toString());
            ListNode p2 = cur;
            while (num >= left && num <= right) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = p.next;
                p.next = tmp;
                num++;
            }
            System.out.println(dummy.next.toString());
            p = p2;
            while (cur != null) {
                p.next = cur;
                cur = cur.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}