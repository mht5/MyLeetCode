package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * @author mhts
 *
 */
public class SymmetricTree {
	public static void main(String[] args){
    	TreeNode root=new TreeNode(4);
    	TreeNode left1=new TreeNode(2);
    	TreeNode left2=new TreeNode(1);
    	TreeNode left3=new TreeNode(3);
    	TreeNode right1=new TreeNode(7);
    	TreeNode right2=new TreeNode(6);
    	TreeNode right3=new TreeNode(9);
    	root.left=left1;
    	left1.left=left2;
    	left1.right=left3;
    	root.right=right1;
    	right1.left=right2;
    	right1.right=right3;
    	System.out.println(isSymmetric(root));
	}
    public static boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return isSymmetric(root.left, root.right);
    }

	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if((left==null) && (right==null)){
			return true;
		}
		if((left==null) || (right==null)){
			return false;
		}
		else{
			return (left.val==right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
