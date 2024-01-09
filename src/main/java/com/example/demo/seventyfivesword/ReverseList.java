package com.example.demo.seventyfivesword;


/**
 * 反转链表
 */
public class ReverseList {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     *
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */

    //迭代

    /**
     * 假设链表为 1→2→3→∅1 \rightarrow 2 \rightarrow 3 \rightarrow \varnothing1→2→3→∅，
     * 我们想要把它改成 ∅←1←2←3\varnothing \leftarrow 1 \leftarrow 2 \leftarrow 3∅←1←2←3。
     *
     * 在遍历链表时，将当前节点的 next\textit{next}next 指针改为指向前一个节点。由于节点没有引用其前一个节点，
     * 因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     *
     * @param head
     * @return
     */
    public ListNode2 reverseList1(ListNode2 head){
        ListNode2 pre = null;
        ListNode2 curr = head;
        while (curr != null){
            ListNode2 next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //递归

    /**
     * 递归版本稍微复杂一些，其关键在于反向工作。假设链表的其余部分已经被反转，现在应该如何反转它前面的部分？
     *
     * 假设链表为：
     *
     * n1→…→nk−1→nk→nk+1→…→nm→∅n_1\rightarrow \ldots \rightarrow n_{k-1} \rightarrow n_k \rightarrow n_{k+1} \rightarrow \ldots \rightarrow n_m \rightarrow \varnothing
     * n
     * 1
     *  →…→n
     * k−1
     *  →n
     * k
     *  →n
     * k+1
     *  →…→n
     * m
     *  →∅
     * 若从节点 nk+1n_{k+1}n
     * k+1
     *   到 nmn_mn
     * m
     *   已经被反转，而我们正处于 nkn_kn
     * k
     *  。
     *
     * n1→…→nk−1→nk→nk+1←…←nmn_1\rightarrow \ldots \rightarrow n_{k-1} \rightarrow n_k \rightarrow n_{k+1} \leftarrow \ldots \leftarrow n_m
     * n
     * 1
     *  →…→n
     * k−1
     *  →n
     * k
     *  →n
     * k+1
     *  ←…←n
     * m
     *
     * 我们希望 nk+1n_{k+1}n
     * k+1
     *   的下一个节点指向 nkn_kn
     * k
     *  。
     *
     * 所以，nk.next.next=nkn_k.\textit{next}.\textit{next} = n_kn
     * k.next.next=nk
     *  。
     *
     * 需要注意的是 n1n_1n
     * 1
     *   的下一个节点必须指向 ∅\varnothing∅。如果忽略了这一点，链表中可能会产生环。
     *
     * @param head
     * @return
     */
    public static ListNode2 reverseList2(ListNode2 head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode2 newhead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return  newhead;
    }

    public static void main(String[] args) {
        ListNode2 n1 = new ListNode2(1);
        ListNode2 n2 = new ListNode2(2);
        ListNode2 n3 = new ListNode2(3);
        ListNode2 n4 = new ListNode2(4);
        ListNode2 n5 = new ListNode2(5);
        ListNode2 n6 = new ListNode2(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        reverseList2(n1);

    }


}

