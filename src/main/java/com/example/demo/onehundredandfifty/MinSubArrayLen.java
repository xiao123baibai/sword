package com.example.demo.onehundredandfifty;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */
    //思路：滑动窗口，设置两个接口，先移动右指针，如果加上右边的sum超了之后，使用right-left+1来获取长度，滑动窗口使用的一定是双层循环
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n){
            sum += nums[right];
            if (sum >= target){
                res = Math.max(res,right-left+1);
                sum -= nums[left--];
            }else if (sum < target){
                right++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }

    //暴力循环  思路没问题会超时
    public int minSubArrayLen1(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += nums[j];
                if (sum >= target){
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0:ans;
    }
}
