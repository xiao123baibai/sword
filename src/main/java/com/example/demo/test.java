package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
    /**
     * int n 核数
     * int[] 任务时长
     */
    public int time(int n, int[] times){
        int len = times.length;
        Arrays.sort(times);
        Map<Integer,Integer> map = new HashMap<>();
        int index = n;
        for (int i = 0; i < len; i++){
            if (index > 0){
                map.put(index,times[i]);
                index--;
                continue;
            }
            int minIndex = findMin(map);
            map.put(minIndex,map.get(minIndex) + times[i]);
        }
        int maxRes = 0;
        for (Integer in : map.keySet()){
            maxRes = Math.max(maxRes,map.get(in));
        }
        return maxRes;
    }

    private int findMin(Map<Integer,Integer> map){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (Integer i : map.keySet()){
            if (minValue >= map.get(i)){
                minIndex = i;
                minValue = map.get(i);
            }
        }
        return minIndex;
    }
}
