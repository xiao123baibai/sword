package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 */
public class MajorityElement {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     *
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     */
    //思路：通过hash表来存储，同时有一个临时变量来存储最大的数量
    public int majorityElement(int[] nums) {
        int temp = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            int key = num;
            if (map.containsKey(key)){
                int subSum = map.get(key)+1;
                map.put(num,subSum);
                temp = Math.max(temp,subSum);
            }else {
                map.put(num,1);
            }
        }
        int res = nums[0];;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (temp == entry.getValue()) {
                res = entry.getKey();
            }
        }
        return res;
    }
}
