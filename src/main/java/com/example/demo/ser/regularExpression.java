package com.example.demo.ser;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/5/5
 */
public class regularExpression {

    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
     *
     *
     * 示例 1：
     *
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例3：
     *
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *
     *
     * 提示：
     *
     * 1 <= s.length<= 20
     * 1 <= p.length<= 30
     * s只包含从a-z的小写字母。
     * p只包含从a-z的小写字母，以及字符.和*。
     * 保证每次出现字符* 时，前面都匹配到有效的字符
     *
     * 以一个例子详解动态规划转移方程：
     * S = abbbbc
     * P = ab*d*c
     * 1. 当 i, j 指向的字符均为字母（或 '.' 可以看成一个特殊的字母）时，
     *    只需判断对应位置的字符即可，
     *    若相等，只需判断 i,j 之前的字符串是否匹配即可，转化为子问题 f[i-1][j-1].
     *    若不等，则当前的 i,j 肯定不能匹配，为 false.
     *
     *        f[i-1][j-1]   i
     *             |        |
     *    S [a  b  b  b  b][c]
     *
     *    P [a  b  *  d  *][c]
     *                      |
     *                      j
     *
     *
     * 2. 如果当前 j 指向的字符为 '*'，则不妨把类似 'a*', 'b*' 等的当成整体看待。
     *    看下面的例子
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    注意到当 'b*' 匹配完 'b' 之后，它仍然可以继续发挥作用。
     *    因此可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j]:
     *
     *          i
     *          | <--
     *    S  a [b] b  b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    另外，也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。
     *    转化为子问题 f[i][j-2]:
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P [a] b  *  d  *  c
     *       |
     *       j <--
     *
     * 3. 冗余的状态转移不会影响答案，
     *    因为当 j 指向 'b*' 中的 'b' 时, 这个状态对于答案是没有用的,
     *    原因参见评论区 稳中求胜 的解释, 当 j 指向 '*' 时,
     *    dp[i][j]只与dp[i][j-2]有关, 跳过了 dp[i][j-1].
     *
     */

    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];

        // 初期值
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填格子
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 文本串和模式串末位字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') { // 模式串末位是*
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                || dp[i - 1][j];     // *匹配1次或多次的情况
                    } else { // 模式串*的前一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
