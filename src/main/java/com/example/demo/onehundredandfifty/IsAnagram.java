package com.example.demo.onehundredandfifty;

import java.util.HashMap;

/**
 * 有效的字母异位词
 */
public class IsAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     *
     * 提示:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     *
     *
     * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    //思路：使用hash表，统计,分别统计，然后循环一个比对数据值
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            Character cs = s.charAt(i);
            Character ts = t.charAt(i);
            sMap.put(cs, sMap.getOrDefault(cs,0)+1);
            tMap.put(ts, tMap.getOrDefault(ts,0)+1);
        }
        for (Character c : sMap.keySet()){
            if (!sMap.get(c).equals(tMap.get(c))){
                return false;
            }
        }
        return true;
    }
}
