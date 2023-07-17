package com.example.demo.seventyfivesword;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 */
public class FirstUniqChar {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例 1:
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     *
     * 输入：s = ""
     * 输出：' '
     */
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,-1);
            }else {
                map.put(c,1);
            }
        }
        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
