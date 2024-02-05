package com.example.demo.onehundredandfifty;

import java.util.HashMap;
import java.util.Map;

/**
 * lru缓存--自定义节点信息
 */
public class LRUCacheTwo {
    private Map<Integer,LRUNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    private LRUNode head;

    private LRUNode tail;

    private int x = 10;

    public LRUCacheTwo(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        LRUNode node = cache.get(key);
        long time = System.currentTimeMillis();
        if (node == null){
            return -1;
        }
        if (time > node.removeTime){
            removeNode(node);
            return -1;
        }
        moveHead(node);
        return node.val;
    }

    public void put(int key, int value){
        LRUNode node = cache.get(key);
        long time = System.currentTimeMillis() + x;
        if (node == null){
            LRUNode newNode = new LRUNode(key, value, time);
            addHead(newNode);
            size++;
            if (capacity < size){
                LRUNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.val = value;
            node.removeTime = time;
            moveHead(node);
        }
    }
    private void addHead(LRUNode node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(LRUNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveHead(LRUNode node){
        removeNode(node);
        addHead(head);
    }

    private LRUNode removeTail(){
        LRUNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
class LRUNode{
    int key;
    int val;

    long removeTime;
    LRUNode prev;
    LRUNode next;

    public LRUNode(){}

    public LRUNode(int key,int val,long removeTime){
        this.key = key;
        this.val = val;
        this.removeTime = removeTime;
    }
}
