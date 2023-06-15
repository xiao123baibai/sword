package com.example.demo.ser;

import java.nio.BufferUnderflowException;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/4/12
 */
public class Z {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     */

    public static String ZString(String s,int n){
        StringBuilder zString = new StringBuilder();
        int len = 0;
        //小于n
        if (s.length() < n){
            return zString.append(s).toString();
        }
        //大于n，小于2n-2
        if (s.length() < 2*n - 2){
            zString.append(UptwoN(s,n));
        }
        //大于2n-2
        for (int i = 1; i < s.length(); i++){
            len = len + (2*n - 2);
            if (s.length()  < len){
                String subs = s.substring(len - (2*n - 2),s.length());
                //直接返回
                zString.append(UptwoN(subs,n));
                return zString.toString();
            }
            String eves = s.substring(len - (2*n - 2),len);
            zString.append(Every(eves,n));
        }
        return zString.toString();
    }

    /**
     * 大于n，小于2n-2
     * @param s
     * @param n
     * @return
     */
    private static StringBuilder UptwoN(String s, int n){
        StringBuilder zString = new StringBuilder();
            for (int i = 0; i < s.length() - n;i++){
                zString.append(s.charAt(i));
                if (s.length() - n  - i > 0 && s.length() - n  - i == n - i){
                    zString.append(s.charAt(2*n -i - 1));
                }
            }
        return zString;
    }

    private static StringBuilder Every(String s, int n){
        StringBuilder zString = new StringBuilder();
        for (int i = 0; i < n;i++){
            zString.append(s.charAt(i));
            if ( s.length() - n  - i == n - i){
                zString.append(s.charAt(2*n -i));
            }
        }
        return zString;
    }

    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        System.out.println(s);
//        String results = "PINALSIGYAHRPI";
//        System.out.println(results);
//        int n = 3;
//        String answer = ZString(s,n);
//        System.out.println(answer);
        int i = 1;
        Integer in = 1;
        System.out.println(i == in);
    }
}
