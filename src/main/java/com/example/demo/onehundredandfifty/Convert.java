package com.example.demo.onehundredandfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * N 字形变换
 */
public class Convert {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
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
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     */
    //使用二维数组实现字母的分布，然后一行一行循环获取最终的结果
    public static String convert(String s, int numRows) {
        int len = s.length();
        //确定二维数组的列数
        int m = len%numRows;
        int n = m > 0 ? (len/(2*numRows-2) + 1) : (len/(2*numRows-2));
        Character[][] dp = new Character[numRows][(numRows-1)*n];
        //往二维数组中存
        //使用n是因为确保多少组
        int count = 0;
        for (int i = 0; i < n;i++){
            int temp1 = 0;
            int temp2 = 1;
            while ( count >= (i)*(2*numRows - 2) && count < (i+1)*(2*numRows - 2) && count < len){
                if (count <= (2*i+1)*numRows-2*i){
                    dp[temp1][i*(numRows-1)] = s.charAt(count);
                    temp1++;
                }
                if ((2*i+1)*numRows-2*i < count && count < (i+1)*(2*numRows - 2)){
                    temp1--;
                    dp[temp1][i*(numRows-1) + temp2] = s.charAt(count);
                    temp2++;
                }
                count++;
            }
        }
        //从二维数组中取
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows;i++){
            for (int j = 0; i < (numRows-1)*n;j++){
                if (dp[i][j] != null){
                    sb.append(dp[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        convert1(s,3);
    }
    public static String convert1(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
