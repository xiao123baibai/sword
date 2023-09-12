package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class FindContinuousSequence {
    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     *
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     */
    //思路整理：暴力循环法,仍然需要巧妙的思考边界问题limit,同时j的边界是可以超过limit的
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 0,limit = (target-1)/2;
        for (int i = 1; i<=limit;i++){
            for (int j= i;;j++){
                sum +=j;
                if (sum > target){
                    sum = 0;
                    break;
                }else if (sum == target){
                    int[] sub = new int[j-i+1];
                    for (int l = i; l<=j;l++){
                        sub[l-i]=i;
                    }
                    res.add(sub);
                    sum = 0;
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    //思路2:双指针法--滑动窗口
    public int[][] findContinuousSequence1(int target){
        List<int[]> res = new ArrayList<>();
        int l = 1,r = 2,sum = 3;
        while (l <r){
            if (sum < target){
                r++;//因为要加，所以提前++
                sum += r;
            }else if (sum > target){
                sum -= l;//因为要减，所以先减后减减
                l++;
            }else {
                int[] sub = new int[r-l+1];
                for (int k= l; k<=r;k++){
                    sub[k-l]=k;
                }
                res.add(sub);
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
