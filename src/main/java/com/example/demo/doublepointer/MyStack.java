package com.example.demo.doublepointer;

import java.util.Arrays;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/9/27
 */
public class MyStack {

    /**
     * 存放栈中元素
     */
    private int[] storage;
    /**
     * 栈的容量
     */
    private int capacity;
    /**
     * 栈中元素数量
     */
    private int count;

    private static final int GROW_FACTOR = 2;

    public MyStack() {
        this.capacity = 8;
        this.storage = new int[8];
        this.count = 0;
    }

    public MyStack(Integer initialCapacity){
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity too small.");
        }
            this.capacity = initialCapacity;
            this.storage = new int[initialCapacity];
            this.count = 0;
    }
    //入栈
    public void push(int value){
        if (count == capacity){
            ensureCapacity();
        }
        storage[count++] = value;
    }
    //确保容量大小
    private void ensureCapacity(){
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage,newCapacity);
        capacity = newCapacity;
    }
    //返回栈顶元素并出栈
    private int pop(){
        if (count == 0) {
            throw new IllegalArgumentException("Capacity is empty.");
        }
        count--;
        return storage[count];
    }
    private  int peek(){
        if (count == 0) {
            throw new IllegalArgumentException("Capacity is empty.");
        }else {
            return storage[count - 1];
        }
    }
    private int size(){
        return count;
    }
}
