package leetcode.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int x){
        this.val=x;
    }
    
    public void print() {
//		�������
		System.out.print(this.val + ", ");
		if (this.left != null) {
			this.left.print();
		} else {
			System.out.print("null, ");
		}
//		�������
//		System.out.print(this.val + ", ");
		if (this.right != null) {
			this.right.print();
		} else {
			System.out.print("null, ");
		}
//		�������
//		System.out.print(this.val + ", ");
    }
    
}
