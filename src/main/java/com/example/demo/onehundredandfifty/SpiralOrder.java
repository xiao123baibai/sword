package com.example.demo.onehundredandfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrder {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     *
     * 输入：matrix = [[1, 2, 3, 4],
     *                [5, 6, 7, 8],
     *                [9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rol = matrix.length-1;
        int col = matrix[0].length-1;
        int right = 0;
        int down = 0;
        int left = col;
        int up = rol;
        while (right <= left || down <= up){
            //从左往右
            for (int i = right;i <= left; i++){
                result.add(matrix[down][i]);
            }
            down++;
            if (down > up){
                break;
            }
            //从上往下
            for (int i = down; i <= up; i++){
                result.add(matrix[i][left]);
            }
            left--;
            if (left < right){
                break;
            }
            //从右往左
            for (int i = left; i >=right; i--){
                result.add(matrix[up][i]);
            }
            up--;
            if (up < down){
                break;
            }
            //从下往上
            for (int i = up; i >= down; i--){
                result.add(matrix[i][right]);
            }
            right++;
            if (right > left){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }

}
