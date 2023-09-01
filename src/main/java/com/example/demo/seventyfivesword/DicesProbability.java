package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * n个骰子的点数
 */
public class DicesProbability {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     *
     *
     *
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     *
     *
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 示例 2:
     *
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     */
    public double[] dicesProbability(int n) {
        //因为最后的结果只与前一个动态转移数组有关，所以这里只需要设置一个一维的动态转移数组
        //原本dp[i][j]表示的是前i个骰子的点数之和为j的概率，现在只需要最后的状态的数组，所以就只用一个一维数组dp[j]表示n个骰子下每个结果的概率。
        //初始是1个骰子情况下的点数之和情况，就只有6个结果，所以用dp的初始化的size是6个
        double[] dp = new double[6];
        //只有一个数组
        Arrays.fill(dp,1.0/6.0);
        //从第2个骰子开始，这里n表示n个骰子，先从第二个的情况算起，然后再逐步求3个、4个···n个的情况
        //i表示当总共i个骰子时的结果
        for(int i=2;i<=n;i++){
            //每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            //比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            //当有i个骰子时的点数之和的值数组先假定是temp
            double[] temp = new double[5*i+1];
            //从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
            //先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值
            for(int j=0;j<dp.length;j++){
                //比如只有1个骰子时，dp[1]是代表当骰子点数之和为2时的概率，它会对当有2个骰子时的点数之和为3、4、5、6、7、8产生影响，
                // 因为当有一个骰子的值为2时，另一个骰子的值可以为1~6，产生的点数之和相应的就是3~8；比如dp[2]代表点数之和为3，
                // 它会对有2个骰子时的点数之和为4、5、6、7、8、9产生影响；所以k在这里就是对应着第i个骰子出现时可能出现六种情况，
                // 这里可能画一个K神那样的动态规划逆推的图就好理解很多
                for(int k=0;k<6;k++){
                    //这里记得是加上dp数组值与1/6的乘积，1/6是第i个骰子投出某个值的概率
                    temp[j+k]+=dp[j]*(1.0/6.0);
                }
            }
            //i个骰子的点数之和全都算出来后，要将temp数组移交给dp数组，dp数组就会代表i个骰子时的可能出现的点数之和的概率；用于计算i+1个骰子时的点数之和的概率
            dp = temp;
        }
        return dp;
    }
    public double[] dicesProbability2(int n){
        double[] dp = new double[6];
        //一个骰子的情况下
        Arrays.fill(dp,1.0/6.0);
        //多个骰子
        for (int i = 2;i<=n;i++){
            double[] temp = new double[5*i+1];
            //所影响的是i个骰子时的temp[j+k]的值
            for (int j =0;j<dp.length;j++){
                for (int k = 0;k < 6;k++){
                    temp[j+k] += dp[j]*(1.0/6.0);
                }
            }
            dp = temp;
        }
        return dp;
    }
    public double[] dicesProbability1(int n){
        int maxsum = n * 6;
        long[][] dp = new long[2][maxsum + 1];

        for(int i = 1; i <= 6; i++){
            dp[0][i] = 1;
        }

        int flag = 1; //旋转标记
        for(int i = 2; i <= n; i++, flag = 1 - flag){
            for(int j = 0; j <= i * 6; j++){
                dp[flag][j] = 0; //旋转数组清零
            }
            for(int j = i; j <= i * 6; j++){
                for(int k = 1; k <= 6 && k < j; k++){
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        double totalnum = Math.pow(6, n);
        double[] ans = new double[n * 5 + 1];
        for(int i = n; i <= maxsum; i++){
            ans[i - n] = dp[1 - flag][i] / totalnum;
        }
        return ans;
    }

}
