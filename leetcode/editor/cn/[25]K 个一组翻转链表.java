import java.util.Stack;

class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        solution.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 3);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode currNode = dummy;
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            head = dummy.next;

            int circleTimes = length / k;
            int count = 1;

            while (head != null && count <= circleTimes) {
                Stack<ListNode> stack = new Stack<>();
                for (int i = 0; i < k; i++) {
                    stack.push(head);
                    head = head.next;
                }
                while (!stack.isEmpty()) {
                    currNode.next = stack.pop();
                    currNode = currNode.next;
                }
                count++;
            }
            //- Found cycle in the ListNode 不可以出现死链的情况，链表的末尾需要是null值
            count = length - circleTimes * k;
            while (count != 0) {
                currNode.next = head;
                currNode = currNode.next;
                head = head.next;
                count--;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}