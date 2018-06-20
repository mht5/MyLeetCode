package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * https://leetcode.com/problems/same-tree/description/
 * @author mhts
 *
 */
public class SameTree {
	public static void main(String[] args){
    	TreeNode root1=new TreeNode(4);
    	TreeNode root2=new TreeNode(4);
    	TreeNode left1=new TreeNode(2);
    	TreeNode left2=new TreeNode(1);
    	TreeNode left3=new TreeNode(3);
    	TreeNode right1=new TreeNode(7);
    	TreeNode right2=new TreeNode(6);
    	TreeNode right3=new TreeNode(9);
    	root1.left=left1;
    	left1.left=left2;
    	left1.right=left3;
    	root1.right=right1;
    	right1.left=right2;
    	right1.right=right3;
    	root2.left=left1;
    	root2.right=new TreeNode(13);
    	System.out.println(isSameTree(root1, root2));
	}

	private static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if((root1==null) && (root2==null)){
			return true;
		}
		if((root1==null) || (root2==null)){
			return false;
		}
		return (root1.val==root2.val) && (isSameTree(root1.left, root2.left)) && (isSameTree(root1.right, root2.right));
	}
}
