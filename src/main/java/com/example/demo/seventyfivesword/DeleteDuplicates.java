package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates {
    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * 提示：
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序 排列
     */

    //思路：使用map表进行个数记录，然后，在循环一遍
    public ListNode2 deleteDuplicates(ListNode2 head) {
        if (head == null) {
            return head;
        }
        Map<Integer,Integer> map = new HashMap<>();
        ListNode2 curr = head;
        while (curr != null){
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }
        ListNode2 temp = new ListNode2(-101, head);
        curr = temp;
        while (curr.next != null){
            if (map.get(curr.next.val) > 1){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return temp.next;
    }
    //使用局部小循环，可以节省循环空间
    public ListNode2 deleteDuplicates1(ListNode2 head){
        if (head == null) {
            return head;
        }
        ListNode2 temp = new ListNode2(-101, head);
        ListNode2 curr = temp;
        while (curr.next != null && curr.next.next != null){
            if (curr.next.val == curr.next.next.val){
                int x = curr.next.val;
                while (curr.next != null && x == curr.next.val ){
                    curr.next = curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }
        return temp.next;
    }
}
