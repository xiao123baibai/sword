package com.example.demo.ser;

/**
 * 功能描述:回文子串
 *
 * @Author: qinlida
 * @Date: 2022/4/9
 */
public class Manacher {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     *
     */

    /**
     * 动态规划方法:动态规划法的核心是找到递推的公式--其中递归思想很重要
     * @param s
     * @return
     */
    public String dynamicProgramming(String s){
        //初始二维数组，默认全为false
        boolean[][] dp = new boolean[s.length()][s.length()];
        //暂存最长回文子串的长度
        int maxLength = 1;
        //暂存最长回文子串的起始下标
        int maxI = 0;
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                //长度为1的情况，全部为true
                if (len == 0) {
                    dp[i][i + len] = true;
                    //长度为2的情况，只有当两个元素相等时才为回文子串
                } else if (len == 1) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        dp[i][i + len] = true;
                        if (len + 1 > maxLength) {
                            maxLength = len + 1;
                            maxI = i;
                        }
                    } else {
                        dp[i][i + len] = false;
                    }
                } else {
                    if (dp[i + 1][i + len - 1] && s.charAt(i) == s.charAt(i + len)) {
                        dp[i][i + len] = true;
                        if (len + 1 > maxLength) {
                            maxLength = len + 1;
                            maxI = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxI, maxI + maxLength);
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "abccbc";
        Manacher manacher = new Manacher();
        String m = manacher.dynamicProgramming(s);
//        String manacher = dynamicProgramming(s);
        String source = manacher.longestPalindrome(s);
        int i = 5/2;
        System.out.println(i);
        System.out.println(source);
        System.out.println(m);
    }
}
