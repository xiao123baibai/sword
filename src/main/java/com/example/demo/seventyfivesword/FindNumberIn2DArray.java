package com.example.demo.seventyfivesword;

/**
 * 二维数组中的查找
 */
public class FindNumberIn2DArray {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
     * 每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target){
        int n = 0;
        int m = matrix.length - 1;
        boolean flag = false;
        while (n < matrix[0].length && m >= 0){
            if (matrix[m][n] == target){
                flag = true;
                break;
            }else if (matrix[m][n] < target){
                n++;
            }else {
                m--;
            }
        }
        return flag;
    }

//    int n = matrix.length - 1;
//    int m = 0;
//    boolean flag = false;
//        while(n >= 0 && m <= matrix[0].length - 1){
//        if(target == matrix[n][m]){
//            flag = true;
//            break;
//        }else if(target > matrix[n][m]){
//            ++m;
//        }else{
//            --n;
//        }
//    }
//        return flag;
}
