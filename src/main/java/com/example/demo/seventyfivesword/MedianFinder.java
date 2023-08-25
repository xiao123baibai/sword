package com.example.demo.seventyfivesword;

import java.util.PriorityQueue;

public class MedianFinder {
        /*
        平衡堆:大顶堆+小顶堆(参考k神)
        创建两个堆:其中堆A为小顶堆(存储较大的一半元素);堆B为大顶堆(存储较小的一半元素)
        规定存储元素个数:A>=B;设A中有m个元素,B中有n个元素,一共有N=m+n个元素
        当N为奇数时:m=(N+1)/2,m=(N-1)/2;当N为偶数时:m=n=N/2
        findMedian():
            1.当m+n为偶数时,中位数=(A堆顶元素+B堆顶元素)/2.0
            2.当m+n为奇数时,中位数=A堆顶元素
        addNum(int num):其目的是使得两个堆平衡(数目差0或1)
            1.当m=n时,num应该添加进A中,但num可能是较小的一半,因此先入堆B,再将B堆顶弹出入A
            2.当m=n+1时,num应该添加进B中,但num可能是较大的一半,因此先入堆A,再将A堆顶弹出入B
        时间复杂度:O(1)+O(logN)=O(logN);空间复杂度:O(N)
        */
        // 声明两个堆
        PriorityQueue<Integer> A, B;
        public MedianFinder() {
            // 初始化堆:A为小顶堆,存储较大的一半元素;B为大顶堆,存储较小的一半元素
            // 默认为小顶堆
            A = new PriorityQueue<>();
            B = new PriorityQueue<>((a, b) -> b - a);
        }

        /*
        添加元素到数据流中
        */
        public void addNum(int num) {
            if(A.size() == B.size()) {
                // 1.m=n,num应该加入A(先入B再弹出B堆顶入A)
                B.add(num);
                A.add(B.poll());
            }else {
                // 2.m=n+1,num应该加入B(先入A再弹出A堆顶入B)
                A.add(num);
                B.add(A.poll());
            }
        }

        /*
        获取数据流的中位数
        */
        public double findMedian() {
            // 注意这里是peek()不是poll()
            return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : (double)A.peek();
        }
}
