package com.example.demo.onehundredandfifty;

/**
 * 跳跃游戏
 */
public class CanJump {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */
    //思路：题目解析，相邻的几个数字的和为数组最后一个值,彻彻底底的理解错题了
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return false;
        }
        int sum = nums[len - 1];
        int temp = sum;
        for (int i= 0; i < len-1; i++){
            if (nums[i] > temp){
                temp = sum;
            }
            if (nums[i] <= temp){
                temp -= nums[i];
                if(temp < 0){
                    i--;
                    temp = sum;
                }
                if (temp ==0){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean canJump1(int[] nums){
        int len = nums.length;
        int furthest = 0;
        for (int i = 0; i < len;i++){
            if(i > furthest){
                return false;
            }
            furthest = Math.max(furthest,i+nums[i]);//能到达的最远距离
        }

        return true;
    }

}
