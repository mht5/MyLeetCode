package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * @author mhts
 * @date 2018Äê8ÔÂ7ÈÕ
 */
public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,6,7};
		ListNode node1=new ListNode(1);
		ListNode node = node1;
		for (int i = 1; i < array.length; i++) {
			node.next = new ListNode(array[i]);
			node = node.next;
		}
		node1.print();
		node1=middleNode(node1);
		System.out.println();
		node1.print();
	}
	
    public static ListNode middleNode(ListNode head) {
    	ListNode node = head;
        int count = 0;
        while (head != null) {
        	head = head.next;
        	count++;
        }
        int num = (count - 1) / 2 + 1;
        while (count > num) {
        	node = node.next;
        	count--;
        }
    	return node;
    }

}
