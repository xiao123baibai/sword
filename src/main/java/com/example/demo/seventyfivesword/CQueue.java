package com.example.demo.seventyfivesword;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class CQueue {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * 示例 1：
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
     * [[],[3],[],[],[]]
     * 输出：[null,null,3,-1,-1]
     * 示例 2：
     *
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     */
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }
    public void appendTail(Integer in){
        stackIn.push(in);
    }

    public Integer deleteHead(){
        if (!stackOut.isEmpty()){
            return stackOut.pop();
        }
        while (!stackIn.isEmpty()){
             stackOut.push(stackIn.pop());
        }
        return stackOut.isEmpty() ? -1:stackOut.pop();
    }
}
