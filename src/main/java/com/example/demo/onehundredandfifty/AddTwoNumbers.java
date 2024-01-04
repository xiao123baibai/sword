package com.example.demo.onehundredandfifty;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  curr =null;
        ListNode  res = null;
        int temp2 = 0;
        while (l1 != null || l2 != null){
            int temp1;
            if (l1 == null){
                temp1 = (l2.val + temp2) % 10;
                temp2 = (l2.val + temp2) / 10;
            } else if (l2 == null) {
                temp1 = (l1.val + temp2) % 10;
                temp2 = (l1.val + temp2) / 10;
            }else {
                temp1 = (l1.val + l2.val + temp2) % 10;
                temp2 = (l1.val + l2.val + temp2) / 10;
            }
            if (res == null){
                curr = res = new ListNode(temp1);
            }else {
                res.next = new ListNode(temp1);
                res = res.next;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if(temp2 > 0){
            res.next = new ListNode(temp2);
        }
        return curr;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
