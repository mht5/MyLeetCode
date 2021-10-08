package leetcode.linked_list;


import leetcode.util.ListNode;

/**
 * Reverse a singly linked list.
 * https://leetcode.com/problems/reverse-linked-list/description/
 * @author mhts
 * 
 */
public class ReverseLinkedList_01 {
	public static void main(String[] args){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
//		ListNode node6=new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
//		node5.next=node6;
		printList(node1);
		node1=reverseList(node1);
		System.out.println();
		printList(node1);
	}

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
        	return head;
        }
        ListNode node1=head.next;
        head.next=null;
        ListNode node=reverseList(node1);
        System.out.print("\n#");
        printList(node);
        node1.next=head;
        System.out.println();
        printList(node1);
        System.out.print("\n*");
        printList(node);
        return node;
	}

	private static void printList(ListNode node1) {
		System.out.print(node1.val);
		while(node1.next!=null){
			System.out.print("->"+node1.next.val);
			node1=node1.next;
		}
	}
}
