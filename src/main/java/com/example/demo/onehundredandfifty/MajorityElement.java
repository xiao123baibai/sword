package com.example.demo.onehundredandfifty;

/**
 * 多数元素
 */
public class MajorityElement {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     */
    //思路一：hash表计算法  最低级
    //思路二：思考中  摩尔算法
    //假设、若众数为1，非众数为-1，若数组众一定存在众数则数组和一定>0
    //假设2、若数组的前n个数为零，则数组剩余的（l-n）的数组的页页大于零
    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        int count = 0;
        for (int num : nums){
            if (votes == 0){
                x = num;
            }
            votes += x==num ? 1:-1;
        }
        for (int num : nums){
            if (x == num){
                count++;
            }
        }
        return count > nums.length/2 ? x:0;
    }

    //多数问题--摩尔算法
    public int majorityElement1(int[] nums){
        int count = 0,votes = 0,x = 0;
        for (int num : nums){
            if(votes == 0){
                x = num;
            }
            votes += num == x ? 1:-1;
        }
        for (int figure:nums){
            if (x == figure){
                count++;
            }
        }
        return count > nums.length/2 ? x : 0;
    }
}
