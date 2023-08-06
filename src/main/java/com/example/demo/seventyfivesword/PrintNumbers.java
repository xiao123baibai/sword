package com.example.demo.seventyfivesword;

/**
 * 打印从1到最大的n位数
 */
public class PrintNumbers {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     */

    public int[] printNumbers(int n){
        int num = 0;
        for (int i = 0; i < n; i ++){
            num += (int) Math.pow(10,i)*9;
        }
        int[] res = new int[n];
        for (int j = 0; j < num; j++){
            res[j] = j + 1;
        }
        return res;
    }
}
