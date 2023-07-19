package com.example.demo.seventyfivesword;

/**
 * 矩阵中的路径
 */
public class Exist {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     */

    public boolean exist(char[][] board, String word){
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int l = 0; l < board.length; l++){
                if (dfs(board,words,i,l,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,char[] words,int i,int l, int k){
        if (i < 0 || i > board.length || l < 0 || l > board[0].length || board[i][l] != words[k]){
            return false;
        }
        if (k == words.length - 1){
            return true;
        }
        //设置为空来占用
        board[i][l] = '\0';
        boolean res = dfs(board,words,i-1,l,k+1) ||
                dfs(board,words,i+1,l,k+1) ||
                dfs(board,words,i,l-1,k+1) ||
                dfs(board,words,i,l+1,k+1);
        //递归结束二维数组还原
        board[i][l] = words[k];
        return res;
    }

    public static void main(String[] args) {
        char c = '0';
        char h = '\0';
        System.out.println(c +"----" +h);
    }
}
