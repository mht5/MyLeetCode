package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * BST is a sorted tree!!!
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * @author mhts
 *
 */
public class LowestCommonAncestor {
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
    	System.out.println(lowestCommonAncestor(root, left1, left3).val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root==null) || (p==null) || (q==null)){
            return null;
        }
		if(getMax(p.val, q.val)<root.val){
			return lowestCommonAncestor(root.left, p, q);
		}
		if(getMin(p.val, q.val)>root.val){
			return lowestCommonAncestor(root.right, p, q);
		}
		else{
			return root;
		}
    }
    
    public static int getMax(int p, int q){
        return p>q ? p : q;
    }
    
    public static int getMin(int p, int q){
        return p<q ? p : q;
    }
}
