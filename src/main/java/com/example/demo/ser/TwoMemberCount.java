package com.example.demo.ser;

/**
 * 功能描述:两数相加
 *
 * @Author: qinlida
 * @Date: 2022/8/29
 */
public class TwoMemberCount {
    /**
     * 双层循环实现
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0;i < nums.length;i++){
            for (int j = i+1;j < nums.length;j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums,target);
        System.out.println(res.toString());
    }
}
