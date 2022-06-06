class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
     * 具体而言，如果当前两个链表处相应位置的数字为 n1,n2,carry进位
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。
     * <p>
     * 此外，如果链表遍历结束后，有carry>0，还需要在答案链表的后面附加一个节点。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3_tail = null;  //l3的最尾端元素
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            int val = sum % 10;
            if (l3 == null) {
                l3_tail = new ListNode(val);
                l3 = l3_tail;
            } else {
                l3_tail.next = new ListNode(val);
                l3_tail = l3_tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
        }

        if (carry != 0) {
            l3_tail.next = new ListNode(carry);
        }
        return l3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}