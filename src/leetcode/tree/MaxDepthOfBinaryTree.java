package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * @author mhts
 *
 */
public class MaxDepthOfBinaryTree{
    public static void main(String[] args){
    	TreeNode root=new TreeNode(1);
    	TreeNode left1=new TreeNode(2);
    	TreeNode left2=new TreeNode(3);
    	TreeNode right1=new TreeNode(4);
    	root.left=left1;
    	left1.right=left2;
    	root.right=right1;
    	System.out.println(maxDepth(root));
    }
    
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right ? left+1 : right+1;
    }
}
