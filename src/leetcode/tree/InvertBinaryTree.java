package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Invert a binary tree.
 * @author mhts
 *
 */
public class InvertBinaryTree {
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
    	print(root);
    	root=invert(root);
    	System.out.println();
    	print(root);
	}

	public static TreeNode invert(TreeNode root){
		if(root==null){
			return root;
		}
		TreeNode node=root.left;
		root.left=root.right;
		root.right=node;
		invert(root.left);
		invert(root.right);
		return root;
	}
	
	private static void print(TreeNode root) {
		if(root==null){
			return;
		}
//		先序遍历
		System.out.print(root.val+", ");
		print(root.left);
//		中序遍历
//		System.out.print(root.val+", ");
		print(root.right);
//		后序遍历
//		System.out.print(root.val+", ");
	}
}
