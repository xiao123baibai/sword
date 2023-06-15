package com.example.demo.swordforward;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthFromEnd {

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
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

      public ListNode getKthFromEnd(ListNode head, int k){
          //使用stack存储，倒叙取出到list中，然后循环组装链表
          Stack<ListNode> nodeStack = new Stack<>();
          ListNode pre = head;
          while (pre != null){
              nodeStack.push(pre);
              pre = pre.next;
          }
          ListNode res = null;
          for (int i = 1; i <= k; i++){
              res = nodeStack.pop();
          }
          return res;
      }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++){
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
