package com.example.demo.seventyfivesword;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    // 使用栈的时间和空间的复杂度都是O(n),使用长度计算和双指针的时间复杂度是O(n),空间复杂度是O(1)
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode temp = new ListNode(0, head);
        ListNode first = head;
        ListNode second = temp;
        while (n > 0){
            n--;
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


