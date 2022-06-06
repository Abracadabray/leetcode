import java.util.List;
import java.util.Stack;

/**
 * Description:
 * 给定输入：两条单向链表，每个节点上的值为0-9的数字。两条链表分别表示一个十进制数字，
 * 最高位在头节点，即由高位到低位。
 * <p>
 * 你需要输出：一条单向链表，表示输入的两个数字的加和结果。注意格式需与输入相同，
 * 即十进制、从高位到低位。
 * <p>
 * 3->2->0->5 (3205)
 * <p>
 * 1->9->7 (197)
 * <p>
 * 输出
 * <p>
 * 3->4->0->2 (3402)
 * date: 2022/5/9 15:41
 *
 * @author Hy
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(new int[]{3, 2, 0, 5});
        ListNode listNodeB = new ListNode(new int[]{1, 9, 7});
        Test test = new Test();
        System.out.println(test.getResult(listNodeA, listNodeB));
    }


    public ListNode getResult(ListNode listNodeA, ListNode listNodeB) {
        /**
         * 1、将A和B依次遍历入栈，直接相加，超过10补1
         */
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();
        ListNode listNodeC = new ListNode(new int[]{0});
        System.out.println(listNodeC);
        ListNode dummy = listNodeC;

        while (listNodeA.next != null) {
            stackA.push(listNodeA);
            listNodeA = listNodeA.next;
        }
        while (listNodeB.next != null) {
            stackB.push(listNodeB);
            listNodeB = listNodeB.next;
        }
        int count = 0;
        int num = 0;
        while (true) {
            if (stackA.isEmpty() && stackB.isEmpty()) {
                return dummy.next;
            } else if (!stackA.isEmpty() && stackB.isEmpty()) {
                count = stackA.pop().val;
            } else if (stackB.isEmpty() && !stackB.isEmpty()) {
                count = stackB.pop().val;
            } else {
                count = stackA.pop().val + stackB.pop().val;
            }
            if (listNodeC == null) {
                listNodeC = new ListNode(new int[]{0});
            }
            listNodeC.val = count % 10 + num;
            listNodeC.next = new ListNode(new int[]{0});
            listNodeC = listNodeC.next;
            num = count / 10;
        }
    }
//
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//
//        // 链表节点的构造函数
//        // 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
//        public ListNode(int[] arr) {
//            if (arr == null || arr.length == 0) {
//                throw new IllegalArgumentException("arr can not be empty");
//            }
//
//            this.val = arr[0];
//            ListNode cur = this;
//            for (int i = 1; i < arr.length; i++) {
//                cur.next = new ListNode(arr[i]);
//                cur = cur.next;
//            }
//        }
//
//        //以当前节点为头节点的链表信息字符串 方便查看
//        @Override
//        public String toString() {
//            StringBuilder res = new StringBuilder();
//            ListNode cur = this;
//            while (cur != null) {
//                res.append(cur.val + "->");
//                cur = cur.next;
//            }
//            res.append("NULL");
//            return res.toString();
//        }
//
//    }

}

