package com.example.demo.onehundredandfifty;

/**
 * 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     *
     *
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     */
    //思路：获取所有数的乘集，下面是使用除法的   哈哈哈，没看到不能使用
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int countZero = 0;
        int[] answer = new int[nums.length];
        for (int num : nums){
            if (num != 0){
                sum *= num;
            }else {
                countZero++;
            }
        }
        if (countZero >= 2){
            sum = 0;
        }
        for (int i =0;i < nums.length;i++){
            if (countZero == 0){
                answer[i] = sum/nums[i];
            }else {
                if (nums[i] != 0){
                    answer[i] = 0;
                }else {
                    answer[i] = sum;
                }
            }
        }
        return answer;
    }

    public int[] productExceptSelf1(int[] nums){
        int len = nums.length;
        if (len == 0){
            return new int[0];
        }
        int[] answer = new int[nums.length];
        int temp = 1;
        answer[0] = 1;
        //answer[i]表示的是 i 左侧的数乘积
        for (int i = 1; i < len;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        for (int j = len-2;j>=0;j--){
            //temp表示j右边的数乘积
            temp *= nums[j+1];
            answer[j] *= temp;
        }
        return answer;
    }

}
