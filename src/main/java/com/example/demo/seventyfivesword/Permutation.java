package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串的排列
 */
public class Permutation {
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * <p>
     * <p>
     * <p>
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     */

    //回溯
    class Solution {
        List<String> rec;
        boolean[] vis;

        public String[] permutation(String s) {
            int n = s.length();
            rec = new ArrayList<String>();
            vis = new boolean[n];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);//排序
            StringBuffer perm = new StringBuffer();
            backtrack(arr, 0, n, perm);
            int size = rec.size();
            String[] recArr = new String[size];
            for (int i = 0; i < size; i++) {
                recArr[i] = rec.get(i);
            }
            return recArr;
        }

        public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
            if (i == n) {
                rec.add(perm.toString());
                return;
            }
            for (int j = 0; j < n; j++) {
                if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                    continue;
                }
                vis[j] = true;
                perm.append(arr[j]);
                backtrack(arr, i + 1, n, perm);
                perm.deleteCharAt(perm.length() - 1);//还原字符串
                vis[j] = false;//还原标志为数组
            }
        }
    }

    static List<String>  res;
    static boolean[] vis;

    public static String[] permutation(String s) {
        int n = s.length();
        res = new ArrayList<>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backTrack(arr, 0, n, perm);
        String[] resStr = new String[res.size()];
        for (int u = 0; u < res.size(); u++) {
            resStr[u] = res.get(u);
        }
        return resStr;
    }

    private static void backTrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            res.add(perm.toString());
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j] == arr[j - 1])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backTrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    public static void main(String[] args) {
        permutation("abbbbbbcdes");
    }

}
