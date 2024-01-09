package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     *
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     *
     *
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     */

    //思路：分成多个局部反转链表，统计总体的长度，然后进行循环处理

    public ListNode2 reverseKGroup(ListNode2 head, int k) {
        ListNode2 curr = head;
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }
        int m = len / k;
        for (int i = 0; i < m; i++){
            int left = i * k;
            int right = (i + 1) * k - 1;
            head = reverseBetween(head,left,right);
        }
        return head;
    }

    public ListNode2 reverseBetween(ListNode2 head, int left, int right) {
        int start = left;
        int end = right;
        ListNode2 curr = head;
        Map<Integer, ListNode2> map = new HashMap<>();
        Integer index = 0;
        while (curr != null){
            map.put(index++,new ListNode2(curr.val));
            curr = curr.next;
        }
        ListNode2 res = new ListNode2(-1);
        ListNode2 headRes = res;
        for (int i = 0; i < map.size(); i++){
            if(i >= left && i <= right && end >= start){
                res.next = map.get(end--);
            }else {
                res.next = map.get(i);
            }
            res = res.next;
        }
        return headRes.next;
    }
}
