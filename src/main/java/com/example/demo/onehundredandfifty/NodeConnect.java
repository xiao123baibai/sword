package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 17. 填充每个节点的下一个右侧节点指针 II
 */
public class NodeConnect {
    /**
     * 给定一个二叉树：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL 。
     * 示例 1：
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 提示：
     *
     * 树中的节点数在范围 [0, 6000] 内
     * -100 <= Node.val <= 100
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
     */
    //思路：使用广度便利，同时进行逐层处理，找到每层的个数，左右节点进栈的时候，建立节点的关联关系
    public static Node1 connect(Node1 root) {
        if(root == null){
            return new Node1();
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Node1 pre = null;
            for (int i = 0; i < n; i++){
                Node1 node = queue.poll();
                if (pre != null){
                    node.next = pre;
                }
                pre = node;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(4);
        Node1 node5 = new Node1(5);
        Node1 node6 = new Node1(7);
        node1.left = node2;
        node1.right = node3;
        node3.right = node6;
        node2.left = node4;
        node2.right = node5;
        connect(node1);
    }

}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
