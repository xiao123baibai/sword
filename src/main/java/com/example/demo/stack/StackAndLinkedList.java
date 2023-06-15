package com.example.demo.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/11/15
 */
public class StackAndLinkedList {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        Deque<Integer> linkedList = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(6);
        System.out.println(linkedList);
        System.out.println(linkedList.pop());
        System.out.println(linkedList.peek());
        System.out.println(linkedList);
    }
}
