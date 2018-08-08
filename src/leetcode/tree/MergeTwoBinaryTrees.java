package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 * @author mhts
 * @date 2018Äê8ÔÂ8ÈÕ
 */
public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		
    	TreeNode root1 = new TreeNode(1);
    	TreeNode root2 = new TreeNode(2);
    	
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node5 = new TreeNode(5);
    	root1.left=node3;
    	root1.right = node2;
    	node3.left=node5;
    	root1.print();

    	node3 = new TreeNode(3);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node7 = new TreeNode(7);
    	root2.left = node1;
    	node1.left = null;
    	node1.right = node4;
    	node4.left = null;
    	node4.right = null;
    	root2.right = node3;
    	node3.left = null;
    	node3.right = node7;
    	System.out.println();
    	root2.print();
    	System.out.println();
    	root1 = mergeTrees(root1, root2);
    	root1.print();
	}
	
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if (t1 == null && t2 == null) {
    		return null;
    	} else if (t1 == null) {
    		return t2;
    	} else if (t2 == null) {
    		return t1;
    	} else {
    		TreeNode node = new TreeNode(t1.val + t2.val);
    		TreeNode left = mergeTrees(t1.left, t2.left);
    		TreeNode right = mergeTrees(t1.right, t2.right);
    		node.left = left;
    		node.right = right;
            return node;
    	}
    }

}
