package leetcode.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * @time: 4/13/21 8:27 PM
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node3;
        printNode(node1);
        Node newNode = copyRandomList(node1);
        System.out.println("**************");
        printNode(newNode);
        Node anotherNewNode = copyRandomList1(node1);
        System.out.println("**************");
        printNode(anotherNewNode);
    }

    private static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        // 将克隆节点放到原节点之后
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node curCopy = new Node(cur.val);
            cur.next = curCopy;
            curCopy.next = next;
            cur = next;
        }

        // 为克隆节点添加random指针
        cur = head;
        while (cur != null && cur.next != null) {
            Node random = cur.random;
            if (random != null) {
                cur.next.random = random.next;
                cur = cur.next.next;
            }
        }

        // 取出新的链表
        Node newHead = head.next;
        cur = newHead;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return newHead;
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node n = map.get(cur);
            if (n == null) {
                n = new Node(cur.val);
                map.put(cur, n);
            }
            Node next = map.get(cur.next);
            if (next == null && cur.next != null) {
                next = new Node(cur.next.val);
                map.put(cur.next, next);
            }
            n.next = next;
            Node random = map.get(cur.random);
            if (random == null && cur.random != null) {
                random = new Node(cur.random.val);
                map.put(cur.random, random);
            }
            n.random = random;
            cur = cur.next;
        }
        return map.get(head);
    }

    private static void printNode(Node head) {
        Node cur = head;
        while (cur != null) {
            int nextVal = 0;
            int randomVal = 0;
            if (cur.next != null) {
                nextVal = cur.next.val;
            }
            if (cur.random != null) {
                randomVal = cur.random.val;
            }
            System.out.printf("%d\t%d\t%d\n", cur.val, nextVal, randomVal);
            cur = cur.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
