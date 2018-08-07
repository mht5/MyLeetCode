package leetcode.binary_search_tree;

import leetcode.util.TreeNode;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 * @author mhts
 * @date 2018年8月6日
 */
public class MinimumAbsoluteDifferenceInBST {

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
		System.out.println(getMinimumDifference(root));
	}
	
	static Integer result = Integer.MAX_VALUE;
	static Integer prev = null;
	
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        getMinimumDifference(root.left);
        if (prev != null) {
        	result = Math.min(result, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        
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
