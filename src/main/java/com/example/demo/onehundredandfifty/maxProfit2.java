package com.example.demo.onehundredandfifty;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class maxProfit2 {
    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     */
    // 思路：穷举所有的获利  二分法，找固定区间中的最大获利---错误

    //思路1:动态规划  二维数组到两个变量，到现在位置没看明白的
    public int maxProfit(int[] prices) {
        if (prices.length<2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);//cash
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//stock
        }
        return dp[prices.length-1][0];
    }

    //思路2:贪心算法，上涨都交易，下跌都不交易
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1;i < prices.length;i++){
            int temp = prices[i] - prices[i-1];
            if (temp>0){
                profit += temp;
            }
        }
        return profit;
    }

    //思路1:贪心算法
    public int maxProfit11(int[] prices){
        int profit = 0;
        for (int i = 1; i < prices.length;i++){
            profit += (prices[i] - prices[i-1])>0 ? prices[i] - prices[i-1] : 0;
        }
        return profit;
    }
    //思路2:公式解法
    public int maxProfit12(int[] prices){
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;//获利
        dp[0][1] = -prices[0]; //持有股票后剩余的现金
        for (int i = 1;i < len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}
