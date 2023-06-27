package com.example.demo.seventyfivesword;

/**
 *  翻转单词顺序
 */
public class ReverseWords {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public static String reverseWords(String s){
        String[] temp = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = temp.length-1; i >=0;i--){
            if (temp[i] != ""){
                res.append(temp[i] +" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords(s);
    }
}
