package com.example.demo.onehundredandfifty;

import java.util.HashMap;

/**
 * 赎金信
 */
public class CanConstruct {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     *
     *
     * 示例 1：
     *
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * 示例 2：
     *
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * 示例 3：
     *
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote 和 magazine 由小写英文字母组成
     */
    //思路一：整一个hash表，统计目标的数量，让后使用包含目标去消减，最后计算hash表value的值，循环两次
    //思路二：用两个map，需要循环三次
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> resMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < ransomNote.length();i++){
            Character c = ransomNote.charAt(i);
            resMap.put(c, resMap.getOrDefault(c,0)+1);
            sum++;
        }
        for (int i = 0; i < magazine.length();i++){
            Character c = magazine.charAt(i);
            if(resMap.containsKey(c) &&resMap.get(c) != 0){
                resMap.put(c, resMap.getOrDefault(c,0)-1);
                sum--;
            }
        }
        if (sum == 0){
            return true;
        }
        return false;
    }
}
