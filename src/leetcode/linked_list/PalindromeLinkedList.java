package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * @author mhts
 * @date 2018Äê8ÔÂ8ÈÕ
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,4,3,2,1};
		ListNode node1=new ListNode(1);
		ListNode node = node1;
		for (int i = 1; i < array.length; i++) {
			node.next = new ListNode(array[i]);
			node = node.next;
		}
		node1.print();
		System.out.println();
		System.out.println(isPalindrome(node1));
	}
	
    public static boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
    	}
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode prev = null;
    	ListNode next = head.next;
    	ListNode left = null;
    	ListNode right = null;
    	
    	while (fast != null && fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		next = slow.next;
    		slow.next = prev;
    		prev = slow;
    		slow = next;
    		next = next.next;
    	}
    	
    	if (fast.next == null) {
    		left = prev;
    		right = next;
    	} else {
    		slow.next = prev;
    		left = slow;
    		right = next;
    	}
    	
    	while (left != null && right != null) {
    		if (left.val != right.val) {
    			return false;
    		}
			left = left.next;
			right = right.next;
    	}
    	
    	return true;
    }

}
