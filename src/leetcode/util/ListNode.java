package leetcode.util;

public class ListNode {
	
	 public int val;
	 public ListNode next;
	 
	 public ListNode(int x) { 
		 this.val = x; 
	 }
	 
	 public void print() {
		 System.out.print(this.val + ", ");
		 if (this.next != null) {
			 this.next.print();
		 }
	 }
	 
}
