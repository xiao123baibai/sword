package com.example.demo.seventyfivesword;

import java.util.*;

/**
 * 三数之和
 */
public class threeSum {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     *
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     *
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,9,3,2,-1};
        int[] nums2 = new int[5];

    }
    //排序+双指针
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for (int first = 0; first < nums.length; first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++){
                if (second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[first]);
                    subList.add(nums[second]);
                    subList.add(nums[third]);
                    res.add(subList);
                }
            }
        }
        return res;
    }
}
