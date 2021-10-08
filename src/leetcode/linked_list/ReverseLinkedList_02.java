package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * @time: 4/18/21 5:50 PM
 */
public class ReverseLinkedList_02 {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        printNode(node1);
        node1=reverseBetween(node1, 2, 5);
        printNode(node1);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = left; i < right; i++) {
            ListNode node = head.next;
            head.next = node.next;
            node.next = pre.next;
            pre.next = node;
            printNode(dummy.next);
        }
        return dummy.next;
    }

    private static void printNode(ListNode node1) {
        System.out.println();
        System.out.print(node1.val);
        while (node1.next != null) {
            System.out.print("->" + node1.next.val);
            node1 = node1.next;
        }
    }
}
