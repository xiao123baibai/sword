package com.example.demo.seventyfivesword;

/**
 * 在排序数组中查找数字 I
 */
public class Search {
    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     */

    public int search(int[] nums, int target){
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (target == nums[i]){
                count++;
            }
            if (target < nums[i]){
                break;
            }
        }
        return count;
    }

    //二分查找法

    public int search1(int[] nums,int target){
        return helper(nums,target) - helper(nums,target-1);
    }

    private int helper(int[] nums, int target){
        int i = 0,j = nums.length - 1;
        while (i <= j){
            int m = (i + j)/2;
            if (j >= 0 && nums[m] <= target){
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        return i;
    }
}
