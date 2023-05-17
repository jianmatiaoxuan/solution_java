package leetcode;

import leetcode.model.ListNode;

/**
 * @author: sunmengjin
 * @create: LeetCode206.class 2022-08-21-17 17:15
 **/
public class LeetCode206 {
    public static void main(String[] args) {
        System.out.println(reverseList2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))).toString());
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}