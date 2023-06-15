package com.example.demo.swordforward;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        ListNode mergeNode = null;
        if (listNode1.val >= listNode2.val){
            mergeNode = listNode2;
            listNode2 = listNode2.next;
        }else {
            mergeNode = listNode1;
            listNode1 = listNode1.next;
        }
        while (listNode1 != null || listNode2 != null){
            if (listNode1 == null && listNode2 != null){
                mergeNode.next = listNode2;
                mergeNode = mergeNode.next;
                listNode2 = listNode2.next;
                continue;
            }
            if (listNode2 == null && listNode1 != null){
                mergeNode.next = listNode1;
                mergeNode = mergeNode.next;
                listNode1 = listNode1.next;
                continue;
            }
            if (listNode1.val >= listNode2.val){
                mergeNode.next = listNode2;
                mergeNode = mergeNode.next;
                listNode2 = listNode2.next;
            }
            if (listNode2.val > listNode1.val){
                mergeNode = listNode1;
                mergeNode = mergeNode.next;
                listNode1 = listNode1.next;
            }

        }
        return mergeNode;
    }

}
