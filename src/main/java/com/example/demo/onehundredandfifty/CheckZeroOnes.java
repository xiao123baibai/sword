package com.example.demo.onehundredandfifty;

/**
 * 哪种连续子字符串更长
 */
public class CheckZeroOnes {
    /**
     * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
     *
     * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
     * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "1101"
     * 输出：true
     * 解释：
     * 由 1 组成的最长连续子字符串的长度是 2："1101"
     * 由 0 组成的最长连续子字符串的长度是 1："1101"
     * 由 1 组成的子字符串更长，故返回 true 。
     * 示例 2：
     *
     * 输入：s = "111000"
     * 输出：false
     * 解释：
     * 由 1 组成的最长连续子字符串的长度是 3："111000"
     * 由 0 组成的最长连续子字符串的长度是 3："111000"
     * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
     * 示例 3：
     *
     * 输入：s = "110100010"
     * 输出：false
     * 解释：
     * 由 1 组成的最长连续子字符串的长度是 2："110100010"
     * 由 0 组成的最长连续子字符串的长度是 3："110100010"
     * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 100
     * s[i] 不是 '0' 就是 '1'
     */
    //思路：分组循环，分别统计0和1的最大值
    public boolean checkZeroOnes(String s) {
        if (s.length() == 1){
            if (s.charAt(0) == '0'){
                return false;
            }
            if (s.charAt(0) == '1'){
                return true;
            }
        }
        int len = s.length();
        int zeroMax = 0;
        int zeroSize = 1;
        int oneMax = 0;
        int oneSize = 1;
        int i = 0;
        while (i < len){
            char left = s.charAt(i);
            i++;
            while (i < len && left == '0' && left == s.charAt(i)){
                i++;
                zeroSize++;
            }
            while (i < len && left == '1' && left == s.charAt(i)){
                i++;
                oneSize++;
            }
            zeroMax = Math.max(zeroMax,zeroSize);
            oneMax = Math.max(oneMax,oneSize);
        }
        return oneMax > zeroMax;
    }
}
