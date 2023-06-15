package com.example.demo.ser;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/4/11
 */
public class ManacherBySelf {
    /**
     * 最长回文子串
     * @return
     */
    public String manacher(String words){
        boolean[][] dp = new boolean[words.length()][words.length()];
        //最长回文子串的最大长度
        int maxLength = 1;
        //最长回文子串的起始位置
        int maxI = 0;
        //回文字符串的长度
        for (int len = 0;len < words.length();len++){
            //回文字符串的位置
            for (int i = 0;i + len < words.length();i++){
                //长度为1是dp[][]都是true
                if (len == 0){
                    dp[i][i+len] = true;
                }else if (len == 1){
                    //长度为2时，需要两个字段相等dp[][]才为true
                    if (words.charAt(i) == words.charAt(i + 1)) {
                        dp[i][i+len] = true;
                        maxLength = len + 1;
                        maxI = i;
                    }else {
                        dp[i][i+len] = false;
                    }
                }else {
                    if (dp[i + 1][i + len -1] && words.charAt(i) == words.charAt(i + len)){
                        dp[i][i + len] = true;
                        if (len + 1 > maxLength){
                            maxLength = len + 1;
                            maxI = i;
                        }
                    }
                }
            }
        }
        return words.substring(maxI,maxI + maxLength);
    }

    public static void main(String[] args) {
        ManacherBySelf manacherBySelf = new ManacherBySelf();
        String s = manacherBySelf.manacher("abbccdcaf");
        System.out.println(s);
    }
}
