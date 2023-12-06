package com.example.demo.seventyfivesword;

/**
 * 合并两个排序的列表
 */
public class MergeTwoLists {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(5);
        ListNode m4 = new ListNode(7);
        ListNode m5 = new ListNode(9);
        ListNode m6 = new ListNode(10);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;
        ListNode resNode = mergeTwoLists2(n1,m1);
    }

    //迭代
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode res = null;
        //确定首节点
        if (l1.val >= l2.val){
            res = l2;
            l2 = l2.next;
        }else {
            res = l1;
            l1 = l1.next;
        }
        //循环两个链表都不为空时的节点
        ListNode cur = res;
        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }else {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
        }
        //尾节点处理
        if (l1 == null){
            res.next = l2;
        }
        if (l2 == null){
            res.next = l1;
        }
        return cur;
    }
    //遍历
    public ListNode mergeTwoList4(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode res = null;
        if (l1.val <= l2.val){
            res = l1;
            l1 = l1.next;
        }else {
            res = l2;
            l2 = l2.next;
        }
        ListNode cur = res;
        while (l1 != null || l2 != null){
            if (l1.val >= l2.val){
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }else {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
        }
        //尾节点
        if (l1 == null){
            res.next = l2;
        }
        if (l2 == null){
            res.next = l1;
        }
        return cur;
    }
    //递归

    /**
     * 特判：如果有一个链表为空，返回另一个链表
     * 如果l1节点值比l2小，下一个节点应该是l1，应该return l1，在return之前，指定l1的下一个节点应该是l1.next和l2俩链表的合并后的头结点
     * 如果l1节点值比l2大，下一个节点应该是l2，应该return l2，在return之前，指定l2的下一个节点应该是l1和l2.next俩链表的合并后的头结点
     *
     * otherwise
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    //递归
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val == l2.val) {
            l1.next = mergeTwoLists3(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2.next);
            return l2;
        }
    }

}
