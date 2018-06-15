package leetcode.linked_list;

import leetcode.util.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author mhts
 *
 */
public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(2);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(4);
		ListNode node6=new ListNode(4);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		printList(node1);
		node1=deleteDuplicates(node1);
		System.out.println();
		printList(node1);
	}

	public static ListNode deleteDuplicates(ListNode head) {
        if(head!=null){
        	ListNode node1=new ListNode(head.val);
        	ListNode node2=node1;
        	ListNode cur=head;
        	while(cur!=null){
        		if(cur.val!=node2.val){
        			node2.next=new ListNode(cur.val);
        			node2=node2.next;
        		}
        		cur=cur.next;
        	}
        	return node1;
        }
        return head;
    }
	
	private static void printList(ListNode node1) {
		System.out.print(node1.val);
		while(node1.next!=null){
			System.out.print("->"+node1.next.val);
			node1=node1.next;
		}
	}
}