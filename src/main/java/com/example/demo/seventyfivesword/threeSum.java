package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length;first++){
            if (first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int target = -nums[first];
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++){
                if (second > first+1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> subList = new ArrayList<Integer>();
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
