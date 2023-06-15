package com.example.demo.swordforward;


public class SpiralOrder {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public int[] spiralOrder(int[][] matrix){
        int l = matrix.length;
        int d = matrix[0].length;
        int length = l*d;
        int[] res = new int[length];
        int ud = 0;
        int rl = 0;
        int dd = d-1;
        int ll = l-1;
        int resLength = 0;
        while (true){
            //up 从左到右
            for (int p = ud; p<=dd ;p++){
                res[resLength] = matrix[rl][p];
                resLength++;
            }
            //处理节点
            rl++;
            if (rl > ll){
                break;
            }
            //right 从上到下
            for (int p = rl; p<=ll; p++){
                res[resLength] = matrix[p][dd];
                resLength++;
            }
            dd--;
            if (dd < ud){
                break;
            }
            //down 从右到左
            for (int p = dd; p >= ud; p--){
                res[resLength] = matrix[ll][p];
                resLength++;
            }
            ll--;
            if (ll < rl){
                break;
            }
            //left 从下到上
            for (int p = ll; p >= rl; p--){
                res[resLength] = matrix[p][ud];
                resLength++;
            }
            ud++;
            if (dd < ud){
                break;
            }
        }
        return res;
    }
}
