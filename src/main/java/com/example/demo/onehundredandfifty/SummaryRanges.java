package com.example.demo.onehundredandfifty;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.add;

/**
 *  汇总区间
 */
public class SummaryRanges {
    /**
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     *
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
     * 并且不存在属于某个范围但不属于 nums 的数字 x 。
     *
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     *
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     *
     *
     * 示例 1：
     *
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例 2：
     *
     * 输入：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 20
     * -231 <= nums[i] <= 231 - 1
     * nums 中的所有值都 互不相同
     * nums 按升序排列
     */
    //思路：循环需要处理，通过left，right标识，如果right-left>1，则需要特殊处理
    public static List<String> summaryRanges(int[] nums) {
        List<String> resList = new ArrayList<>();
        if (nums.length == 0){
            return resList;
        }
        if (nums.length == 1){
            resList.add(nums[0]+"");
            return resList;
        }
        int len = nums.length;
        int left = nums[0],right = nums[0];
        int temp = nums[0];
        int size = 0;
        for (int i = 1; i < len; i++){
            temp++;
            right = nums[i];

            if (temp != right){
                if (size == 0){
                    resList.add(left+"");
                } else {
                    resList.add(left+"->"+(nums[i-1]));
                }
                left = nums[i];
                temp = nums[i];
                size = 0;
            }
            if (left != right){
                size++;
            }
            if (size == 0 && left == right && i == len -1){
                resList.add(left+"");
            }
        }
        return resList;
    }

    //思路：分组循环
    public static List<String> summaryRanges1(int[] nums){
        List<String> resList = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        while (i < len){
            int low = i;
            i++;
            while (i < len && nums[i] == nums[i-1]+1){
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            resList.add(temp.toString());
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,4,6,8,9};
        summaryRanges(arr);
    }
}
