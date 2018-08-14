package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 * @author mhts
 * @date 2018Äê8ÔÂ14ÈÕ
 */
public class LeafSimilarTrees {

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

    	System.out.println(leafSimilar(root1, root2));
    	System.out.println(leafSimilar1(root1, root2));

    	long time1 = System.currentTimeMillis();
    	for (int i = 0; i < 1000000; i++) {
        	leafSimilar(root1, root2);
    	}
    	long time2 = System.currentTimeMillis();
    	for (int i = 0; i < 1000000; i++) {
        	leafSimilar1(root1, root2);
    	}
    	long time3 = System.currentTimeMillis();
    	System.out.println(time2 - time1);
    	System.out.println(time3 - time2);
	}
	
    public static boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs1(root1, sb1);
        dfs1(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }
	
    private static void dfs1(TreeNode root, StringBuilder sb) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
			sb.append(root.val);
		}
    	if (root.left != null) {
			dfs1(root.left, sb);
		}
    	if (root.right != null) {
			dfs1(root.right, sb);
		}
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
    	return leaves1.equals(leaves2);
    }

	private static void dfs(TreeNode root, List<Integer> leaves) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				leaves.add(root.val);
			}
			dfs(root.left, leaves);
			dfs(root.right, leaves);
		}
	}

}
