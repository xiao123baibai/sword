package com.example.demo.seventyfivesword;

/**
 * 删除链表的节点
 */
public class DeleteNode {
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * @param head
     * @param val
     * @return
     */
    public static ListNode2 deleteNode(ListNode2 head, int val){
        if (head == null){
            return head;
        }
        if (head.val == val){
            return head.next;
        };
        ListNode2 res = head;
        ListNode2 curr = head.next;
        while (curr != null){
            if (curr.val == val){
                res.next = curr.next;
                break;
            }
            res = curr;
            curr = curr.next;

        }
        return head;
    }

    public ListNode2 deleteNode1(ListNode2 head, int val){
        if (head == null){
            return head;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode2 res = head;
        ListNode2 curr = head.next;
        while (curr != null){
            if (curr.val == val){
                res.next = curr.next;
                break;
            }
            res = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode2 n1 = new ListNode2(-1);
        ListNode2 n2 = new ListNode2(2);
        ListNode2 n3 = new ListNode2(-3);
        ListNode2 n4 = new ListNode2(4);
        ListNode2 n5 = new ListNode2(-5);
        ListNode2 n6 = new ListNode2(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode2 result = deleteNode(n1,6);

    }
}
