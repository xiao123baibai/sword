package com.example.demo.onehundredandfifty;

/**
 * 86. 分隔链表
 */
public class Partition {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 示例 2：
     *
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * 提示：
     * 链表中节点的数目在范围 [0, 200] 内
     * -100 <= Node.val <= 100
     * -200 <= x <= 200
     */
    //先获取x节点的值，然后维护两个临时链表，，最后拼接两个临时链表
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        int xValue = -101;
        while (x > 0 && temp != null){
            temp = temp.next;
            x--;
            if (x == 0){
                xValue = temp.val;
            }
        }
        ListNode res1 = new ListNode(-101,head);
        ListNode res2 = new ListNode(-101);
        ListNode dummy1 = res1;
        ListNode dummy2 = res2;
        temp = head;
        while (temp != null){
            if (temp.val < xValue){
                dummy1.next = temp;
                dummy1 = dummy1.next;
            }else {
                dummy2.next = temp;
                dummy2 = dummy2.next;
            }
            temp = temp.next;
        }
        dummy1.next = res2.next;
        return res1.next;
    }
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}

