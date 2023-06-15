package com.example.demo.swordforward;

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

    private int[] exchange(int[] nums){
        int[] res = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]%2 == 1){
                res[head] = nums[i];
                head++;
            }
            if (nums[i]%2 == 0){
                res[tail] = nums[i];
                tail--;
            }
        }
        return res;
    }
}
