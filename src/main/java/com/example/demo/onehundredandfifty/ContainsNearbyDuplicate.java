package com.example.demo.onehundredandfifty;

import java.util.HashMap;

/**
 * 存在重复元素 II
 */
public class ContainsNearbyDuplicate {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
     * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * 示例 3：
     *
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     *
     *
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * 0 <= k <= 105
     */
    //思路：第一次大循环，然后当前坐标+k进行
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length-1;
        for (int i = 0; i < len;i++){
            int end = i + k >= len ? len:i+k;
            for (int j = i+1; j <= end; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //思路：使用hash表,和做两数只和一样的用法
    public static boolean containsNearbyDuplicate1(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        containsNearbyDuplicate(nums,3);
    }
}
