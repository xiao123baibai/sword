package com.example.demo.onehundredandfifty;

import java.util.HashMap;
import java.util.Map;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {
    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
     *
     * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
     * 返回 k 。
     * 判题标准:
     *
     * 系统会用下面的代码来测试你的题解:
     *
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     *
     * int k = removeDuplicates(nums); // 调用
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    //双指针思路
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0,right = nums.length-1;
        while (left<=right){
            if (!map.containsKey(nums[left])){
                map.put(nums[left],0);
                left++;
            }else {
                nums[left] = nums[right];
                right--;
            }
        }
        sort1(nums,0,left-1);
        return left;
    }
    public int[] sort1(int[] arr,int left, int right){
        int low = left;
        int high = right;
        if (low>=right){
            return new int[0];
        }
        int pivot = arr[low];
        while (low < high){
            while(low < high&&pivot<=arr[high]){//变化的是high
                high--;
            }
            arr[low] = arr[high];
            while (low < high&&pivot>=arr[low]){//变化的是low
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        sort1(arr,left,low-1);
        sort1(arr,low+1,right);
        return arr;
    }
    //双指针思路优化，
    public int removeDuplicates1(int[] nums){
        if (nums.length <=1){
            return nums.length;
        }
        int fast = 1,slow = 1;
        while (fast < nums.length){
            if (nums[fast]!= nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    //方法一：因为是升序，索引可以使用交互位置，然后排序，重新复现一下当时的想法
    public int removeDuplicates11(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        Map<Integer,Integer> map = new HashMap<>();
        while (left <= right){
            if (!map.containsKey(nums[left])){
                map.put(nums[left],0);
                left++;
            }else {
                nums[left] = nums[right];
                right--;
            }
        }
        quickSort(nums,0,left-1);
        return left;
    }
    public int[] quickSort(int[] nums,int left,int right){
        int low = left;
        int high = right;
        if (low >= high){
            return new int[0];
        }
        int pivot = nums[low];
        while (low < high){
            while (low < high && pivot <= nums[high]){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && pivot >= nums[low]){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        quickSort(nums,left,low-1);
        quickSort(nums,low+1,right);
        return nums;
    }
    //方法二：双指针优化
    public int removeDuplicates12(int[] nums){
        if (nums.length<2){
            return nums.length;
        }
        int fast = 1,slow = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[fast -1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    //方法三：通用方法处理
    public int removeDuplicates13(int[] nums){
       return process(nums,1);
    }
    private int process(int[] nums,int k){
        int n = 0;
        for (int num : nums){
            if (n < k || nums[n-k] != num){
                nums[n++] = num;
            }
        }
        return n;
    }
}
