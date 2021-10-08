package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @time: 4/27/21 7:46 PM
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node42 = new ListNode(4);
        node2.next = node4;
        node4.next = node3;
        node5.next = node6;
        node6.next = node42;
        ListNode node = addTwoNumbers(node2, node5);
        printNode(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode cur = prev;
        int extraDigit = 0;
        while (l1 != null || l2 != null) {
            int m = l1 != null ? l1.val : 0;
            int n = l2 != null ? l2.val : 0;
            int sum = m + n + extraDigit;
            extraDigit = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (extraDigit > 0) {
            cur.next = new ListNode(extraDigit);
        }
        return prev.next;
    }

    private static void printNode(ListNode head) {
        while (head != null) {
            System.out.printf("%d\t", head.val);
            head = head.next;
        }
        System.out.println();
    }
}
