package com.example.demo.seventyfivesword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 包含min函数的栈
 */
public class MinStack {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     *
     *
     *
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     */
    Deque<Integer> minStack;
    Deque<Integer> xStack;
    public MinStack(){
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(Integer num){
        xStack.push(num);
        minStack.push(Math.min(minStack.peek(),num));
    }

    public Integer min(){
        return minStack.peek();
    }

    public void pop(){
        xStack.pop();
        minStack.pop();
    }

    public Integer top(){
        return xStack.peek();
    }
}
