package com.example.demo.seventyfivesword;

import java.util.LinkedList;

/**
 * 获取链表的倒数第k节点--删除倒数第k节点
 */
public class GetKthFromEnd {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     *
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     */
    //辅助栈法
    private ListNode2 getKthFromEnd1(ListNode2 head, int k){
        //使用stack存储，倒叙取出到list中，然后循环组装链表
        //   Stack<ListNode> nodeStack = new Stack<>();
        //   ListNode pre = head;
        //   while (pre != null){
        //       nodeStack.push(pre);
        //       pre = pre.next;
        //   }
        //   ListNode res = null;
        //   for (int i = 1; i <= k; i++){
        //       res = nodeStack.pop();
        //   }
        //   return res;
        ListNode2 result = null;
        if (head == null){
            return null;
        }
        LinkedList<ListNode2> stack = new LinkedList<>();
        while (head != null){
            stack.add(head);
            head = head.next;
        }
        if (stack.size()>=k){
            result = stack.get(stack.size() - k);
        }else {
            return null;
        }
        return result;
    }
    //遍历法
    private ListNode2 getKthFromEnd2(ListNode2 head, int k){
        ListNode2 result = null;
        int n = 0;
        ListNode2 cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        if (n > k){
            for (int i = 0; i < n - k;i++){
                result = head;
                head = head.next;
            }
        }
        return result;
    }
    //双指针法
    private ListNode2 getKthFromEnd3(ListNode2 head, int k){
        ListNode2 firstNode = head;
        ListNode2 secondNode = head;
        while (k > 0){
            k--;
            firstNode = firstNode.next;
        }
        while (firstNode != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }

    //辅助栈法
    private ListNode2 getKthFromEnd11(ListNode2 head, int k){
        LinkedList<ListNode2> stack = new LinkedList<>();
        ListNode2 curr = head;
        while (curr != null){
            stack.add(curr);
            curr = curr.next;
        }
        if (stack.size() > k){
            return stack.get(stack.size() - k);
        }else {
            return null;
        }
    }
    //遍历
    private ListNode2 getKthFromEnd22(ListNode2 head, int k){
        ListNode2 res = null;
        ListNode2 curr = head;
        int n = 0;
        while (curr != null){
            n++;
            curr = curr.next;
        }
        if (n > k){
            for (int i = 0; i < n - k; i++){
                res = head;
                head = head.next;
            }
        }
        return res;
    }
    //双指针法
    private ListNode2 getKthFromEnd33(ListNode2 head, int k){
        ListNode2 first = head;
        ListNode2 second = head;
        while (k > 0){
            k--;
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
