package leetcode.binary_search_tree;

import leetcode.util.TreeNode;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 * @author mhts
 * @date 2018年8月5日
 */
public class MinimumDistanceBetweenBSTNodes {

	static Integer result = Integer.MAX_VALUE;
	static Integer prev = null;

	public static void main(String[] args) {
    	TreeNode root=new TreeNode(90);
    	TreeNode left1=new TreeNode(69);
    	TreeNode left2=new TreeNode(49);
    	TreeNode left3=new TreeNode(89);
    	TreeNode left4=new TreeNode(52);
//    	TreeNode right1=new TreeNode(6);
//    	TreeNode right2=new TreeNode(29);
//    	TreeNode right3=new TreeNode(9);
    	root.left=left1;
    	left1.left=left2;
    	left1.right=left3;
    	left2.right = left4;
//    	root.right=right1;
//    	right1.left=right2;
//    	right1.right=right3;
		print(root);
		System.out.println();
		System.out.println(minDiffInBST(root));
	}
        
    public static int minDiffInBST(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	minDiffInBST(root.left);
    	if (prev != null) {
    		result = Math.min(result, root.val - prev);
    	}
    	prev = root.val;
    	minDiffInBST(root.right);
    	return result;
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
