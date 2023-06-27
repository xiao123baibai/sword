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
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = (tempA == null ? headB:tempA.next);
            tempB = (tempB == null ? headA:tempB.next);
        }
        return tempB;
    }

    //遍历
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
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
