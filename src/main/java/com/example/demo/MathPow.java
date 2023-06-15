package com.example.demo;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/11/29
 */
public class MathPow {
    /**
     * Java 代码中 int32 变量 n∈[−2147483648,2147483647]n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，
     * 因此当 n=−2147483648 时执行 n=−n会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b，后面用 b 操作即可。
     * if(x == 0){
     *             return 0;
     *         }
     *         long b = n;
     *         double res = 1.0;
     *         if(b < 0) {
     *             x = 1 / x;
     *             b = -b;
     *         }
     *         while(b > 0) {
     *             if((b & 1) == 1) {
     *                 res *= x;
     *             }
     *             x *= x;
     *             b >>= 1;
     *         }
     *         return res;
     */
    public static double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1/x;
            b = -b;
        }
        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }
}
