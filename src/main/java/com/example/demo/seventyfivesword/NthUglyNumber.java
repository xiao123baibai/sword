package com.example.demo.seventyfivesword;

/**
 * 丑数
 */
public class NthUglyNumber {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     *
     *
     * 示例:
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) a++;
            if (res[i] == n3) b++;
            if (res[i] == n5) c++;
        }
        return res[n - 1];
    }

    public int nthUglyNumber1(int n){
        int a = 0,b = 0,c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n;i++){
           int n2 = res[a]*2,n3 = res[b]*3,n5=res[c]*5;
           res[i] = Math.min(Math.min(n2,n3),n5);
            if (res[i] == n2){
                a++;
            }
            if (res[i] == n3){
                b++;
            }
            if (res[i] == n5){
                c++;
            }
        }
        return res[n-1];
    }
}
