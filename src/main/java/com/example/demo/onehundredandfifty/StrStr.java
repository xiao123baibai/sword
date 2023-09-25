package com.example.demo.onehundredandfifty;

import javax.swing.text.Position;

/**
 * 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
     * 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     *
     *
     * 提示：
     *
     * 1 <= haystack.length, needle.length <= 104
     * haystack 和 needle 仅由小写英文字符组成
     */
    //思路：暴力循环解法
    public static int strStr(String haystack, String needle) {
        boolean flag = haystack.contains(needle);
        if (flag){
            int temp = 0;
            for (int i = 0; i < haystack.length();i++){
                int position = i;
                for (int j = 0; j < needle.length();j++){
                    if (haystack.charAt(position) != needle.charAt(j)){
                        temp = 0;
                        break;
                    }else {
                        temp++;
                    }
                    position++;
                    if (temp == needle.length()){
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        strStr(haystack,needle);
    }
    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
