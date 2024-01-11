package com.example.demo.onehundredandfifty;

/**
 * 189. 轮转数组
 */
public class Rotate {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     */
    //思路：额外数组法+找一个辅助数组 (i+k)%n
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0;i < n; i++){
            int num = (i+k)%n;
            //temp[i] = nums[num];
            temp[num] = nums[i];//为什么上面是错误的，因为是数组的第一位向后位移三位
        }
        for (int j = 0;j < n;j++){
            nums[j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1,2,3,4,5,6,7};
        rotate(temp,3);
    }
    //思路：环状替换--想不清楚
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    //思路2:数组翻转
    //操作	结果
    //原始数组	1~2~3~4~5~6~7
    //翻转所有元素	7~6~5~4~3~2~1
    //翻转 [0,k mod n−1][0, k\bmod n - 1][0,kmodn−1] 区间的元素	5~6~7~4~3~2~1
    //翻转 [k mod n,n−1][k\bmod n, n - 1][kmodn,n−1] 区间的元素	5~6~7~1~2~3~4

    //
    //
    public void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);

    }
    private void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //环形数组
    //思路1:取模交换位置
    public void rotate11(int[] nums, int k){
        int[] temp = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            int position = (i+k)% nums.length;
            temp[position] = nums[i];
        }
        for (int i = 0;i < nums.length;i++){
            nums[i] = temp[i];
        }
    }
    //思路2:翻转数组
    public void rotate12(int[] nums, int k){
        k %= nums.length;
        reverse1(nums,0, nums.length-1);
        reverse1(nums,0,k-1);
        reverse1(nums,k,nums.length-1);
    }
    private void reverse1(int[] nums, int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
