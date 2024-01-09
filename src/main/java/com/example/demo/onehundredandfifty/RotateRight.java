package com.example.demo.onehundredandfifty;

import java.util.Stack;

/**
 * 61. 旋转链表
 */
public class RotateRight {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 示例 2：
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 500] 内
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     */
    //思路：获取整个链表的长度，然后将取模，获取到剩余的长度，使用栈将其中的数据存储起来
    public static ListNode2 rotateRight(ListNode2 head, int k) {
        Stack<ListNode2> stack = new Stack<>();
        ListNode2 curr = head;
        int len = 0;
        while (curr != null){
            len++;
            stack.push(curr);
            curr = curr.next;
        }
         int m = k % len;
        ListNode2 ans = new ListNode2(-101,head);
        ListNode2 temp = ans;
        while (m > 0){
            ListNode2 node = stack.pop();
            node.next = temp.next;
            temp.next = node;
            m--;
        }
        stack.pop().next = null;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        rotateRight(node1,2);
    }
}
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}