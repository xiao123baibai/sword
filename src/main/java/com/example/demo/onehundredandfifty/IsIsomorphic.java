package com.example.demo.onehundredandfifty;

import java.util.HashMap;

/**
 * 同构字符串
 */
public class IsIsomorphic {
    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     *
     *
     * 示例 1:
     *
     * 输入：s = "egg", t = "add"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * 示例 3：
     *
     * 输入：s = "paper", t = "title"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s 和 t 由任意有效的 ASCII 字符组成
     */
    //双射，单射，满射考虑遍历字符串，使用哈希表 s2t , t2s 分别记录 s→ts \rightarrow ts→t ,
    // t→st \rightarrow st→s 的映射，当发现任意「一对多」的关系时返回 false 即可。

    //思路：1、hash表存储，key为当前对应的字符串，value为下标拼接
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> s2t = new HashMap<>(),t2s = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            Character a = s.charAt(i),b = t.charAt(i);
            if ((s2t.containsKey(a) && s2t.get(a) != b) ||(t2s.containsKey(b) && t2s.get(b) != a)){
                return false;
            }
            s2t.put(a,b);
            t2s.put(b,a);
        }
        return true;
    }
}
