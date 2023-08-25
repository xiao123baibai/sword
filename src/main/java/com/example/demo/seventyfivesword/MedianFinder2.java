package com.example.demo.seventyfivesword;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class MedianFinder2 {

    PriorityQueue<Integer> A, B;

    public MedianFinder2() {
        A = new PriorityQueue<>();//默认小顶堆
        B = new PriorityQueue<>((a, b) -> b - a);//大顶堆
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? (A.peek()+B.peek())/ 2.0 : (double)A.peek();
    }
}
