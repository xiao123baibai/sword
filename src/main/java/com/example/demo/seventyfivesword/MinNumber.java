package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class MinNumber {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i ++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i ++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
