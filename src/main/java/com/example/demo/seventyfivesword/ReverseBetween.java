package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 92. 反转链表 II
 */
public class ReverseBetween {
    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     *
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     *
     *
     * 提示：
     *
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     */
    //使用栈存储需要反转的位置，，新建一个链表，存储初始化的位置，然后使用一个数组存储后面的位置
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int start = left;
        int end = right;
        ListNode curr = head;
        Map<Integer,ListNode> map = new HashMap<>();
        Integer index = 1;
        while (curr != null){
            map.put(index++,new ListNode(curr.val));
            curr = curr.next;
        }
        ListNode res = new ListNode(-1);
        ListNode headRes = res;
        for (int i = 1; i <= map.size(); i++){
            if(i >= left && i <= right && end >= start){
                res.next = map.get(end--);
            }else {
                res.next = map.get(i);
            }
            res = res.next;
        }
        return headRes.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseBetween(node1,2,4);
    }

    class ListNode1 {
        int val;
        ListNode1 next;
        ListNode1() {}
        ListNode1(int val) { this.val = val; }
        ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
    }
}

