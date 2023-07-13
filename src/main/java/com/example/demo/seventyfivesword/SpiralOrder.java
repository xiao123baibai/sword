package com.example.demo.seventyfivesword;

/**
 * 顺时针打印矩阵
 */
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
        if(matrix.length == 0){
            return new int[0];
        }
        //先抽四个方向-->并进行联动处理
        int length = matrix.length;
        int width = matrix[0].length;
        int[] ans = new int[length*width];
        int up = 0;
        int right = 0;
        int down = width - 1;
        int left = length - 1;
        int pointer = 0;
        while (true){
            //up
            for (int i = up; i <= down;i++){
                ans[pointer++] = matrix[right][i];
            }
            right++;
            if (right > left){
                break;
            }
            //right
            for (int i = right; i <= left;i++){
                ans[pointer++] = matrix[i][down];
            }
            down--;
            if (down < up){
                break;
            }
            //down
            for (int i = down; i >=up;i--){
                ans[pointer++] = matrix[left][i];
            }
            left--;
            if (left < right){
                break;
            }
            for (int i = left; i >=right;i--){
                ans[pointer++] = matrix[i][up];
            }
            up++;
            if (up > down){
                break;
            }
        }
        return ans;
    }

}
