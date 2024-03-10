package com.example.demo.onehundredandfifty;

/**
 * 130. 被围绕的区域
 */
public class Solve {
    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     *
     * 示例 1：
     *
     *
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     *
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     *
     *
     * 提示：
     *
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] 为 'X' 或 'O'
     */
    public void solve(char[][] board) {
        int n = board.length - 1;
        int m = board[0].length - 1;
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                boolean flag = false;
                //判断是否为边界处
                if (i == 0 || j == 0 || i == n || j == m){
                    flag = true;
                }
                //判断边界上是否有O，有O就进行dfs，找到所有的边界O
                if (flag && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                //与边界相关的dfs被赋值为#，所以要换回来
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                    //无关的O全部替换
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
    private void dfs(char[][] board, int r, int c){
        //超边界或者是已经遍历，或者是不合适字母O
        if(r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O'){
            return;
        }
        //边界的值才赋值为#
        board[r][c] = '#';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}
