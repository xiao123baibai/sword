package com.example.demo.doublepointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/9/5
 */
public class minWindow {
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
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
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
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     *
     *
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     */
    class Solution1 {
        public String minWindow(String s, String t) {
            //维护s串中滑动窗口中各个字符出现次数
            Map<Character, Integer> hs = new HashMap<>();
            //维护t串中各个字符出现次数
            Map<Character, Integer> ht = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0)+1);
            }
            String ans="";
            //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
            int len=Integer.MAX_VALUE,cnt=0;
            //区间[left,right]表示当前滑动窗口
            for (int left=0,right = 0; right < s.length(); right++) {
                hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0)+1);
                //如果ht表中也包含当前字符
                if (ht.containsKey(s.charAt(right))) {
                    //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                    if (hs.get(s.charAt(right))<=ht.get(s.charAt(right))) {
                        cnt++;
                    }
                }
                //收缩滑动窗口
                //如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
                while(left < right && (!ht.containsKey(s.charAt(left)) || hs.get(s.charAt(left)) > ht.get(s.charAt(left)))){
                    hs.put(s.charAt(left),hs.get(s.charAt(left)) - 1);
                    left++;
                }
                //此时滑动窗口包含符串 t 的全部字符
                if (cnt==t.length()&&right-left+1<len) {
                    len=right-left+1;
                    ans=s.substring(left,right+1);
                }
            }
            return ans;
        }
    }
    class solution2{
        public String minWindows(String s,String t){
            Map<Character,Integer> os = new HashMap<>();
            Map<Character,Integer> ct = new HashMap<>();
            for (int i = 0; i < t.length(); i++){
                ct.put(t.charAt(i),ct.getOrDefault(t.charAt(i),0) + 1);
            }
            String ans = "";
            int len = Integer.MAX_VALUE,cnt = 0;
            for (int left = 0,right = 0;right < s.length(); right++){
                os.put(s.charAt(right), os.getOrDefault(s.charAt(right),0) + 1);
                if (ct.containsKey(s.charAt(right))){
                    if (os.get(s.charAt(right)) <= ct.get(s.charAt(right))){
                        cnt++;
                    }
                }
                //关键一步 左边移动缩减的是源字符串的长度
                while (left < right && (!ct.containsKey(s.charAt(left)) || os.get(s.charAt(left)) > ct.get(s.charAt(left)))){
                    os.put(s.charAt(left),os.get(s.charAt(left)) - 1);
                    left++;
                }
                //&& right - left + 1 < len
                if (cnt == t.length() && right - left + 1 < len){
                    len = right - left + 1;
                    ans = s.substring(left,right+1);
                }
            }
            return ans;
        }
    }


}
