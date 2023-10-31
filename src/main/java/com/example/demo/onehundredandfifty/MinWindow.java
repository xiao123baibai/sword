package com.example.demo.onehundredandfifty;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class MinWindow {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     *
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     *
     *
     * 提示：
     *
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s 和 t 由英文字母组成
     */

    public String minWindow(String s, String t) {
        String res = "";
        if (s == null || s == "" || t == null || t == "" || t.length() > s.length()){
            return res;
        }
        Map<Character,Integer> countMap = new HashMap<>();
        Map<Character,Integer> indexMap = new HashMap<>();
        int tLength = t.length();
        int sLength = s.length();
        int left = 0;
        int right = 0;
        int start = 0;
        int count = 0;
        int min = sLength + 1;
        for (int i = 0; i < tLength; i++){
            Character c = t.charAt(i);
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        while (right < sLength){
            Character c = s.charAt(right);
            if (countMap.getOrDefault(c,0) == 0){
                right++;
                continue;
            }
            if (countMap.getOrDefault(c,0) > indexMap.getOrDefault(c,0)){
                count++;
            }
            //这行的位置很重要
            indexMap.put(c,indexMap.getOrDefault(c,0)+1);
            right++;
            while (count == tLength){
                if (right - left < min){
                    min = right -left;
                    start = left;
                }
                Character l = s.charAt(left);
                if (countMap.getOrDefault(l,0) == 0){
                    left++;
                    continue;
                }
                if (indexMap.getOrDefault(l,0)  == countMap.getOrDefault(l,0)){
                    count--;
                }
                indexMap.put(l,indexMap.getOrDefault(l,0)-1);
                left++;
            }
        }
        if (min == sLength+1){
            return res;
        }
        return s.substring(start,start+min);
    }

    public static void main(String[] args) {

    }

    public String minWindow1(String s, String t){
        String res = "";
        if (s == null || s == "" || t == null || t == "" || t.length() > s.length()){
            return res;
        }
        int[] countMap = new int[128];
        int[] indexMap = new int[128];
        int tLength = t.length();
        int sLength = s.length();
        int left = 0;
        int right = 0;
        int start = 0;
        int count = 0;
        int min = sLength + 1;
        for (int i = 0; i < tLength; i++){
            Character c = t.charAt(i);
            countMap[c]++;
        }
        while (right < sLength){
            Character c = s.charAt(right);
            if (countMap[c] == 0){
                right++;
                continue;
            }
            if (countMap[c] > indexMap[c]){
                count++;
            }
            //这行的位置很重要
            indexMap[c]++;
            right++;
            while (count == tLength){
                if (right - left < min){
                    min = right -left;
                    start = left;
                }
                Character l = s.charAt(left);
                if (countMap[l] == 0){
                    left++;
                    continue;
                }
                if (indexMap[l] == countMap[l]){
                    count--;
                }
                indexMap[l]--;
                left++;
            }
        }
        if (min == sLength+1){
            return res;
        }
        return s.substring(start,start+min);
    }
}
