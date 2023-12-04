package com.example.demo.seventyfivesword;

/**
 * 剪绳子
 */
public class CuttingRope {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     *
     * 2 <= n <= 58
     */
    //思路：可以考虑乘机数组的能力，需要解决的是绳子剪成m端怎么划分  数学知识，函数极值证明
    public int cuttingRope(int n) {
        if(n <= 3){
            return n-1;
        }
        int a = n/3,b=n%3;
        if (b == 0){
            return (int) Math.pow(3,a);
        }else if (b==1){
            return (int) Math.pow(3,a-1)*4;
        }else {
            return (int) Math.pow(3,a)*2;
        }
    }

    public int cuttingRope1(int n){
        if (n <= 3){
            return n-1;
        }
        int a = n/3,b = n%3;
        if (b == 0){
            return (int)Math.pow(3,a);
        }else if (b == 1){
            return (int)Math.pow(3,a-1)*4;
        }else {
            return (int)Math.pow(3,a)*2;
        }
    }
}
