package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * @author mhts
 *
 */
public class MinDepthOfBinaryTree {
    public static void main(String[] args){
    	TreeNode root=new TreeNode(1);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(4);
    	TreeNode node4=new TreeNode(5);
    	TreeNode node5=new TreeNode(6);
    	root.left=node1;
    	root.right=node2;
    	node1.left=node3;
    	node1.right=null;
    	node2.left=node4;
    	node2.right=node5;
    	System.out.println(minDepth(root));
    }
    
    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if((root.left==null) && (root.right==null)){
        	return 1;
        }
        int left=root.left!=null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right=root.right!=null ? minDepth(root.right) : Integer.MAX_VALUE;
        return left<right ? left+1 : right+1;
    }
}

