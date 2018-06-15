package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * ֻ�跭ת��һ�ⷵ�ص�List����
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
        
//     ֻҪ���в�Ϊ�վ�һֱѭ��
        while(!q.isEmpty()){
//        	ȡ�������е�һ��Ԫ��
            TreeNode currentNode=q.peek();
            List<Integer> thisLevelList=new ArrayList<Integer>();
            nextLevelStart=null;
            
//         ���q.peek()==nextLevelStart��˵�������Ѿ��������ˣ��������List�ŵ�orderList��ͬʱ��ʼ������һ��
            while((q.peek()!=nextLevelStart) && (q.isEmpty()==false)){
                currentNode=q.remove();
//             ��nextLevelStart==nullʱ���ҵ���һ��Ŀ�ʼ�ڵ�   
                if(nextLevelStart==null){
                    if(currentNode.left!=null){
                        nextLevelStart=currentNode.left;
                    }
                    else if(currentNode.right!=null){
                        nextLevelStart=currentNode.right;
                    }
                }
//             �����α����ڵ��ֵ�ŵ�List��   
                thisLevelList.add(currentNode.val);
//             �����α����ڵ�ķǿ��ӽڵ�������   
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
//         ����һ������󣬽��ò�List����orderList   
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