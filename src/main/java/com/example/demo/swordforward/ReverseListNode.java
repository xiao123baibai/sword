package com.example.demo.swordforward;

import java.util.Stack;

public class ReverseListNode {

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     *
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseList(listNode1);
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        Stack<ListNode> stack = new Stack<>();
        while (pre != null){
            stack.push(pre);
            pre = pre.next;
        }
        ListNode res = stack.pop();
        ListNode res1 = res;
        while (!stack.isEmpty()){
            ListNode item = stack.pop();
            res1.next = item;
            res1 = item;
        }
        res1.next = null;
        return res;
    }
    //递归
    public static ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseList1(head);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }
}
