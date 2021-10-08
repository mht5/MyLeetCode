package leetcode.tree;

import leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 * @time: 4/20/21 3:52 PM
 */
public class DeleteLeavesWithGivenValue {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node21;
        node21.left = node22;
        node1.right = node3;
        node3.left = node23;
        node3.right = node4;
        print(node1);
        int target = 2;
        System.out.println();
        print(removeLeafNodes(node1, target));
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.left = removeLeafNodes(left, target);
        }
        if (right != null) {
            root.right = removeLeafNodes(right, target);
        }
        if (root.left == null && root.right == null && root.val == target) {
            root = null;
        }
        return root;
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+", ");
        print(root.left);
//		System.out.print(root.val+", ");
        print(root.right);
//		System.out.print(root.val+", ");
    }
}
