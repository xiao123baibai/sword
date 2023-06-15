package com.example.demo.fib;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/11/23
 */
public class Solution {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    private static int fib(int n){
        if (n < 2){
            return n;
        }
        int res = 1;
        int l = 0;
        int r = 0;
        for (int i = 2;i <= n;i++){
            l = r;
            r = res;
            res = (l+r)%1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "https://oss-dev.kaigongla.cn/public/img/H01/2022/11/23/11bc324374554b2cab5f43fddd9819b8.png";
    }


    private static int fib1(int n){
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
