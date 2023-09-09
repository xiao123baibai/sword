package com.example.demo.seventyfivesword;

/**
 *  数组中数字出现的次数
 */
public class SingleNumbers {
    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     *
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     *
     *
     * 限制：
     *
     * 2 <= nums.length <= 10000
     */
    //个人思路使用map
    public int[] singleNumbers(int[] nums) {
        int a = 0,b = 0 ,n = 0,m=1;
        for (int num:nums){
            n ^=num;
        }
        while ((n & m)==0){
            m <<= 1;
        }
        for (int num:nums){
            if ((m & num)!=0){
                a ^=num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
