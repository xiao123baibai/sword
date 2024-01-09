package com.example.demo.seventyfivesword;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 */
public class GetIntersectionNode {
    /**
     * 输入两个链表，找出它们的第一个公共节点
     *
     * 理解一下什么是公共节点
     */

    //思路：双指针法
    ListNode2 getIntersectionNode1(ListNode2 headA, ListNode2 headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode2 tempA = headA;
        ListNode2 tempB = headB;
        while (tempA != tempB){
            tempA = (tempA == null ? headB:tempA.next);
            tempB = (tempB == null ? headA:tempB.next);
        }
        return tempB;
    }

    ListNode2 getIntersectionNode11(ListNode2 headA, ListNode2 headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode2 tempA = headA;
        ListNode2 tempB = headB;
        while (tempA != tempB){
            tempA = (tempA == null ? headB:tempA.next);
            tempB = (tempB == null ? headA:tempB.next);
        }
        return tempB;
    }

    //遍历
    ListNode2 getIntersectionNode2(ListNode2 headA, ListNode2 headB) {
        Set<ListNode2> nodeSet = new HashSet<>();
        while (headA != null){
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (nodeSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    ListNode2 getIntersectionNode22(ListNode2 headA, ListNode2 headB){
        Set<ListNode2> nodeSet = new HashSet<>();
        while (headA != null){
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (nodeSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
