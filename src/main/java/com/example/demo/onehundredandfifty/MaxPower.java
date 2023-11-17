package com.example.demo.onehundredandfifty;

/**
 * 连续字符
 */
public class MaxPower {
    /**
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     *
     * 请你返回字符串 s 的 能量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "leetcode"
     * 输出：2
     * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
     * 示例 2：
     *
     * 输入：s = "abbcccddddeeeeedcba"
     * 输出：5
     * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 只包含小写英文字母。
     */
    //思路1:分组循环
    //思路2:使用hash表存储
    public static int maxPower(String s) {
        int len = s.length();
        int res = 0;
        int i = 0;
        int size = 1;
        while (i < len){
            char left = s.charAt(i);
            i++;
            while (i < len && left==s.charAt(i)){
                i++;
                size++;
            }
            res = Math.max(res,size);
            size = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        maxPower(s);
    }
}
