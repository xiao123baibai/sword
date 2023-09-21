package com.example.demo.onehundredandfifty;

import java.util.Arrays;

/**
 * 分发糖果
 */
public class Candy {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     *
     * 你需要按照以下要求，给这些孩子分发糖果：
     *
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例 2：
     *
     * 输入：ratings = [1,2,2]
     * 输出：4
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     *
     *
     * 提示：
     *
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     */
    //思路：找到最低点，分别想两边扩展延伸
    //确定规则 假设学生A和学生B相邻，A在B的左边
    //右规则 ratingsB>ratingsA,则B领的糖大于A
    //左规则 ratingsA>ratingsB，则A领的糖大于B
    //统一规则
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < len;i++){
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        int count = left[len-1];
        for (int i = len - 2; i >=0;i--){
            if (ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            count += Math.max(right[i],left[i]);
        }
        return count;
    }
}
