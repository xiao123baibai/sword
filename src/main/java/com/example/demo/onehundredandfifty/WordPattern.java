package com.example.demo.onehundredandfifty;

import java.util.HashMap;

/**
 * 单词规律
 */
public class WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     *
     *
     *
     * 示例1:
     *
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", s = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", s = "dog cat cat dog"
     * 输出: false
     *
     *
     * 提示:
     *
     * 1 <= pattern.length <= 300
     * pattern 只包含小写英文字母
     * 1 <= s.length <= 3000
     * s 只包含小写英文字母和 ' '
     * s 不包含 任何前导或尾随对空格
     * s 中每个单词都被 单个空格 分隔
     */
    //与同构相同的思路
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> p2s = new HashMap<>();
        HashMap<String,Character> s2p = new HashMap<>();
        String[] strArr = s.split(" ");
        if(pattern.length() != strArr.length){
            return false;
        }
        for (int i = 0; i < pattern.length();i++){
            Character a = pattern.charAt(i);
            String str = strArr[i];
            if (p2s.containsKey(a) && !p2s.get(a).equals(str) || s2p.containsKey(str) && s2p.get(str) != a){
                return false;
            }
            p2s.put(a,str);
            s2p.put(str,a);
        }
        return true;
    }
}
