package leetcode.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int x){
        this.val=x;
    }
    
    public void print() {
//		先序遍历
		System.out.print(this.val + ", ");
		if (this.left != null) {
			this.left.print();
		} else {
			System.out.print("null, ");
		}
//		中序遍历
//		System.out.print(this.val + ", ");
		if (this.right != null) {
			this.right.print();
		} else {
			System.out.print("null, ");
		}
//		后序遍历
//		System.out.print(this.val + ", ");
    }
    
}
