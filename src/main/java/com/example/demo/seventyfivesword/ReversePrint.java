package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从尾到头打印链表
 */
public class ReversePrint {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    //辅助栈法
    public int[] reversePrint1(ListNode head){
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null){
            linkedList.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[linkedList.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = linkedList.removeLast();
        }
        return res;
    }
    //递归法
    List<Integer> temp = new ArrayList<>();
    public int[] reversePrint2(ListNode head){
        recur(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        return res;
    }
    void recur(ListNode head){
        if (head == null){return;}
        recur(head.next);
        temp.add(head.val);
    }
}

 //Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }

