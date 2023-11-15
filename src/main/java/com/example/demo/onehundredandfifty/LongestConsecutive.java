package com.example.demo.onehundredandfifty;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */
    //思路：排序(修改为往set加值)，然后新增一个临时变量，存储一个max的长度
    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        TreeSet<Integer> noRepeat = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            noRepeat.add(nums[i]);
        }
        int start = 1;
        int temp = -110;
        int max = -1;
        for (Integer num : noRepeat){
            if(temp == -110){
                temp = num;
            }
            if (num!= temp){
                temp = num;
                start = 1;
            }
            max = Math.max(max,start);
            temp++;
            start++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        longestConsecutive(nums);
    }
}
