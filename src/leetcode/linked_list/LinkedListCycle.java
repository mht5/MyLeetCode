package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * https://leetcode.com/problems/linked-list-cycle/description/
 * @author mhts
 * @date 2018Äê8ÔÂ7ÈÕ
 */
public class LinkedListCycle {
	
	public static void main(String[] args) {
		int[] array = new int[] {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
		ListNode node1=new ListNode(-21);
		ListNode node = node1;
		for (int i = 1; i < array.length; i++) {
			node.next = new ListNode(array[i]);
			node = node.next;
		}
		node1.print();
		System.out.println();
		System.out.println(hasCycle(node1));
	}
	
    public static boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) {
    		return false;
    	}
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		return true;
        	}
        }
    	return false;
    }

}
