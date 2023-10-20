package com.example.demo.onehundredandfifty;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    //思路：暴力循环没有意义只会超时
    //滑动窗口：
    public static int lengthOfLongestSubstring(String s) {
        //left 为-1很重要，因为代码都是从0开始计数的
        int left = -1,right = 0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        while (right < n){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)));//很重要
            }
            res = Math.max(res,right-left);
            map.put(s.charAt(right),right);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        lengthOfLongestSubstring(s);
    }
}
