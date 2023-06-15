package com.example.demo.seventyfivesword;

public class replaceSpace {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * @param args
     */
    public static void main(String[] args) {
        String s = "we are family.";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
