package com.example.demo.seventyfivesword;

import java.util.*;

/**
 * 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * 为了让您更好地理解问题，以下面的二叉搜索树为例：
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     *
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     *
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针
     */
    //使用优先队列，循环二叉树将节点存储，取出后构建循环链表并存储第一根节点和最后一个节点
    public static NodeNew treeToDoublyList1(NodeNew root) {
        while (root == null){
            return null;
        }
        //循环二叉树存入优先队列
        Queue<Integer> priorityQueueAsc = new PriorityQueue<>();
        Queue<NodeNew> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            NodeNew temp = queue.poll();
            priorityQueueAsc.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        NodeNew head = new NodeNew();
        int h = priorityQueueAsc.poll();
        NodeNew headNode = new NodeNew(h);
        head.left = headNode;
        NodeNew first = headNode;
        Iterator<Integer> iterator = priorityQueueAsc.iterator();
        while (iterator.hasNext()){
            int val = priorityQueueAsc.poll();
            NodeNew temp = new NodeNew(val);
            first.left = temp;
            temp.right = first;
            first = temp;
            if (priorityQueueAsc.size() == 1){
                int t = priorityQueueAsc.poll();
                NodeNew tailNode = new NodeNew(t);
                first .left = tailNode;
                tailNode.right = first;
                headNode.left = tailNode;
                tailNode.right = headNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        NodeNew nodeNew1 = new NodeNew(4);
        NodeNew nodeNew2 = new NodeNew(2);
        NodeNew nodeNew3 = new NodeNew(5);
        NodeNew nodeNew4 = new NodeNew(1);
        NodeNew nodeNew5 = new NodeNew(3);
        nodeNew1.left = nodeNew2;
        nodeNew1.right = nodeNew3;
        nodeNew2.left = nodeNew4;
        nodeNew2.right = nodeNew5;
        treeToDoublyList(nodeNew1);
    }

    static NodeNew pre;
    static NodeNew head;
    public static NodeNew treeToDoublyList(NodeNew root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
     static void dfs(NodeNew cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
class NodeNew {
    public int val;
    public NodeNew left;
    public NodeNew right;

    public NodeNew() {}

    public NodeNew(int _val) {
        val = _val;
    }

    public NodeNew(int _val,NodeNew _left,NodeNew _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}