package com.example.demo.seventyfivesword;

import java.time.temporal.Temporal;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Exchange {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     *
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */

    /**
     * 双指针法 一 遍历指针 二 尾部指针
     *
     * 核心是临界条件： i<=k
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums){
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            while (nums[i]%2 == 1 && i <= k){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
