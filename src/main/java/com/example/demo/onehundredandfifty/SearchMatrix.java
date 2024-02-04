package com.example.demo.onehundredandfifty;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int row = binarySearchFirstColumn(matrix,target);
        if (row < 0){
            return false;
        }
        return binarySearchFirstRow(matrix[row],target);
    }
    public int binarySearchFirstColumn(int[][] matrix, int target){
        int low = 0, high = matrix.length - 1;
        while (low < high){
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target){
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean binarySearchFirstRow(int[] row, int target){
        int low = 0, high = row.length - 1;
        while (low < high){
            int mid = (high - low + 1) / 2 + low;
            if (row[mid] == target){
                return true;
            }else if (row[mid]< target){
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }
}
