package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * @author mhts
 *
 */
public class BalancedBinaryTree {
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
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return isTreeBalanced(root)>=0;
    }
    
    public static int isTreeBalanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=isTreeBalanced(root.left);
        int right=isTreeBalanced(root.right);
        if((left>=0) && (right>=0)){
            if((left-right<=1) && (left-right>=-1)){
                return left>right ? left+1 : right+1;
            }
        }
        return -1;
    }
}
