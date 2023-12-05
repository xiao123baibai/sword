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
    //摩尔算法--投票
    //假设1：若为众数则票数+1，非众数则票数-1，若存在众数，则所有数字的票数的和一定>0
    //假设2：若数组的前a个数字的和为0，则数组剩余的（n-a）个数字的票数和一定>0,则后（n-a）个数字的众数仍为x
    public int majorityElement2(int[] nums) {
        int x = 0,votes = 0,count = 0;
        for (int num : nums){
            if (votes == 0){
                x = num;
            }
            votes += x == num ? 1:-1;
        }
        for (int num :nums){
            if (x == num){
                count++;
            }
        }
        return count > nums.length/2 ? x:0;
    }

    //摩尔算法

    public int majorityElement3(int[] nums){
        int x = 0,votes = 0,count = 0;
        for (int num : nums){
            if (votes == 0){
                x = num;
            }
            votes += (x == num ? 1:-1);
        }
        for (int num : nums){
            if (x == num){
                count++;
            }
        }
        return count > nums.length/2 ? x:0;
    }
}
