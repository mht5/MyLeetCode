package leetcode.tree;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * @time: 4/17/21 7:58 PM
 */
public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        node2.right = node4;
        node4.left = node10;
        node4.right = node8;
        node8.left = node42;
        System.out.println(goodNodes(node2));
    }

    public static int goodNodes(TreeNode root) {
        int count = 1;
        count += goodSubNodes(root, root.val);
        return count;
    }

    private static int goodSubNodes(TreeNode node, int val) {
        int count = 0;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null) {
            int leftVal = val;
            if (left.val >= leftVal) {
                count++;
                leftVal = left.val;
            }
            count += goodSubNodes(left, leftVal);
        }
        if (right != null) {
            int rightVal = val;
            if (right.val >= rightVal) {
                count++;
                rightVal = right.val;
            }
            count += goodSubNodes(right, rightVal);
        }
        return count;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
