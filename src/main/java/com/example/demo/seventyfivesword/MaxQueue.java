package com.example.demo.seventyfivesword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列的最大值
 */
public class MaxQueue {
    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     *
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     *
     * 示例 1：
     *
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * 示例 2：
     *
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     */

    //此题最终要的是读懂题
    //暴力循环法  --用数据存储数据，每次循环寻找最大值
//    int[] ans = new int[20000];
//    int end ,begin = 0;
//    public MaxQueue() {
//
//    }
//
//    public int max_value() {
//        int max = -1;
//        for (int i = begin; i < end; i++){
//            max = Math.max(max,ans[i]);
//        }
//        return max;
//    }
//
//    public void push_back(int value) {
    //end++ 而不是++end的原因，end是从0开始，需要从0开始赋值
//        ans[end++] = value;
//    }
//
//    public int pop_front() {
//        if (begin == end){
//            return -1;
//        }
//        return ans[begin++];
//    }
    //单调队列法  --维护两个队列，然后一个构建成降序单调队列
    Deque<Integer> max;
    Deque<Integer> p;
    public MaxQueue() {
        max = new LinkedList<>();
        p = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()){
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value){
            max.pollLast();
        }
        max.offerLast(value);
        p.offer(value);

    }

    public int pop_front() {
        if (p.isEmpty()){
            return -1;
        }
        int ans = p.poll();
        if (ans == max.peekFirst()){
            max.pollFirst();
        }
        return ans;
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
}
