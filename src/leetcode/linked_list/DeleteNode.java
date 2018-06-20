package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * @author mhts
 *
 */
public class DeleteNode {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = null;
//		node3.next = node4;
//		node4.next = null;
		
		deleteNode(node1);
		
		boolean flag = true;
		while(flag){
			System.out.print(node1.val+"->");
			if(node1.next!=null)
				node1=node1.next;
			else{
				System.out.println("null");
				flag=false;
			}
		}
	}
	
	public static void deleteNode(ListNode node) {
		if(node==null){
			return;
		}
		node.val=node.next.val;
		node.next=node.next.next;
	}
}

