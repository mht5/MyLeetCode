package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * @author mhts
 * @date 2018Äê8ÔÂ7ÈÕ
 */
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,3,4,5,6,7};
		ListNode node1=new ListNode(1);
		ListNode node = node1;
		for (int i = 1; i < array.length; i++) {
			node.next = new ListNode(array[i]);
			node = node.next;
		}
		node1.print();
		System.out.println();
		
		int n = 6;
		node1=removeElements1(node1, n);
		node1.print();
	}
	
    public static  ListNode removeElements1(ListNode head, int val) {
    	while (head != null && head.val == val) {
    		head = head.next;
    	}
    	ListNode prev = new ListNode(0);
    	prev.next = head;
    	while (prev != null && prev.next != null) {
    		if (prev.next.val == val) {
    			prev.next = prev.next.next;
    		} else {
    			prev = prev.next;
    		}
    	}
    	return head;
    }
	
    public static  ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
