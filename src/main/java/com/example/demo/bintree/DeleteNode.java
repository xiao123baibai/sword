//package com.example.demo.bintree;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.Lists;
//
//import java.util.List;
//
///**
// * 功能描述:
// *
// * @Author: qinlida
// * @Date: 2022/11/30
// */
//public class DeleteNode {
//    static class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//    }
//    public static ListNode deleteNode(ListNode head, int val) {
//        if(head == null){
//            return null;
//        }
//        if (head.val == val){
//            return head.next;
//        }
//        ListNode curNode = head;
//        while(curNode.next != null){
//            if(curNode.next.val == val){
//                curNode.next = curNode.next.next;
//                return head;
//            }
//            curNode = curNode.next;
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(9);
//        head.next =node2;
//        node2.next = node3;
//        node3.next = node4;
////        deleteNode(head,5);
//        List<Integer> list1 = Lists.newArrayList(1,2,3,4);
//        List<Integer> list2 = Lists.newArrayList(2,3);
//        list1.removeAll(list2);
//        System.out.println(JSON.toJSONString(null));
//    }
//}
