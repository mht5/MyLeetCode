package leetcode.linked_list;

import leetcode.util.ListNode;

public class MergeTwoSortedLists {
	public static  void main(String[] args){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next=node3;
		node3.next=node5;
		node2.next=node4;
		node4.next=node6;
		ListNode node=mergeTwoLists(node1, node2);
		printList(node);
	}
	
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
    	ListNode head=new ListNode(0);
    	ListNode node=head;
    	while(node1!=null && node2!=null){
    		if(node1.val<node2.val){
    			node.next=node1;
    			node1=node1.next;
    		}
    		else{
    			node.next=node2;
    			node2=node2.next;
    		}
    		node=node.next;
    	}
    	if(node1!=null){
    		node.next=node1;
    	}
    	if(node2!=null){
    		node.next=node2;
    	}
    	return head.next;
    }

	private static void printList(ListNode node1) {
		System.out.print(node1.val);
		while(node1.next!=null){
			System.out.print("->"+node1.next.val);
			node1=node1.next;
		}
	}
}
