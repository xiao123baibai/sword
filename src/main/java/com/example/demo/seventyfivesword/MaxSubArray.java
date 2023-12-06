package com.example.demo.seventyfivesword;

/**
 * 连续子数组的最大和
 */
public class MaxSubArray {
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     *
     *
     *
     * 示例1:
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    //思路：双指针+双层循环
    //  d[i-1]>=0 d[i] = d[i-1]+nums[i]
    // d[i-1]<0 d[i] = nums[i]
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length;i++){
            nums[i] += Math.max(nums[i-1],0);
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public int maxSubArray1(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            nums[i] += Math.max(nums[i-1],0);
            max = Math.max(nums[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i);
        int j = 0;
        System.out.println(j++);
    }
}
