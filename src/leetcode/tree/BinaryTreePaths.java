package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * https://leetcode.com/problems/binary-tree-paths/description/
 * @author mhts
 *
 */
public class BinaryTreePaths {
	private static List<String> pathList=new ArrayList<String>();
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
    	System.out.println(binaryTreePaths(root));
    }

	private static List<String> binaryTreePaths(TreeNode root) {
        if(root!=null){
            StringBuffer sb=new StringBuffer();
            sb.append(root.val);
            getPath(root, sb);
        }
        return pathList;
    }

    private static void getPath(TreeNode root, StringBuffer sb) {
        if((root.left==null) && (root.right==null)){
            pathList.add(sb.toString());
        }
        if(root.left!=null){
        	StringBuffer sb1=new StringBuffer(sb);
            getPath(root.left, sb1.append("->"+root.left.val));
        }
        if(root.right!=null){
        	StringBuffer sb2=new StringBuffer(sb);
            getPath(root.right, sb2.append("->"+root.right.val));
        }
	}
}
