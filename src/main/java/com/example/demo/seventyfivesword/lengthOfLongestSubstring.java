package com.example.demo.seventyfivesword;

import java.util.HashMap;
import java.util.Map;

/**
 * 016 - 无重复字符的最长子串
 */
public class lengthOfLongestSubstring {
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
     */

    public static void main(String[] args) {
        String s = "abcabcbb";
        int max = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                //以重复元素第一次出现的位置和left比较，确认无重复字符串的起点
                left = Math.max(left,map.get(s.charAt(i)+1));
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
