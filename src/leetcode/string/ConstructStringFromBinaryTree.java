package leetcode.string;

import leetcode.util.TreeNode;

public class ConstructStringFromBinaryTree {

	public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
    	TreeNode left1=new TreeNode(2);
    	TreeNode left2=new TreeNode(4);
    	TreeNode left3=new TreeNode(4);
    	TreeNode right1=new TreeNode(3);
    	TreeNode right2=new TreeNode(6);
    	TreeNode right3=new TreeNode(9);
    	root.left=left1;
    	left1.left=left2;
    	left1.right=left3;
    	root.right=right1;
    	right1.left=right2;
    	right1.right=right3;
    	
    	System.out.println(tree2str(root));
    	System.out.println(tree2str1(root));
    	long time1 = System.currentTimeMillis();
    	for (int i = 0; i < 100000; i++) {
    		tree2str(root);
    	}
    	long time2 = System.currentTimeMillis();
    	for (int i = 0; i < 100000; i++) {
    		tree2str1(root);
    	}
    	long time3 = System.currentTimeMillis();
    	System.out.println(time2 - time1);
    	System.out.println(time3 - time2);
	}

	public static String tree2str1(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		translate(t, sb);
		return sb.toString();
    }

	private static void translate(TreeNode t, StringBuilder sb) {
		if (t == null) {
			return;
		} else {
			sb.append(t.val);
        	if (t.left != null || t.right != null) {
        		sb.append("(" + tree2str(t.left) + ")");
        	}
        	if (t.right != null) {
        		sb.append("(" + tree2str(t.right) + ")");
        	}
		}
	}

	public static String tree2str(TreeNode t) {
        if (t == null) {
        	return "";
        } else {
    		String str = t.val + "";
        	if (t.left != null || t.right != null) {
        		str += ("(" + tree2str(t.left) + ")");
        	}
        	if (t.right != null) {
        		str += ("(" + tree2str(t.right) + ")");
        	}
            return str;
        }
    }
	
}
