package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 只需翻转上一题返回的List即可
 * @author mhts
 *
 */
public class BinaryTreeLevelOrderTraversal_02 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left1 = new TreeNode(2);
		TreeNode left2 = new TreeNode(1);
		TreeNode left3 = new TreeNode(3);
		TreeNode right1 = new TreeNode(7);
		TreeNode right2 = new TreeNode(6);
		TreeNode right3 = new TreeNode(9);
		root.left = left1;
		left1.left = left2;
		left1.right = left3;
		root.right = right1;
		right1.left = right2;
		right1.right = right3;
		System.out.println(levelOrder(root));
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orderList=new ArrayList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        TreeNode nextLevelStart;
        q.add(root);
        
        if(root==null){
            return orderList;
        }
        else{
            if(root.left!=null){
                nextLevelStart=root.left;
            }
            else if(root.right!=null){
                nextLevelStart=root.right;
            }
            else{
                List<Integer> t=new ArrayList<Integer>();
                t.add(root.val);
                orderList.add(t);
                return orderList;
            }
        }
        
//     只要队列不为空就一直循环
        while(!q.isEmpty()){
//        	取出队列中第一个元素
            TreeNode currentNode=q.peek();
            List<Integer> thisLevelList=new ArrayList<Integer>();
            nextLevelStart=null;
            
//         如果q.peek()==nextLevelStart，说明本层已经遍历完了，将本层的List放到orderList，同时开始遍历下一层
            while((q.peek()!=nextLevelStart) && (q.isEmpty()==false)){
                currentNode=q.remove();
//             当nextLevelStart==null时，找到下一层的开始节点   
                if(nextLevelStart==null){
                    if(currentNode.left!=null){
                        nextLevelStart=currentNode.left;
                    }
                    else if(currentNode.right!=null){
                        nextLevelStart=currentNode.right;
                    }
                }
//             将本次遍历节点的值放到List中   
                thisLevelList.add(currentNode.val);
//             将本次遍历节点的非空子节点放入队列   
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
//         结束一层遍历后，将该层List放入orderList   
            orderList.add(thisLevelList);
        }
        return reverse(orderList);
    }

	private static List<List<Integer>> reverse(List<List<Integer>> orderList) {
		int size=orderList.size()-1;
		for(int i=0; i<=size/2; i++){
			List<Integer> t=orderList.get(i);
			orderList.set(i, orderList.get(size-i));
			orderList.set(size-i, t);
		}
		return orderList;
	}
}