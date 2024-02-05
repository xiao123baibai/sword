package com.example.demo.onehundredandfifty;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串--有空写一遍
 */
public class FindSubstring {
    /**
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"，
     * 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
     * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
     * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
     * 输出顺序无关紧要。返回 [9,0] 也是可以的。
     * 示例 2：
     *
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
     * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
     * 所以我们返回一个空数组。
     * 示例 3：
     *
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
     * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
     * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
     * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * words[i] 和 s 由小写英文字母组成
     */

    public List<Integer> findSubString(String s,String[] words){
        int wordLength = words[0].length();
        int wordNum = words.length;
        int len = s.length();
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        //找到循环的范围，总共有两种情况，1:单词在里面， 2:单词不在里面
        Map<String,Integer> windowMap = new HashMap<>();
        for (int wordStart = 0; wordStart < wordLength;wordStart++){
            int wordLeft = wordStart;
            int wordRight = wordStart;
            while (wordRight + wordLength <= len){
                String word = s.substring(wordRight,wordRight+wordLength);
                windowMap.put(word,windowMap.getOrDefault(word,0)+1);
                wordRight += wordLength;
                while (windowMap.getOrDefault(word,0) > countMap.getOrDefault(word,0)){
                    String leftWord = s.substring(wordLeft,wordLeft + wordLength);
                    windowMap.put(leftWord,windowMap.getOrDefault(leftWord,0)-1);
                    wordLeft += wordLength;
                }
                int wordNumber = (wordRight - wordLeft)/wordLength;
                if (wordNumber == wordNum){
                    res.add(wordLeft);
                }
            }
        }
        return res;
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int wordNum =words.length;
        int len = s.length();
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> countMap = new HashMap<>();
        for (String word : words){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        for (int wordStart = 0; wordStart < wordLength;wordStart++){
            int wordLeft = wordStart;
            int wordRight = wordStart;
            Map<String,Integer> windowsMap = new HashMap<>();
            //右边窗口开始
            while (wordRight + wordLength < len){
                String word = s.substring(wordRight,wordRight+wordLength);
                windowsMap.put(word,windowsMap.getOrDefault(word,0)+1);
                wordRight += wordLength;
                while (windowsMap.getOrDefault(word,0) > countMap.getOrDefault(word,0)){
                    String leftWord = s.substring(wordLeft,wordLeft+wordLength);
                    windowsMap.put(leftWord,windowsMap.getOrDefault(word,0)-1);
                    wordLeft += wordLength;
                }
                int wordNumber = (wordRight - wordLeft)/wordLength;
                if (wordNumber == wordNum){
                    result.add(wordLeft);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        findSubstring(s,words);
    }

    //很清晰，需要多重统计，并且确定边界
    class Solution1 {
        public List<Integer> findSubstring(String s, String[] words) {
            int wordLength = words[0].length();
            int wordNum = words.length;

            int len = s.length();
            List<Integer> result = new ArrayList<>();
            Map<String, Integer> countMap = new HashMap<>();
            // 先统计Words数组中单词出现的次数
            for(String word: words) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }

            // 使用滑动窗口,统计每个窗口内单词出现的次数, 滑动窗口的起点可以固定位一个单词的长度, 因为一个单词之后的窗口都是重复的
            for(int windowStart=0; windowStart<wordLength; windowStart ++) {
                int windLeft = windowStart;
                int windRight = windowStart;

                Map<String, Integer> windowMap = new HashMap<>();
                // 这里要保证右边界能移动到最后一个字母, 所以要有等号
                while(windRight + wordLength <= len) {
                    /*
                     * 窗口右边界持续往后移动, 同时将经过的单词统计次数
                     */
                    String word = s.substring(windRight, windRight + wordLength);
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    windRight += wordLength;

                    /*
                     * 接下来是对左边界的移动处理了
                     * 因为按照设想, 如果窗口内出现了不满足条件的单词, 我们是需要将其踢出去的, 这个时候就移动左边界
                     * 判断条件就是用windowMap和countMap比较, 不满足条件有两种情况
                     * 一:
                     *      单词不在words数组中
                     * 二:
                     *      单词属于words数组中, 但是出现次数比words数组中的次数多
                     * 因此条件可以为: windowMap.getOrDefault(word,0)>countMap.getOrDefault(word,0)
                     * 此时, 我们就需要移动左边界开始剔除单词直到满足条件
                     * 另外, 如果上述if条件不满足, 就说明windRight经过的单词是满足串联子串条件的,
                     *       最终只要总的单词数量满足条件(windRight经过的单词数和words数组中的单词数相等)了,
                     *       那么windowLeft和windRight中间的字符串就是满足条件的子串
                     * windRight经过的单词数 (windRight-windLeft) / wordLength
                     */
                    while(windowMap.getOrDefault(word,0)>countMap.getOrDefault(word,0)) {
                        String leftWord = s.substring(windLeft, windLeft + wordLength);
                        windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                        windLeft += wordLength;
                    }

                    // 窗口内 单词总数
                    int wordNumInWindow = (windRight-windLeft) / wordLength;
                    if(wordNumInWindow == wordNum) {
                        result.add(windLeft);
                    }
                }
            }
            return result;
        }
    }
}
