package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class CopyRandomList {
    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
     * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     *
     *
     *
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     *
     *
     *
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     *
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     */

    /**
     *解法分析有感，不能为了完全的解题而解题，还是要学习其中的乐趣
     */

    public static Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        //curr复制head
        Node curr = head;
        Map<Node,Node> map = new HashMap<>();
        while (curr != null){
            map.put(curr,new Node(curr.val));
            //不适用head.next,使用curr.next因为这里curr一直在改变
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
    // Definition for a Node.
    public Node copyRandomList1(Node head){
        if (head == null){
            return head;
        }
        Node curr = head;
        Map<Node,Node> map = new HashMap<>();
        while (curr != null){
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n1.random= n1;
        n2.next = n3;
        n2.random = n6;
        n3.next = n4;
        n3.random = null;
        n4.next = n5;
        n4.random = n1;
        n5.next = n6;
        n5.random = n6;
        n6.random = n4;
        Node res = copyRandomList(n1);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
