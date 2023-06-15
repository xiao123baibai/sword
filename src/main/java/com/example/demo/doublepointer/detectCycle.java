package com.example.demo.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/9/26
 */
public class detectCycle {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode detectCycle(ListNode head){
        ListNode pos = head;
        Set<ListNode> nodes = new HashSet<>();
        while (pos != null){
            if (nodes.contains(pos)){
                return pos;
            }else {
                nodes.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
