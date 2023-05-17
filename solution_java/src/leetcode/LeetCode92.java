package leetcode;

import leetcode.model.ListNode;

/**
 * @author: sunmengjin
 * @create: LeetCode92.class 2022-08-21-20 20:06
 **/
public class LeetCode92 {
    public static void main(String[] args) {
        System.out.println(reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode currentNode = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);

        pre.next = rightNode;
        leftNode.next = currentNode;

        return res.next;
    }

    private static void reverseList(ListNode leftNode) {
        ListNode pre = null;
        ListNode cur = leftNode;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode pre = res;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return res.next;
    }
}
