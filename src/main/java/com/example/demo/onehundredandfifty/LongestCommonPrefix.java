package com.example.demo.onehundredandfifty;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     *
     * 提示：
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0){
            return prefix.append("").toString();
        }
        if (strs.length == 1){
            return strs[0];
        }
        String firstStr = strs[0];
        char[] arr = firstStr.toCharArray();
        for (int i = 0; i < arr.length;i++){
            char subArr = arr[i];
            for (int j = i+1; j < strs.length;j++){
                if (strs[j].length()-1 < i || strs[j].charAt(i)!=subArr){
                    prefix.append("");
                    return prefix.toString();
                }
            }
            prefix.append(subArr);
        }
        return prefix.append("").toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "a"};
        longestCommonPrefix(strs);
    }
}
