package com.example.demo.onehundredandfifty;

import com.example.demo.seventyfivesword.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru缓存 -- 使用现成的数据结构
 */
public class LRUCacheThree extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCacheThree(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() >  capacity;
    }
}
