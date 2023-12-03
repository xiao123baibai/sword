package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 构建乘积数组
 */
public class ConstructArr {
    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     *
     *
     *
     * 示例:
     *
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     *
     *
     * 提示：
     *
     * 所有元素乘积之和不会溢出 32 位整数
     * a.length <= 100000
     */
    //思路：双层循环
    public static int[] constructArr1(int[] a) {
        //存在超时的情况
        int len = a.length;
        if (len == 0){
            return new int[0];
        }
        int[] res = new int[len];
        Arrays.fill(res,1);
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                if (j != i){
                    res[i] *= a[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        constructArr1(a);
    }
    //学习到的思路：左右乘机列表，可进行简化
    public int[] constructArr2(int[] a) {
        int length = a.length;
        if (length == 0){
            return new int[0];
        }
        int[] L = new int[length];
        int[] R = new int[length];
        L[0] = 1;
        for (int i = 1;i <length;i++){
            L[i] = a[i-1]*L[i-1];
        }
        R[length - 1] = 1;
        for (int i = length-2;i >=0;i--){
            R[i] = a[i+1] * R[i+1];
        }
        int[] answer = new int[length];
        for (int i = 0;i<length;i++){
            answer[i] = L[i]*R[i];
        }
        return answer;
    }

    public int[] constructArr3(int[] a){
        int length = a.length;
        if (length == 0){
            return new int[0];
        }
        int[] L = new int[length];
        int[] R = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++){
            L[i] = a[i-1] *L[i-1];
        }
        R[length-1] = 1;
        for (int i = length - 2;i >= 0;i--){
            R[i] = a[i+1]*R[i+1];
        }
        int[] answer = new int[length];
        for (int i = 0;i < length;i++){
            answer[i] = L[i]*R[i];
        }
        return answer;
    }
}
